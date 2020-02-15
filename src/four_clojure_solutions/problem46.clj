(ns four-clojure-solutions.problem46
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [f] #(f %2 %1))
 #(= 3 ((% nth) 2 [1 2 3 4 5]))
 #(= true ((% >) 7 8))
 #(= 4 ((% quot) 2 8))
 #(= [1 2 3] ((% take) [1 2 3 4 5] 3)))

