(ns BinaryGenerator-2.core-test
  (:use clojure.test
        BinaryGenerator-2.core))

;;; n = 1 -> ["0" "1"]
;;; n = 2 -> ["00" "01" "10" "11"]

(defn binary-generator [length]
  [""])

(deftest test-when-n-is-0-return-list-contains-empty-sequence
  (is (= [""] (binary-generator 0))))
