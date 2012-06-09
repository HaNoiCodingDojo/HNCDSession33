(ns BinaryGenerator-2.core-test
  (:use clojure.test
        BinaryGenerator-2.core))

;;; n = 1 -> ["0" "1"]
;;; n = 2 -> ["00" "01" "10" "11"]

(defn binary-generator [length]
  (cond (= length 0)  [""]
        (= length 1) ["0" "1"]
        (= length 2) (into ["00" "01"] ["10" "11"])))

(deftest test-when-n-is-0-return-list-contains-empty-sequence
  (is (= [""] (binary-generator 0))))

(deftest test-when-n-is-1
  ( is (= ["0" "1"] (binary-generator 1))))

(deftest test-when-n-is-2
  ( is (= ["00" "01" "10" "11" ] (binary-generator 2))))