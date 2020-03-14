(ns four-clojure-solutions.problem131
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [& edges]
   (letfn [(g [ns]
             (let [[nh & nt] (seq ns)]
               (if (nil? nt)
                 #{nh}
                 (reduce #(-> %1 (conj %2) (conj (+ %2 nh)))
                         #{nh}
                         (g nt)))))
           (f [edges]
             (reduce clojure.set/intersection (map g edges)))]
     (-> edges f empty? not)))

 (fn [f] (= true  (f #{-1 1 99} 
                     #{-2 2 888}
                     #{-3 3 7777}))) ; ex. all sets have a subset which sums to zero
 (fn [f] (= false (f #{1}
                     #{2}
                     #{3}
                     #{4})))
 (fn [f] (= true  (f #{1})))
 (fn [f] (= false (f #{1 -3 51 9} 
                     #{0} 
                     #{9 2 81 33})))
 (fn [f] (= true  (f #{1 3 5}
                     #{9 11 4}
                     #{-3 12 3}
                     #{-3 4 -2 10})))
 (fn [f] (= false (f #{-1 -2 -3 -4 -5 -6}
                     #{1 2 3 4 5 6 7 8 9})))
 (fn [f] (= true  (f #{1 3 5 7}
                     #{2 4 6 8})))
 (fn [f] (= true  (f #{-1 3 -5 7 -9 11 -13 15}
                     #{1 -3 5 -7 9 -11 13 -15}
                     #{1 -1 2 -2 4 -4 8 -8})))
 (fn [f] (= true  (f #{-10 9 -8 7 -6 5 -4 3 -2 1}
                     #{10 -9 8 -7 6 -5 4 -3 2 -1}))))
