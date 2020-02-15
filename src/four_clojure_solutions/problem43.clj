(ns four-clojure-solutions.problem43
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll n]
   (loop [res (repeat n ())
          src (reverse coll)]
     (if (empty? src) (reverse res)
         (let [[f r] (split-at n src)]
           (recur (map cons f res) r)))))
 #(= (% [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
 #(= (% (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
 #(= (% (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))))


