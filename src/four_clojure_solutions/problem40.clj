(ns four-clojure-solutions.problem40
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [d l]
   (loop [s (coll l)
          r (list (first l))]
     (if (empty? s)
       (reverse r)
       (let [[h & t] s] (recur t (cons h (cons d r)))))))

 #(= (% 0 [1 2 3]) [1 0 2 0 3])
 #(= (apply str (% ", " ["one" "two" "three"])) "one, two, three")
 #(= (% :z [:a :b :c :d]) [:a :z :b :z :c :z :d]))

