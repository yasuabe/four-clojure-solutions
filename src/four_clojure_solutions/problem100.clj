(ns four-clojure-solutions.problem100
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [& args]
   (let [gcd (fn [a b] (if (zero? b) a (recur b (rem a b))))
         lcm (fn [a b] (/ (* a b) (gcd a b)))
         rat (fn [n]
               (if (ratio? n) [(numerator n) (denominator n)] [n 1]))
         lcm' (fn [r1 r2]
                (let [[n1 d1] (rat r1)
                      [n2 d2] (rat r2)]
                  (/ (lcm (* n1 d2) (* n2 d1)) (* d1 d2))))]
     (reduce lcm' args)))
 
 #(== (% 2 3) 6)
 #(== (% 5 3 7) 105)
 #(== (% 1/3 2/5) 2)
 #(== (% 3/4 1/6) 3/2)
 #(== (% 7 5/7 2 3/5) 210))
