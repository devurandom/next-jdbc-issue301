(ns issue301-test
  (:require
    [clojure.test :refer :all]
    [clojure.java.jdbc :as cjjdbc]
    [next.jdbc :as njdbc])
  (:import
    (com.mchange.v2.c3p0 ComboPooledDataSource)))

(deftest issue301-test
  (with-open [ds (doto (ComboPooledDataSource.)
                   (.setDriverClass "org.postgresql.Driver")
                   (.setJdbcUrl "jdbc:postgresql://localhost/issue301")
                   (.setUser "issue301"))]
    (njdbc/execute! ds ["DELETE FROM table_a"])
    (njdbc/execute! ds ["DELETE FROM table_b"])
    (is (= {:id 1}
           (cjjdbc/with-db-transaction [conn {:datasource ds}]
             (cjjdbc/insert! conn "table_a" {:id 1})
             (njdbc/execute-batch! conn "INSERT INTO table_b (fkey) VALUES (?)" [[1]] nil)
             (njdbc/execute-one! conn ["SELECT * FROM table_b WHERE fkey = 1"]))))))

(deftest issue301-workaround-test
  (with-open [ds (doto (ComboPooledDataSource.)
                   (.setDriverClass "org.postgresql.Driver")
                   (.setJdbcUrl "jdbc:postgresql://localhost/issue301")
                   (.setUser "issue301"))]
    (njdbc/execute! ds ["DELETE FROM table_a"])
    (njdbc/execute! ds ["DELETE FROM table_b"])
    (is (= {:table_b/fkey 1}
           (cjjdbc/with-db-transaction [conn {:datasource ds}]
             (cjjdbc/insert! conn "table_a" {:id 1})
             (njdbc/execute-batch! (:connection conn) "INSERT INTO table_b (fkey) VALUES (?)" [[1]] nil)
             (njdbc/execute-one! (:connection conn) ["SELECT * FROM table_b WHERE fkey = 1"]))))))
