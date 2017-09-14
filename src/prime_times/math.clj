(ns prime-times.math)

(defn prime?
  "Returns true iff given number is prime."
  [n]
  (if (integer? n)
    (let [m (->> n Math/sqrt long)
          multiple? (fn [x]
                      (zero? (mod n x)))]
      (if (< n 2)
        false
        (->> (range 2 (inc m))
             (not-any? multiple?))))
    false))
