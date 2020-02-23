(ns four-clojure-solutions.problem144
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [init-val & functions]
   (let [fs (lazy-seq (flatten (repeat functions)))]
     (reductions #(%2 %1) init-val fs)))

 (fn [f] (= (take 3 (f 3.14 int double)) [3.14 3 3.0]))
 (fn [f] (= (take 5 (f 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7]))
 (fn [f] (= (take 12 (f 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])))
