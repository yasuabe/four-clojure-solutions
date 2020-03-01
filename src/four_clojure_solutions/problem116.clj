(ns four-clojure-solutions.problem116
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n]
   (let [primes
         (letfn [(f [used candidates]
                   (let [composite? (fn [n] (some #(zero? (mod n %)) used))
                         [p & t] (drop-while composite? candidates)]
                     (lazy-seq (cons p (f (conj used p) t)))))]
           (f #{2} (map #(+ 3 (* 2 %)) (range))))
         [a b c] (first
                  (drop-while
                   #(< (second %) n)
                   (map vector primes (rest primes) (rest (rest primes)))))]
     (= n b (/ (+ a c) 2))))

 (fn [f] (= false (f 4)))
 (fn [f] (= true (f 563)))
 (fn [f] (= 1103 (nth (filter f (range)) 15))))
