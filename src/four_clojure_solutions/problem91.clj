(ns four-clojure-solutions.problem91
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [edges]
   (letfn [(f [graphs edge]
             (let [connects #(not-empty (clojure.set/intersection % edge))
                   g #(if (connects %)
                        (clojure.set/union % edge)
                        %)]
               (if (some connects graphs)
                 (mapv g graphs)
                 (conj graphs edge))))]
     (loop [graphs (map set edges)]
       (let [merged (reduce f [] graphs)]
         (if (= merged graphs)
           (= (count merged) 1)
           (recur merged))))))

 (fn [f] (= true (f #{[:a :a]})))
 (fn [f] (= true (f #{[:a :b]})))
 (fn [f] (= false (f #{[1 2] [2 3] [3 1]
                       [4 5] [5 6] [6 4]})))

 (fn [f] (= true (f #{[1 2] [2 3] [3 1]
                      [4 5] [5 6] [6 4] [3 4]})))

 (fn [f] (= false (f #{[:a :b] [:b :c] [:c :d]
                       [:x :y] [:d :a] [:b :e]})))

 (fn [f] (= true (f #{[:a :b] [:b :c] [:c :d]
                      [:x :y] [:d :a] [:b :e] [:x :a]}))))
