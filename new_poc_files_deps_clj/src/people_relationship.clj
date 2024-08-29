(ns people-relationship
  (:require [datomic.api :as d]))

(defn query-people-relationship [db person-id]
  (d/q '[:find ?related-person
         :in $ ?person-id
         :where [?person-id :person/related ?related-person]]
       db person-id))