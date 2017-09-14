(ns prime-times.tabular
  (:require [prime-times.products :as products]
            [clojure.string :as str]))

;; Shamelessly "borrowed" from clojure.pprint/print-table and modified.
(defn print-table
  [ks rows]
  (when (seq rows)
    (let [ks' (cons "" ks)
          rows' (cons ks'
                      (map (fn [k row] (cons k row)) ks rows))
          widths (reduce (fn [acc row]
                           (let [ws (map (comp count str) row)]
                             (map max ws acc)))
                         (map (comp count str) ks')
                         rows')
          spacers (map #(apply str (repeat % "-")) widths)
          fmts (map #(str "%" % "s") widths)
          fmt-row (fn [leader nexter divider trailer row]
                    (str leader
                         (format (first fmts) (first row))
                         nexter
                         (str/join divider
                                   (for [[col fmt] (map vector (rest row) (rest fmts))]
                                     (format fmt (str col))))
                         trailer))]
      (println (fmt-row "" " | "  " | " "" ks'))
      (println (fmt-row "" "-X-" "-+-" "" spacers))
      (doseq [row (rest rows')]
        (println (fmt-row "" " | " " | " "" row))))))

(defn tablify
  "Returns a string of a formatted multiplication table, with vs
   as the row and column headers."
  [vs]
  (let [rows (products/times-table vs)]
    (with-out-str (print-table vs rows))))
