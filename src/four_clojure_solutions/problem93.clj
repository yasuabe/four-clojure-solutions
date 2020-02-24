(ns four-clojure-solutions.problem90
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn f [s]
   (if (every? coll? s)
     (apply concat (map f s))
     (list s)))
 #(= (% [["Do"] ["Nothing"]])
     [["Do"] ["Nothing"]])
 #(= (% [[[[:a :b]]] [[:c :d]] [:e :f]])
     [[:a :b] [:c :d] [:e :f]])
 #(= (% '((1 2)((3 4)((((5 6)))))))
     '((1 2)(3 4)(5 6))))
