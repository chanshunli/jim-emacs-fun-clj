(ns query-notes-2024-test
  (:require [clojure.test :refer :all]
            [query-notes-2024 :refer :all]))

(deftest test-query-notes-2024
  (testing "Query notes for 2024"
    (let [results (query-notes-2024)]
      (is (not (empty? results)))
      (is (every? #(instance? java.util.Map %) results))
      (is (every? #(= 2024 (.getYear (.toInstant (:note/created-at %)))) results)))))

(defn -main []
  (run-tests 'query-notes-2024-test))