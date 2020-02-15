(ns four-clojure-solutions.problem59
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [& fs]
   (fn [& args] (map #(apply % args) fs)))

 #(= [21 6 1] ((% + max min) 2 3 5 1 6 4))
 (fn [f] (= ["HELLO" 5] ((f #(.toUpperCase %) count) "hello")))
 #(= [2 6 4] ((% :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})))
