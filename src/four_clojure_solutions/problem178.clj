(ns four-clojure-solutions.problem178
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [v]
   (let [rank-num-map (into {} (map-indexed #(vector %2 %1)
                                            "A23456789TJQK"))
         cards (map (fn [[ch1 ch2]]
                      {:suit ch1
                       :rank (rank-num-map ch2)}) v)
         count-by #(map (fn [[k c]] (vector k (count c)))
                             (group-by %1 cards))
         is-straight (let [sorted (->> cards (map :rank) set sort)]
                       (#{[9 1 1 1] [1 1 1 1]}
                        (map - (drop 1 sorted) sorted)))
         is-flush (= 1 (->> (count-by :suit) count))
         [c1 c2 & _] (->> (count-by :rank) (map second) (sort >))]
     (cond
       (and is-straight is-flush) :straight-flush
       (= 4 c1)          :four-of-a-kind
       (= [3 2] [c1 c2]) :full-house
       is-flush          :flush
       is-straight       :straight
       (= 3 c1)          :three-of-a-kind
       (= [2 2] [c1 c2]) :two-pair
       (= 2 c1)          :pair
       :else             :high-card)))

 (fn [f] (= :high-card       (f ["HA" "D2" "H3" "C9" "DJ"])))
 (fn [f] (= :pair            (f ["HA" "HQ" "SJ" "DA" "HT"])))
 (fn [f] (= :two-pair        (f ["HA" "DA" "HQ" "SQ" "HT"])))
 (fn [f] (= :three-of-a-kind (f ["HA" "DA" "CA" "HJ" "HT"])))
 (fn [f] (= :straight        (f ["HA" "DK" "HQ" "HJ" "HT"])))
 (fn [f] (= :straight        (f ["HA" "H2" "S3" "D4" "C5"])))
 (fn [f] (= :flush           (f ["HA" "HK" "H2" "H4" "HT"])))
 (fn [f] (= :full-house      (f ["HA" "DA" "CA" "HJ" "DJ"])))
 (fn [f] (= :four-of-a-kind  (f ["HA" "DA" "CA" "SA" "DJ"])))
 (fn [f] (= :straight-flush  (f ["HA" "HK" "HQ" "HJ" "HT"]))))
