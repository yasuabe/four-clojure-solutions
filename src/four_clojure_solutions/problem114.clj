(ns four-clojure-solutions.problem114
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn f [n pred coll]
   (loop [coll coll
          cnt 0
          res []]
     (if (empty? coll) res
         (let [[h & t] coll
               cnt (if (pred h) (inc cnt) cnt)]
           (if (= cnt n) res
               (recur t cnt (conj res h))))))) 
 (fn [f] (= [2 3 5 7 11 13]
           (f 4 #(= 2 (mod % 3))
              [2 3 5 7 11 13 17 19 23])))
 (fn [f] (= ["this" "is" "a" "sentence"]
           (f 3 #(some #{\i} %)
              ["this" "is" "a" "sentence" "i" "wrote"])))
 (fn [f] (= ["this" "is"]
           (f 1 #{"a"}
              ["this" "is" "a" "sentence" "i" "wrote"]))))
