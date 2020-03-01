(ns four-clojure-solutions.problem92
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [roman-number]
   (letfn [(digit-map [triad]
             (let [[x v i] triad]
               (map #(vector (re-pattern (str "^" %1 "(.*)")) %2)
                    [(str i x)
                     (str v i i i)
                     (str v i i)
                     (str v i)
                     (str v)
                     (str i v)
                     (str i i i)
                     (str i i)
                     (str i)]
                    (range 9 0 -1))))
           (read-digit [s triad]
             (or (some #(let [[pattern digit] %
                              [_ found] (re-find pattern s)]
                          (if found [digit found]))
                       (digit-map triad)) [0 s]))]
     (first (reduce
             (fn [acc triad]
               (let [[n s] acc
                     [m t] (read-digit s triad)]
                 [(+ (* 10 n) m) t]))
             [0 roman-number]
             [[\- \- \M]
              [\M \D \C]
              [\C \L \X]
              [\X \V \I]]))))

 (fn [f] (= 14 (f "XIV")))
 (fn [f] (= 827 (f "DCCCXXVII")))
 (fn [f] (= 3999 (f "MMMCMXCIX")))
 (fn [f] (= 48 (f "XLVIII"))))
