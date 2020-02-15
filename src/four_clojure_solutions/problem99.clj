(ns four-clojure-solutions.problem99
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n1 n2]
   (loop [m1 (* n1 n2)
          res []]
     (let [d (quot m1 10)
           m (rem m1 10)
           res' (cons m res)]
       (if (= 0 d) res' (recur d res')))))

 #(= (% 1 1) [1])
 #(= (% 99 9) [8 9 1])
 #(= (% 999 99) [9 8 9 0 1]))




