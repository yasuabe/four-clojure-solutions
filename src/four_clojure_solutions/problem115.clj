(ns four-clojure-solutions.problem115
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n]
   (let [f (fn [n]
             (loop [n n acc ()]
               (if (zero? n) acc
                   (recur (quot n 10) (cons (mod n 10) acc)))))
         digits (f n)
         half (quot (count digits) 2)
         l (take half digits)
         r (take half (reverse digits))]
     (= (reduce + l) (reduce + r))))

 #(= true (% 11))
 #(= true (% 121))
 #(= false (% 123))
 #(= true (% 0))
 #(= false (% 88099))
 #(= true (% 89098))
 #(= true (% 89089))
 #(= (take 20 (filter % (range)))
     [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101]))  
