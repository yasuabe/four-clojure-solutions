(ns four-clojure-solutions.problem66
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [a0 b0]
   (loop [a a0
          b b0]
     (let [r (rem a b)]
       (if (zero? r) b (recur b r)))))

 #(= (% 2 4) 2)
 #(= (% 10 5) 5)
 #(= (% 5 7) 1)
 #(= (% 1023 858) 33))



