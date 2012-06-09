(ns BinaryGenerator-2.core-test
  (:use clojure.test
        BinaryGenerator-2.core))

(defn binary-generator [length]
  [[]])

(deftest test-when-n-is-0-return-list-contains-empty-sequence
  (is (= [[]] (binary-generator 0))))
