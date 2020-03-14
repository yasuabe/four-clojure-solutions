(ns four-clojure-solutions.problem62
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [g init]
   (letfn [(f [a]
             (lazy-seq (cons a (f (g a)))))]
     (f init))) 

 (fn [f] (= (take 5 (f #(* 2 %) 1)) [1 2 4 8 16]))
 (fn [f] (= (take 100 (f inc 0)) (take 100 (range))))
 (fn [f] (= (take 9 (f #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))))

