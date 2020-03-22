(ns four-clojure-solutions.problem119
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [piece board]
   (let [state-at (fn [[r c]] (nth (nth board r) c))
         group-by-state (fn [line] (group-by #(state-at %) line))]
     (->> [[[0 0] [0 1] [0 2]]
           [[1 0] [1 1] [1 2]]
           [[2 0] [2 1] [2 2]]
           [[0 0] [1 0] [2 0]]
           [[0 1] [1 1] [2 1]]
           [[0 2] [1 2] [2 2]]
           [[0 0] [1 1] [2 2]]
           [[0 2] [1 1] [2 0]]]
          (map group-by-state)
          (filter #(and (= 2 (count (piece %))) (= 1 (count (:e %)))))
          (map #(first (:e %)))
          (set))))
 (fn [f] (= (f :x [[:o :e :e]
                   [:o :x :o]
                   [:x :x :e]])
            #{[2 2] [0 1] [0 2]}))
 (fn [f] (= (f :x [[:x :o :o]
                   [:x :x :e]
                   [:e :o :e]])
            #{[2 2] [1 2] [2 0]}))
 (fn [f] (= (f :x [[:x :e :x]
                   [:o :x :o]
                   [:e :o :e]])
            #{[2 2] [0 1] [2 0]}))
 (fn [f] (= (f :x [[:x :x :o]
                   [:e :e :e]
                   [:e :e :e]])
            #{}))

 (fn [f] (= (f :o [[:x :x :o]
                   [:o :e :o]
                   [:x :e :e]])
            #{[2 2] [1 1]})))
