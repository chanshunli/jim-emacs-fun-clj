(ns friend-relationship-path
  (:require [datomic.api :as d]))

(defn find-friend-path [db start end]
  (let [query '[:find ?p :in $ ?start ?end :where
                [?start :friend ?p]
                [?p :friend ?end]]]
    (d/q query db start end)))