(ns BinaryGenerator-2.core-test
  (:use clojure.test
        BinaryGenerator-2.core))

;;; n = 1 -> ["0" "1"]
;;; n = 2 -> ["00" "01" "10" "11"]

(defn prepend-str-to-list-of-strs [prepender prependees]
  (vec (map (fn [element] (str prepender element))
            prependees)))

;;; [""] ["0" "1"] => ["0" "1"]
;;; ["0" "1"] ["0" "1"] => ["00" "01" "10" "11"]

(defn some-other-function [sequence some-strings]
  (into(vec (map (fn [element] (prepend-str-to-list-of-strs element sequence)) some-strings))))

(defn binary-generator [length]
  (cond (= length 0)  [""]

        :else
        (let [binary-seq-of-length-minus-1 (binary-generator (dec length))]
;          (some-other-function binary-seq-of-length-minus-1 [ "0" "1"]))))
          (into (prepend-str-to-list-of-strs "0" binary-seq-of-length-minus-1)
                (prepend-str-to-list-of-strs "1" binary-seq-of-length-minus-1)))))

(deftest some-other-function-works-with-empty-strings
  (is(= ["0" "1"] (some-other-function [""] ["0" "1"]))))

(deftest some-other-function-is-equivalent-to-that-into-block
  (let [binary-seq-of-length-minus-1 [""]] (is
        (= (into (prepend-str-to-list-of-strs "0" binary-seq-of-length-minus-1)
                 (prepend-str-to-list-of-strs "1" binary-seq-of-length-minus-1))
           (some-other-function binary-seq-of-length-minus-1 [ "0" "1"])))))

(deftest test-when-n-is-0-return-list-contains-empty-sequence
  (is (= [""] (binary-generator 0))))

(deftest test-when-n-is-1
  ( is (= ["0" "1"] (binary-generator 1))))

(deftest test-when-n-is-2
  ( is (= ["00" "01" "10" "11" ] (binary-generator 2))))


(deftest test-prepend-str-to-list-of-strs-prepends-0-to-list-0-1
  ( is (= [(str "0" "0") (str "0" "1")] (prepend-str-to-list-of-strs "0" ["0" "1"])))
  )

(deftest test-when-n-is-3
  ( is (= ["000" "001" "010" "011" "100" "101" "110" "111" ] (binary-generator 3))))



