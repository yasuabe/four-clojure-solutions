(ns four-clojure-solutions.problem26
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
  (fn [n]
    (letfn [(fib [a b] (lazy-seq (cons a (fib b (+ a b)))))]
      (take n (fib 1 1))))
 
 #(= (% 3) '(1 1 2))
 #(= (% 6) '(1 1 2 3 5 8))
 #(= (% 8) '(1 1 2 3 5 8 13 21)))


