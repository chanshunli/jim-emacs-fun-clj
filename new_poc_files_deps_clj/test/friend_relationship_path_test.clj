(ns friend-relationship-path-test
  (:require [clojure.test :refer :all]
            [datomic.api :as d]
            [friend-relationship-path :refer :all]))

(deftest test-find-friend-path
  (let [uri "datomic:mem://friend-relationship-path"
        _ (d/create-database uri)
        conn (d/connect uri)
        schema [{:db/ident :friend
                 :db/valueType :db.type/ref
                 :db/cardinality :db.cardinality/many
                 :db/doc "A person's friends"}]
        _ (d/transact conn {:tx-data schema})
        data [{:db/id 1 :friend [2 3]}
              {:db/id 2 :friend [4]}
              {:db/id 3 :friend [4]}]
        _ (d/transact conn {:tx-data data})
        db (d/db conn)]
    (is (= (find-friend-path db 1 4) [[2] [3]]))))