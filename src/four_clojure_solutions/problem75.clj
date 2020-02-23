(ns four-clojure-solutions.problem75
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n]
   (letfn [(divides? [n m] (zero? (rem n m)))
           (not-divides? [n m] (not (divides? n m)))
           (calc-exp [n p]
             (loop [n n
                    e 0]
               (if (not (divides? n p)) [e n]
                   (recur (quot n p) (inc e)))))
           (factor [n]
             (let [sqrt (int (Math/sqrt n))]
               (loop [n n
                      ps (range 2 (inc sqrt))
                      res []]
                 (if (empty? ps)
                   (if (= 1 n) res (cons [n 1] res))
                   (let [[ph & pt] ps
                         [e q] (calc-exp n ph)
                         next-ps (filter #(not (divides? % ph)) pt)]
                     (if (= 0 e)
                       (recur n next-ps res)
                       (recur q next-ps (cons [ph e] res))))))))]
     
     (let [not-devides? #(not= 0 (rem %1 %2))
           pow #(reduce * (repeat %2 %1))]
       (reduce * (map #(let [[p e] %]
                         (* (dec p) (pow p (dec e))))
                      (factor n))))))

 #(= (% 1) 1)
 #(= (% 10) (count '(1 3 7 9)) 4)
 #(= (% 40) 16)
 #(= (% 99) 60))
