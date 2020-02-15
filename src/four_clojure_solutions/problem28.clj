(ns four-clojure-solutions.problem28
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll]
   (letfn
       [(f [l]
          (if (empty? l) l
              (let [[h & t] l
                    u (f t)]
                (if (coll? h)
                  (concat (f h) u)
                  (cons h u)))))]
     (f coll)))

 #(= (% '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
 #(= (% ["a" ["b"] "c"]) '("a" "b" "c"))
 #(= (% '((((:a))))) '(:a)))
