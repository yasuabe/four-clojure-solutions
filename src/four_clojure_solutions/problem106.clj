(ns four-clojure-solutions.problem106
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [start end]
   (letfn [(add-if [p v s] (if (p v) s (conj s v)))
           (next [r0 s0]
             (let [taken? (fn [n] (or (r0 n) (s0 n)))
                   result
                   (reduce
                    (fn [acc0 k]
                      (->> acc0
                          (add-if taken? (* k 2))
                          (add-if taken? (+ k 2))
                          (add-if #(or (odd? k) (taken? %)) (quot k 2))))
                    #{}
                    r0)]
               [result (clojure.set/union r0 s0)]))
           (rep [r0 s0 n]
             (let [[r1 s1] (if (= 1 n) [#{start} #{}] (next r0 s0))]
               (if (r1 end) n
                   (recur r1 s1 (inc n)))))]
     (rep #{} #{} 1)))

 (fn [f] (= 1 (f 1 1)))  ; 1
 (fn [f] (= 3 (f 3 12))) ; 3 6 12
 (fn [f] (= 3 (f 12 3))) ; 12 6 3
 (fn [f] (= 3 (f 5 9)))  ; 5 7 9
 (fn [f] (= 9 (f 9 2)))  ; 9 18 20 10 12 6 8 4 2
 (fn [f] (= 5 (f 9 12)))) ; 9 11 22 24 12
