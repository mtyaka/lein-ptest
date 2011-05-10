(ns leiningen.ptest
  (:require leiningen.test))

;; bootclasspath workaround: http://dev.clojure.org/jira/browse/CLJ-673
(require '[clojure template stacktrace test])
(require 'ptest.core)

(defn ptest
  "Run the project's tests in parallel.

Accepts either a list of test namespaces to run or a list of test
selectors. With no arguments, runs all tests."
  [project & tests]
  (binding [clojure.test/run-tests ptest.core/run-tests]
    (apply leiningen.test/test project tests)))
