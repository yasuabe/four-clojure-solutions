(ns four-clojure-solutions.problem44
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n coll]
   (let [m (mod n (count coll))
         [f r] (split-at m coll)] (concat r f)))

 #(= (% 2 [1 2 3 4 5]) '(3 4 5 1 2))
 #(= (% -2 [1 2 3 4 5]) '(4 5 1 2 3))
 #(= (% 6 [1 2 3 4 5]) '(2 3 4 5 1))
 #(= (% 1 '(:a :b :c)) '(:b :c :a))
 #(= (% -4 '(:a :b :c)) '(:c :a :b)))

