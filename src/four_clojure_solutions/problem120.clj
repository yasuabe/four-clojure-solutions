(ns four-clojure-solutions.problem120
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll]
   (letfn [(f [n]
             (loop [m n
                    res 0]
               (if (zero? m)
                 res
                 (let [q (quot m 10)
                       r (rem m 10)]
                   (recur q (+ res (* r r)))))))
           (count-if [pred coll]
             (reduce (fn [cnt val] (if (pred val) (inc cnt) cnt)) 0 coll))]
     (count-if #(< % (f %)) coll)))

 #(= 8 (% (range 10)))
 #(= 19 (% (range 30)))
 #(= 50 (% (range 100)))
 #(= 50 (% (range 1000))))


