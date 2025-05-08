# How to reproduce

1. In one terminal run: `./bin/compose up`
2. In another termina run: `./bin/kaocha`

# Exception

```
ERROR in issue301-test/issue301-test (BatchResultHandler.java:186)
Exception: java.sql.BatchUpdateException: Batch entry 0 INSERT INTO table_b (fkey) VALUES (('1'::int8)) was aborted: ERROR: insert or update on table "table_b" violates foreign key constraint "table_b_fkey_fkey"
  Detail: Key (fkey)=(1) is not present in table "table_a".  Call getNextException to see other errors in the batch.
 at org.postgresql.jdbc.BatchResultHandler.handleCompletion (BatchResultHandler.java:186)
    org.postgresql.core.v3.QueryExecutorImpl.execute (QueryExecutorImpl.java:591)
    org.postgresql.jdbc.PgStatement.internalExecuteBatch (PgStatement.java:889)
    org.postgresql.jdbc.PgStatement.executeBatch (PgStatement.java:913)
    org.postgresql.jdbc.PgPreparedStatement.executeBatch (PgPreparedStatement.java:1739)
    com.mchange.v2.c3p0.impl.NewProxyPreparedStatement.executeBatch (NewProxyPreparedStatement.java:2544)
    next.jdbc$execute_batch_BANG_$fn__7581.invoke (jdbc.clj:347)
    ...
    next.jdbc$execute_batch_BANG_.invokeStatic (jdbc.clj:342)
    next.jdbc$execute_batch_BANG_.invoke (jdbc.clj:296)
    next.jdbc$execute_batch_BANG_.invokeStatic (jdbc.clj:359)
    next.jdbc$execute_batch_BANG_.invoke (jdbc.clj:296)
    next.jdbc$execute_batch_BANG_.invokeStatic (jdbc.clj:361)
    next.jdbc$execute_batch_BANG_.invoke (jdbc.clj:296)
    issue301_test$fn__7646$fn__7648.invoke (issue301_test.clj:20)
    clojure.java.jdbc$db_transaction_STAR_.invokeStatic (jdbc.clj:807)
    clojure.java.jdbc$db_transaction_STAR_.invoke (jdbc.clj:776)
    clojure.java.jdbc$db_transaction_STAR_.invokeStatic (jdbc.clj:852)
    clojure.java.jdbc$db_transaction_STAR_.invoke (jdbc.clj:776)
    clojure.java.jdbc$db_transaction_STAR_.invokeStatic (jdbc.clj:789)
    clojure.java.jdbc$db_transaction_STAR_.invoke (jdbc.clj:776)
    issue301_test$fn__7646.invokeStatic (issue301_test.clj:17)
    issue301_test/fn (issue301_test.clj:9)
    kaocha.type.var$test_var.invokeStatic (var.clj:24)
    kaocha.type.var$test_var.invoke (var.clj:20)
    kaocha.type.var$eval7673$fn__7675$wrapped_test__7678.invoke (var.clj:36)
    kaocha.plugin.capture_output$capture_output_pre_test_hook$fn__2257$fn__2258.invoke (capture_output.cljc:97)
    kaocha.type.var$eval7673$fn__7675.invoke (var.clj:38)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249$fn__2250.invoke (capture_output.cljc:88)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249.doInvoke (capture_output.cljc:88)
    ...
    kaocha.testable$run.invokeStatic (testable.clj:129)
    kaocha.testable$run.invoke (testable.clj:120)
    kaocha.testable$run_testable.invokeStatic (testable.clj:211)
    kaocha.testable$run_testable.invoke (testable.clj:158)
    kaocha.testable$run_testables.invokeStatic (testable.clj:224)
    kaocha.testable$run_testables.invoke (testable.clj:214)
    kaocha.type.ns$run_tests$fn__3527.invoke (ns.clj:21)
    ...
    kaocha.type.ns$run_tests.invokeStatic (ns.clj:21)
    kaocha.type.ns$run_tests.invoke (ns.clj:16)
    kaocha.type.ns$eval3545$fn__3546.invoke (ns.clj:61)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249$fn__2250.invoke (capture_output.cljc:88)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249.doInvoke (capture_output.cljc:88)
    ...
    kaocha.testable$run.invokeStatic (testable.clj:129)
    kaocha.testable$run.invoke (testable.clj:120)
    kaocha.testable$run_testable.invokeStatic (testable.clj:211)
    kaocha.testable$run_testable.invoke (testable.clj:158)
    kaocha.testable$run_testables.invokeStatic (testable.clj:224)
    kaocha.testable$run_testables.invoke (testable.clj:214)
    kaocha.test_suite$run.invokeStatic (test_suite.clj:7)
    kaocha.test_suite$run.invoke (test_suite.clj:5)
    kaocha.type.clojure.test$eval4956$fn__4957.invoke (test.clj:18)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249$fn__2250.invoke (capture_output.cljc:88)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249.doInvoke (capture_output.cljc:88)
    ...
    kaocha.testable$run.invokeStatic (testable.clj:129)
    kaocha.testable$run.invoke (testable.clj:120)
    kaocha.testable$run_testable.invokeStatic (testable.clj:211)
    kaocha.testable$run_testable.invoke (testable.clj:158)
    kaocha.testable$run_testables.invokeStatic (testable.clj:224)
    kaocha.testable$run_testables.invoke (testable.clj:214)
    kaocha.api$run$fn__3281$fn__3285$fn__3286.invoke (api.clj:159)
    ...
    kaocha.api$run$fn__3281$fn__3285.invoke (api.clj:133)
    ...
    kaocha.api$run$fn__3281.invoke (api.clj:132)
    ...
    kaocha.api$run.invokeStatic (api.clj:110)
    kaocha.api$run.invoke (api.clj:97)
    kaocha.runner$run$fn__3344.invoke (runner.clj:131)
    ...
    kaocha.runner$run.invokeStatic (runner.clj:129)
    kaocha.runner$run.invoke (runner.clj:72)
    kaocha.runner$_main_STAR_.invokeStatic (runner.clj:165)
    kaocha.runner$_main_STAR_.doInvoke (runner.clj:143)
    ...
    kaocha.runner$_main.invokeStatic (runner.clj:176)
    kaocha.runner$_main.doInvoke (runner.clj:174)
    ...
Caused by: org.postgresql.util.PSQLException: ERROR: insert or update on table "table_b" violates foreign key constraint "table_b_fkey_fkey"
  Detail: Key (fkey)=(1) is not present in table "table_a".
 at org.postgresql.core.v3.QueryExecutorImpl.receiveErrorResponse (QueryExecutorImpl.java:2733)
    org.postgresql.core.v3.QueryExecutorImpl.processResults (QueryExecutorImpl.java:2420)
    org.postgresql.core.v3.QueryExecutorImpl.execute (QueryExecutorImpl.java:580)
    org.postgresql.jdbc.PgStatement.internalExecuteBatch (PgStatement.java:889)
    org.postgresql.jdbc.PgStatement.executeBatch (PgStatement.java:913)
    org.postgresql.jdbc.PgPreparedStatement.executeBatch (PgPreparedStatement.java:1739)
    com.mchange.v2.c3p0.impl.NewProxyPreparedStatement.executeBatch (NewProxyPreparedStatement.java:2544)
    next.jdbc$execute_batch_BANG_$fn__7581.invoke (jdbc.clj:347)
    ...
    next.jdbc$execute_batch_BANG_.invokeStatic (jdbc.clj:342)
    next.jdbc$execute_batch_BANG_.invoke (jdbc.clj:296)
    next.jdbc$execute_batch_BANG_.invokeStatic (jdbc.clj:359)
    next.jdbc$execute_batch_BANG_.invoke (jdbc.clj:296)
    next.jdbc$execute_batch_BANG_.invokeStatic (jdbc.clj:361)
    next.jdbc$execute_batch_BANG_.invoke (jdbc.clj:296)
    issue301_test$fn__7646$fn__7648.invoke (issue301_test.clj:20)
    clojure.java.jdbc$db_transaction_STAR_.invokeStatic (jdbc.clj:807)
    clojure.java.jdbc$db_transaction_STAR_.invoke (jdbc.clj:776)
    clojure.java.jdbc$db_transaction_STAR_.invokeStatic (jdbc.clj:852)
    clojure.java.jdbc$db_transaction_STAR_.invoke (jdbc.clj:776)
    clojure.java.jdbc$db_transaction_STAR_.invokeStatic (jdbc.clj:789)
    clojure.java.jdbc$db_transaction_STAR_.invoke (jdbc.clj:776)
    issue301_test$fn__7646.invokeStatic (issue301_test.clj:17)
    issue301_test/fn (issue301_test.clj:9)
    kaocha.type.var$test_var.invokeStatic (var.clj:24)
    kaocha.type.var$test_var.invoke (var.clj:20)
    kaocha.type.var$eval7673$fn__7675$wrapped_test__7678.invoke (var.clj:36)
    kaocha.plugin.capture_output$capture_output_pre_test_hook$fn__2257$fn__2258.invoke (capture_output.cljc:97)
    kaocha.type.var$eval7673$fn__7675.invoke (var.clj:38)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249$fn__2250.invoke (capture_output.cljc:88)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249.doInvoke (capture_output.cljc:88)
    ...
    kaocha.testable$run.invokeStatic (testable.clj:129)
    kaocha.testable$run.invoke (testable.clj:120)
    kaocha.testable$run_testable.invokeStatic (testable.clj:211)
    kaocha.testable$run_testable.invoke (testable.clj:158)
    kaocha.testable$run_testables.invokeStatic (testable.clj:224)
    kaocha.testable$run_testables.invoke (testable.clj:214)
    kaocha.type.ns$run_tests$fn__3527.invoke (ns.clj:21)
    ...
    kaocha.type.ns$run_tests.invokeStatic (ns.clj:21)
    kaocha.type.ns$run_tests.invoke (ns.clj:16)
    kaocha.type.ns$eval3545$fn__3546.invoke (ns.clj:61)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249$fn__2250.invoke (capture_output.cljc:88)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249.doInvoke (capture_output.cljc:88)
    ...
    kaocha.testable$run.invokeStatic (testable.clj:129)
    kaocha.testable$run.invoke (testable.clj:120)
    kaocha.testable$run_testable.invokeStatic (testable.clj:211)
    kaocha.testable$run_testable.invoke (testable.clj:158)
    kaocha.testable$run_testables.invokeStatic (testable.clj:224)
    kaocha.testable$run_testables.invoke (testable.clj:214)
    kaocha.test_suite$run.invokeStatic (test_suite.clj:7)
    kaocha.test_suite$run.invoke (test_suite.clj:5)
    kaocha.type.clojure.test$eval4956$fn__4957.invoke (test.clj:18)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249$fn__2250.invoke (capture_output.cljc:88)
    ...
    kaocha.plugin.capture_output$capture_output_wrap_run_hook$fn__2249.doInvoke (capture_output.cljc:88)
    ...
    kaocha.testable$run.invokeStatic (testable.clj:129)
    kaocha.testable$run.invoke (testable.clj:120)
    kaocha.testable$run_testable.invokeStatic (testable.clj:211)
    kaocha.testable$run_testable.invoke (testable.clj:158)
    kaocha.testable$run_testables.invokeStatic (testable.clj:224)
    kaocha.testable$run_testables.invoke (testable.clj:214)
    kaocha.api$run$fn__3281$fn__3285$fn__3286.invoke (api.clj:159)
    ...
    kaocha.api$run$fn__3281$fn__3285.invoke (api.clj:133)
    ...
    kaocha.api$run$fn__3281.invoke (api.clj:132)
    ...
    kaocha.api$run.invokeStatic (api.clj:110)
    kaocha.api$run.invoke (api.clj:97)
    kaocha.runner$run$fn__3344.invoke (runner.clj:131)
    ...
    kaocha.runner$run.invokeStatic (runner.clj:129)
    kaocha.runner$run.invoke (runner.clj:72)
    kaocha.runner$_main_STAR_.invokeStatic (runner.clj:165)
    kaocha.runner$_main_STAR_.doInvoke (runner.clj:143)
    ...
    kaocha.runner$_main.invokeStatic (runner.clj:176)
    kaocha.runner$_main.doInvoke (runner.clj:174)
    ...
╭───── Test output ───────────────────────────────────────────────────────
│ SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
│ SLF4J: Defaulting to no-operation (NOP) logger implementation
│ SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
│ MLog initialization issue: slf4j found no binding or threatened to use its (dangerously silent) NOPLogger. We consider the slf4j library not found.
│ May 08, 2025 4:31:09 PM com.mchange.v2.log.MLog
│ INFO: MLog clients using java 1.4+ standard logging.
│ May 08, 2025 4:31:09 PM com.mchange.v2.c3p0.C3P0Registry
│ INFO: Initializing c3p0-0.9.5.5 [built 11-December-2019 22:18:33 -0800; debug? true; trace: 10]
│ May 08, 2025 4:31:09 PM com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource
│ INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 3, acquireRetryAttempts -> 30, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgf046ba1cx32t11g5w3v8|4f63909f, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> org.postgresql.Driver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgf046ba1cx32t11g5w3v8|4f63909f, idleConnectionTestPeriod -> 0, initialPoolSize -> 3, jdbcUrl -> jdbc:postgresql://localhost/issue301, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 15, maxStatements -> 0, maxStatementsPerConnection -> 0, minPoolSize -> 3, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
│ {:datasource #object[com.mchange.v2.c3p0.ComboPooledDataSource 0x4f63909f com.mchange.v2.c3p0.ComboPooledDataSource[ identityToken -> 1hgf046ba1cx32t11g5w3v8|4f63909f, dataSourceName -> 1hgf046ba1cx32t11g5w3v8|4f63909f ]], :connection #object[com.mchange.v2.c3p0.impl.NewProxyConnection 0xcdc09d com.mchange.v2.c3p0.impl.NewProxyConnection@cdc09d [wrapping: org.postgresql.jdbc.PgConnection@31c29db1]], :level 1, :rollback #object[clojure.lang.Atom 0x58829c2c {:status :ready, :val false}]}
╰─────────────────────────────────────────────────────────────────────────
1 tests, 1 assertions, 1 errors, 0 failures.
```
