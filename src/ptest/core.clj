(ns ptest.core
  (:require clojure.test))

(defn run-tests
  ([] (run-tests *ns*))
  ([& namespaces]
     (let [non-parallel? (fn [ns] (:non-parallel (meta (the-ns ns))))
           parallel-nses (remove non-parallel? namespaces)
           non-parallel-nses (filter non-parallel? namespaces)
           merge-counters (partial merge-with +)
           non-parallel-counters (apply merge-counters
                                        (doall (map clojure.test/test-ns
                                                    non-parallel-nses)))
           parallel-counters (apply merge-counters
                                    (pmap (bound-fn* clojure.test/test-ns)
                                          parallel-nses))
           summary (assoc (merge-counters non-parallel-counters parallel-counters)
                     :type :summary)]
       (clojure.test/report summary)
       summary)))

(defn run-all-tests
  ([] (apply run-tests (all-ns)))
  ([re] (apply run-tests (filter #(re-matches re (name (ns-name %))) (all-ns)))))
