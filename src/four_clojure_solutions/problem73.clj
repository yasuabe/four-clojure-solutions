(ns four-clojure-solutions.problem73
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [board]
   (let [coll (flatten board)
         lining? (fn [p l] (every? #(= p (nth coll %)) l))
         lines [[0 1 2] [3 4 5] [6 7 8]
                [0 3 6] [1 4 7] [2 5 8]
                [0 4 8] [2 4 6]]]
     (letfn [(has-won? [mark]
               (some (partial lining? mark) lines))]
          (cond
            (has-won? :x) :x
            (has-won? :o) :o
            :else nil))))

 #(= nil (% [[:e :e :e]
             [:e :e :e]
             [:e :e :e]]))
 #(= :x (% [[:x :e :o]
            [:x :e :e]
            [:x :e :o]]))
 #(= :o (% [[:e :x :e]
            [:o :o :o]
            [:x :e :x]]))
 #(= nil (% [[:x :e :o]
             [:x :x :e]
             [:o :x :o]]))
 #(= :x (% [[:x :e :e]
            [:o :x :e]
            [:o :e :x]]))
 #(= :o (% [[:x :e :o]
            [:x :o :e]
            [:o :e :x]]))
 #(= nil (% [[:x :o :x]
             [:x :o :x]
             [:o :x :o]])))

