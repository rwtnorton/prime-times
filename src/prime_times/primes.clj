(ns prime-times.primes)

(defn prime?
  "Returns true iff given number is prime."
  [n]
  (let [m (->> n Math/sqrt long)
        multiple? (fn [x]
                    (zero? (mod n x)))]
    (if (< n 2)
      false
      (->> (range 2 (inc m))
           (not-any? multiple?))))

  #_(let [f (fn [num-primes]
            (let [prime?
                  (fn [n]
                    (let [m (->> n Math/sqrt long)
                          multiple? (fn [x]
                                      (zero? (mod n x)))]
                      (if (< n 2)
                        false
                        (->> (range 2 (inc m))
                             (not-any? multiple?)))))]
              (take num-primes (filter prime? (range)))))]
    (is (all? (p67 f)))))

