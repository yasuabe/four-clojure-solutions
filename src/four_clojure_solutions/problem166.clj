(ns four-clojure-solutions.problem166
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [f b c]
   (cond (f b c) :lt
         (f c b) :gt
         :else   :eq))

 #(= :gt (% < 5 1))
 #(= :eq (% (fn [x y] (< (count x) (count y))) "pear" "plum"))
 #(= :lt (% (fn [x y] (< (mod x 5) (mod y 5))) 21 3))
 #(= :gt (% > 0 2)))





