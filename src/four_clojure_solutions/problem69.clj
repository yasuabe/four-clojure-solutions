(ns four-clojure-solutions.problem69
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [f & maps]
   (letfn [(my-merge [m k v]
             (let [v0 (m k)]
               (assoc m k (if (nil? v0) v (f v0 v)))))
           (merge-two [m1 m2]
             (reduce #(let [[k v] %2] (my-merge %1 k v)) m1 m2))]
     (reduce merge-two maps)))

 #(= (% * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
     {:a 4, :b 6, :c 20})

 #(= (% - {1 10, 2 20} {1 3, 2 10, 3 15})
     {1 7, 2 10, 3 15})

 #(= (% concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
     {:a [3 4 5], :b [6 7], :c [8 9]}))
