(ns four-clojure-solutions.problem156
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [d keys]
   (into {} (map #(hash-map % d) keys)))
 #(= (% 0 [:a :b :c]) {:a 0 :b 0 :c 0})
 #(= (% "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})
 #(= (% [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})
 )

