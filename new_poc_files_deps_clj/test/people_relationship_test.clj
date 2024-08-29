(ns people-relationship-test
  (:require [clojure.test :refer :all]
            [datomic.api :as d]
            [people-relationship :refer :all]))

(defn -main [& args]
  (run-tests 'people-relationship-test))

(def schema [{:db/ident :person/related
               :db/valueType :db.type/ref
               :db/cardinality :db.cardinality/many
               :db/doc "A person's related people"}])

(deftest test-query-people-relationship
  (let [uri "datomic:mem://people"]
    (d/create-database uri)
    (let [conn (d/connect uri)]
      (d/transact conn schema)
      (let [person-id (d/tempid :db.part/user)]
        @(d/transact conn [{:db/id person-id :person/related 123}])
        (let [db (d/db conn)]
          (is (= #{123} (set (query-people-relationship db person-id)))))))))

(run-tests)