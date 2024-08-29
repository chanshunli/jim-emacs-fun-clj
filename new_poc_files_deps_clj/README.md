$ clj -X:test

```sh
WARNING: requiring-resolve already refers to: #'clojure.core/requiring-resolve in namespace: datomic.common, being replaced by: #'datomic.common/requiring-resolve

Testing people-relationship-test

FAIL in (test-query-people-relationship) (people_relationship_test.clj:22)
expected: (= #{123} (set (query-people-relationship db person-id)))
  actual: (not (= #{123} #{}))

Ran 1 tests containing 1 assertions.
1 failures, 0 errors.

Testing people-relationship-test

FAIL in (test-query-people-relationship) (people_relationship_test.clj:22)
expected: (= #{123} (set (query-people-relationship db person-id)))
  actual: (not (= #{123} #{}))

Ran 1 tests containing 1 assertions.
1 failures, 0 errors.
```

