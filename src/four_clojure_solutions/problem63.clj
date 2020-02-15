(ns four-clojure-solutions.problem63
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [f coll]
   (loop [rest' coll
          result {}]
     (if (empty? rest')
       result
       (let [[h & t] rest']
         (recur t (merge-with into result {(f h) [h]}))))))

 (fn [f] (= (f #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]}))
 (fn [f] (= (f #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
             {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}))
 #(= (% count [[1] [1 2] [3] [1 2 3] [2 3]])
     {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}))




