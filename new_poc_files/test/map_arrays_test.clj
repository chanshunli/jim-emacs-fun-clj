(ns map-arrays-test
  (:require [clojure.test :refer :all]
            [map-arrays :refer :all]))

(deftest test-map-arrays
  (testing "Mapping over an array with an increment function"
    (is (= [2 3 4] (map-arrays inc [1 2 3]))))
  (testing "Mapping over an array with a square function"
    (is (= [1 4 9] (map-arrays #(* % %) [1 2 3]))))
  (testing "Mapping over an array with a square function"
    (is (= [1 4 9] (map-arrays #(* % %) [1 2 3 111111]))))
  (testing "Mapping over an empty array"
    (is (= [] (map-arrays inc [])))))

(run-tests)
