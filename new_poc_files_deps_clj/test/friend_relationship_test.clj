(ns friend-relationship-test
  (:require [clojure.test :refer :all]
            [datomic.api :as d]
            [friend-relationship :refer :all]))

(deftest test-find-friend-path
  (let [conn (d/connect "datomic:mem://friend-relationship")
        db (d/db conn)
        start (d/tempid :db.part/user)
        end (d/tempid :db.part/user)
        friend (d/tempid :db.part/user)]
    (d/transact conn [{:db/id start :friend friend}
                      {:db/id friend :friend end}])
    (is (= (find-friend-path db start end) [[friend end]]))))

(run-tests)