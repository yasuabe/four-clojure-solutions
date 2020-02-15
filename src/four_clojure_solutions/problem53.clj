(ns four-clojure-solutions.problem53
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll]
   (let [sub-seqs
         (loop [incs `((~(first coll)))
                src (rest coll)]
           (if (empty? src) (reverse incs)
               (let [[srch & srct] src
                     [inch & inct] incs]
                 (recur
                  (if (= (inc (first inch)) srch)
                    (cons (cons srch inch) inct)
                    (cons `(~srch) incs))
                  srct))))
         grouped-incs (dissoc (group-by count sub-seqs) 1)]
     (if (empty? grouped-incs) []
         (reverse (first (val (apply max-key key grouped-incs)))))) )

 #(= (% [1 0 1 2 3 0 4 5]) [0 1 2 3])
 #(= (% [5 6 1 3 2 7]) [5 6])
 #(= (% [2 3 3 4 5]) [3 4 5])
 #(= (% [7 6 5 4]) []))
