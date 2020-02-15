(ns four-clojure-solutions.problem83
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [& bs]
   (= (every? true? bs) (every? false? bs)))

 #(= false (% false false))
 #(= true (% true false))
 #(= false (% true))
 #(= true (% false true false))
 #(= false (% true true true))
 #(= true (% true true true false)))


