(ns four-clojure-solutions.problem41
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s0 m]
   (letfn [(f [s r]
             (if (empty? s) ()
                 (let [r' (inc r)
                       s1 #(f (rest s) r')]
                   (lazy-seq (if (zero? (rem r m))
                               (s1)
                               (cons (first s) (s1)))))))]
     (f s0 1)))

 #(= (% [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
 #(= (% [:a :b :c :d :e :f] 2) [:a :c :e])
 #(= (% [1 2 3 4 5 6] 4) [1 2 3 5 6]))


