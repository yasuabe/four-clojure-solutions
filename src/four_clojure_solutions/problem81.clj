(ns four-clojure-solutions.problem81
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s1 s2] (set (filter s1 s2)))

 #(= (% #{0 1 2 3} #{2 3 4 5}) #{2 3})
 #(= (% #{0 1 2} #{3 4 5}) #{})
 #(= (% #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}))



