(ns query-notes-2024
  (:require [datomic.api :as d]))

(def db-uri "datomic:sql://xxxxxxxxx-datomic?jdbc:postgresql://localhost:5432/xxxxxxxxxpro?user=postgrest&password=123456")

(defn query-notes-2024 []
  (let [conn (d/connect db-uri)
        db (d/db conn)
        query '[:find ?e ?title ?created-at
                :where
                [?e :note/created-at ?created-at]
                [(>= ?created-at #inst "2024-01-01T00:00:00.000-00:00")]
                [(< ?created-at #inst "2025-01-01T00:00:00.000-00:00")]
                [?e :note/title ?title]]]
    (d/q query db)))
