(ns four-clojure-solutions.problem148
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n a b]
   (let [f (fn [m]
             (let [a (quot (dec n) m)]
               (*' (/ (*' a (inc a)) 2) m)))]
     (let [[a' b' bc] (map f [a b (* a b)])] (- (+ a' b') bc))))

 (fn [f] (= 0 (f 3 17 11)))
 (fn [f] (= 23 (f 10 3 5)))
 (fn [f] (= 233168 (f 1000 3 5)))
 (fn [f] (= "2333333316666668" (str (f 100000000 3 5))))
 (fn [f] (= "110389610389889610389610"
            (str (f (* 10000 10000 10000) 7 11))))
 (fn [f] (= "4530161696788274281"
            (str (f (* 10000 10000 1000) 1597 3571))))
 (fn [f] (= "1277732511922987429116"
            (str (f (* 10000 10000 10000) 757 809)))))
