(ns four-clojure-solutions.problem89
  (:require [four-clojure-solutions.checker :refer [checker]]
            [clojure.set :refer :all]))

(checker
 (fn [edges]
   (letfn [(remove-one [coll target]
             (loop [acc ()
                    coll coll]
               (if (empty? coll) acc
                   (let [[h & t] coll]
                     (if (= h target)
                       (concat acc t)
                       (recur (cons h acc) t))))))
           (proceed [from rest-edges]
             (or (empty? rest-edges)
                 (some (fn [[l r :as edge]]
                         (let [next (if (= from l) r l)]
                           (proceed next (remove-one rest-edges edge))))
                       (filter (fn [[l r]] ((conj #{l} r) from)) rest-edges))))]
     (let [verts (reduce (fn [acc [l r]] (conj acc l r)) #{} edges)]
       (true? (some #(proceed % edges) verts)))))

 (fn [f] (= true (f [[:a :b]])))
 (fn [f] (= false (f [[:a :a] [:b :b]])))

 (fn [f] (= false (f [[:a :b] [:a :b] [:a :c] [:c :a]
                      [:a :d] [:b :d] [:c :d]])))
 (fn [f] (= true (f [[1 2] [2 3] [3 4] [4 1]])))
 (fn [f] (= true (f [[:a :b] [:a :c] [:c :b] [:a :e]
                     [:b :e] [:a :d] [:b :d] [:c :e]
                     [:d :e] [:c :f] [:d :f]])))
 (fn [f] (= false (f [[1 2] [2 3] [2 4] [2 5]]))))
