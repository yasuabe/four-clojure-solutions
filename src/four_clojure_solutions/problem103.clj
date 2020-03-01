(ns four-clojure-solutions.problem103
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n coll]
   (letfn [(f [n coll]
             (cond
               (zero? n) #{#{}}
               (> n (count coll)) #{}
               :else (let [[h & t] coll]
                       (into (f n t)
                             (map #(conj % h) (f (dec n) t))))))]
     (f n (seq coll))))

 (fn [f] (= (f 1 #{4 5 6}) #{#{4} #{5} #{6}}))
 (fn [f] (= (f 10 #{4 5 6}) #{}))
 (fn [f] (= (f 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}}))
 (fn [f] (= (f 3 #{0 1 2 3 4}) #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
                                 #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}}))

 (fn [f] (= (f 4 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a "abc" "efg"}}))
 (fn [f] (= (f 2 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
                                              #{:a "abc"} #{:a "efg"} #{"abc" "efg"}})))
