(ns four-clojure-solutions.problem84
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll]
   (letfn [(bin-rels [coll]
             (loop [coll coll
                    acc ()]
               (if (empty? coll) acc
                   (let [[h & t] coll]
                     (recur t (reduce #(cons [h %2] %1) acc t))))))
           (attach [rel coll]
             (if (empty? coll) [rel []]
                 (let [l1 (first rel)
                       r1 (last rel)
                       [[l2 r2 :as h] & t] coll]
                   (cond
                     (= r1 l2) [(into [l1] h) t]
                     (= r2 l1) [(into [l2] rel) t]
                     :else (let [[a2 t2] (attach rel t)] [a2 (conj t2 h)])))))
           (connect [coll]
             (if-not (empty? coll)
                 (let [[h & t] coll]
                   (loop [a h
                          coll t]
                     (let [[a2 y :as res] (attach a coll)]
                       (if (or (empty? y) (= a a2)) res (recur a2 y)))))))
           (connect-all [coll]
             (loop [coll coll
                    acc ()]
               (let [[a b] (connect coll)
                     res (cons a acc)]
                 (if (empty? b) res (recur b res)))))]
     (let [chains (connect-all (seq coll))]
       (reduce into #{} (map bin-rels chains)))))
 
 (fn [f] (let [divides #{[8 4] [9 3] [4 2] [27 9]}]
           (= (f divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]})))

 (fn [f] (let [more-legs
               #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
           (= (f more-legs)
              #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
                ["spider" "cat"] ["spider" "man"] ["spider" "snake"]})))

 (fn [f] (let [progeny
               #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
           (= (f progeny)
              #{["father" "son"] ["father" "grandson"]
                ["uncle" "cousin"] ["son" "grandson"]}))))
