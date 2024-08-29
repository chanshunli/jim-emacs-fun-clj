(ns friend-relationship
  (:require [datomic.api :as d]))

(defn find-friend-path [db start end]
  (d/q '[:find ?path
         :in $ ?start ?end
         :where
         [?start :friend ?friend]
         [(path ?friend ?end) ?path]]
       db start end))