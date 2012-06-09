(ns BinaryGenerator-2.core-test
  (:use clojure.test
        BinaryGenerator-2.core))

;;; n = 1 -> ["0" "1"]
;;; n = 2 -> ["00" "01" "10" "11"]

(defn prepend-str-to-list-of-strs [prepender prependees]
  (vec (map (fn [element] (str prepender element))
            prependees)))

(defn binary-generator [length]
  (cond (= length 0)  [""]
        (= length 1) ["0" "1"]
        (= length 2)
        (into (prepend-str-to-list-of-strs "0" ["0" "1"])
              (prepend-str-to-list-of-strs "1" ["0" "1"]))))

(deftest test-when-n-is-0-return-list-contains-empty-sequence
  (is (= [""] (binary-generator 0))))

(deftest test-when-n-is-1
  ( is (= ["0" "1"] (binary-generator 1))))

(deftest test-when-n-is-2
  ( is (= ["00" "01" "10" "11" ] (binary-generator 2))))


(deftest test-prepend-str-to-list-of-strs-prepends-0-to-list-0-1
  ( is (= [(str "0" "0") (str "0" "1")] (prepend-str-to-list-of-strs "0" ["0" "1"])))
)