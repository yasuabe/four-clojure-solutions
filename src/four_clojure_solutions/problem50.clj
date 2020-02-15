(ns four-clojure-solutions.problem50
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (comp vals #(group-by type %))

 #(= (set (% [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
 #(= (set (% [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
 #(= (set (% [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}))


