(ns four-clojure-solutions.problem58
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [& fs]
   (fn [& args]
     (let [[fh & ft] (reverse fs)]
       (reduce #(%2 %1) (apply fh args) ft))))
 #(= [3 2 1] ((% rest reverse) [1 2 3 4]))
 #(= 5 ((% (partial + 3) second) [1 2 3 4]))
 (fn [f] (= true ((f zero? #(mod % 8) +) 3 5 7 9)))
 (fn [f] (= "HELLO" ((f #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))
