(ns four-clojure-solutions.problem104
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn f [n]
   (let [triads [[\X \V \I]
                 [\C \L \X]
                 [\M \D \C]
                 [\- \- \M]]
         to-digits (fn [n]
                     (loop [n n
                            res []]
                       (if (zero? n) res
                           (recur (quot n 10) (conj res (mod n 10))))))
         rm-to-al (fn [d triad]
                    (let [[x v i] triad]
                      (apply str
                             (nth [[]
                                   [i]
                                   [i i]
                                   [i i i]
                                   [i v]
                                   [v]
                                   [v i]
                                   [v i i]
                                   [v i i i]
                                   [i x]] d))))]
     (apply str (reverse (map rm-to-al (to-digits n) triads)))))

 (fn [f] (= "I" (f 1)))
 (fn [f] (= "XXX" (f 30)))
 (fn [f] (= "IV" (f 4)))
 (fn [f] (= "CXL" (f 140)))
 (fn [f] (= "DCCCXXVII" (f 827)))
 (fn [f] (= "MMMCMXCIX" (f 3999)))
 (fn [f] (= "XLVIII" (f 48))))
