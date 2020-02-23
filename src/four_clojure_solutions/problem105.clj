(ns four-clojure-solutions.problem105
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll]
   (if (empty? coll)
     {}
     (loop [key (first coll)
            nums []
            coll (rest coll)
            acc {}]
       (let [[h & t] coll]
         (if (nil? h)
           (assoc acc key nums)
           (if (keyword? h)
             (recur h [] t (assoc acc key nums))
             (recur key (conj nums h) t acc)))))))

 #(= {} (% []))
 #(= {:a [1]} (% [:a 1]))
 #(= {:a [1], :b [2]} (% [:a 1, :b 2]))
 #(= {:a [1 2 3], :b [], :c [4]} (% [:a 1 2 3 :b :c 4])))
