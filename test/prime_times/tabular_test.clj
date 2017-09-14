(ns prime-times.tabular-test
  (:require [clojure.test :refer :all]
            [prime-times.tabular :as tabs]))

(deftest tablify
  (are [vs expected] (= (tabs/tablify vs) expected)
    [] ""
    [1] (->> ["  | 1"
              "--X--"
              "1 | 1"]
             (map (fn [s] (str s "\n")))
             (apply str))
    (map inc (range 5)) (->> ["  | 1 |  2 |  3 |  4 |  5"
                              "--X---+----+----+----+---"
                              "1 | 1 |  2 |  3 |  4 |  5"
                              "2 | 2 |  4 |  6 |  8 | 10"
                              "3 | 3 |  6 |  9 | 12 | 15"
                              "4 | 4 |  8 | 12 | 16 | 20"
                              "5 | 5 | 10 | 15 | 20 | 25"]
                             (map (fn [s] (str s "\n")))
                             (apply str))))
