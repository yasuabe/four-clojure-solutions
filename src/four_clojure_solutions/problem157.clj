(ns four-clojure-solutions.problem157
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [seq]
   (map vector seq (range)))

 #(= (% [:a :b :c]) [[:a 0] [:b 1] [:c 2]])
 #(= (% [0 1 3]) '((0 0) (1 1) (3 2)))
 #(= (% [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]]))



