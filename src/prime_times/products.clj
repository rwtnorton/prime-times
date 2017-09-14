(ns prime-times.products
  (:require [clojure.math.combinatorics :as combo]))

(defn times-table
  "Returns a seq of seqs representing the products of vs against itself."
  [vs]
  {:pre [(every? integer? vs)]}
  (->> (combo/cartesian-product vs vs)
       (map (partial apply *'))
       (partition (count vs))))
