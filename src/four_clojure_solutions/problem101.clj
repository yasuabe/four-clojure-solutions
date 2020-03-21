(ns four-clojure-solutions.problem101
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll1 coll2]
   (last
    (reduce
     (fn [row-acc [s-idx s-idm]]
       (reduce
        (fn  [acc [d-idx d-idm]]
          (let [del (inc (nth row-acc (inc d-idx)))
                ins (inc (last acc))
                sub (+ (nth row-acc d-idx)
                       (if (= s-idm d-idm) 0 1))]
            (conj acc (min del ins sub))))
        [(inc s-idx)]
        (map-indexed vector coll2)))
     (range (inc (count coll2)))
     (map-indexed vector coll1))))
 (fn [f] (= (f "kitten" "sitting") 3))
 (fn [f] (= (f "closure" "clojure") (f "clojure" "closure") 1))
 (fn [f] (= (f "xyx" "xyyyx") 2))
 (fn [f] (= (f "" "123456") 6))
 (fn [f] (= (f "Clojure" "Clojure") (f "" "") (f [] []) 0))
 (fn [f] (= (f [1 2 3 4] [0 2 3 4 5]) 2))
 (fn [f] (= (f '(:a :b :c :d) '(:a :d)) 2))
 (fn [f] (= (f "ttttattttctg" "tcaaccctaccat") 10))
 (fn [f] (= (f "gaattctaatctc" "caaacaaaaaattt") 9)))
