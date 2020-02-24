(ns four-clojure-solutions.problem108
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [& seqs]
   (loop [seqs seqs]
     (let [heads (map first seqs)
           [hh & t] (sort-by first seqs)]
       (if (apply = heads)
         (first heads)
         (recur (cons (rest hh) t))))))
 #(= 3 (% [3 4 5]))
 #(= 4 (% [1 2 3 4 5 6 7] [0.5 3/2 4 19]))
 #(= 7 (% (range) (range 0 100 7/6) [2 3 5 7 11 13]))
 (fn [f] (= 64 (f (map #(* % % %) (range)) ;; perfect cubes
                  (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
                  (iterate inc 20))))) ;; at least as large as 20
