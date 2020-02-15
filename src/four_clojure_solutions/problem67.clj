(ns four-clojure-solutions.problem67
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n]
   (letfn [(primes [used candidates]
             (let [composite? (fn [n] (some #(zero? (mod n %)) used))
                   [p & t] (drop-while composite? candidates)]
               (lazy-seq (cons p (primes (conj used p) t)))))]
     (take n (primes #{} (drop 2 (range))))))

 #(= (% 2) [2 3])
 #(= (% 5) [2 3 5 7 11])
 #(= (last (% 100)) 541))

