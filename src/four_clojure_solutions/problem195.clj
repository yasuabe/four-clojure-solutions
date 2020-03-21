(ns four-clojure-solutions.problem195
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [level]
   (let [next-level (fn [path-lists]
             (let [paths
                   (reduce
                    (fn [acc e]
                      (cons (concat (map #(str "(" %) (first acc))
                                    (map #(str ")" %) e))
                            acc))
                    ()
                    path-lists)]
               (reverse (cons (map #(str "(" %) (first paths)) paths))))]
     (loop [level level
            acc '((""))]
       (if (zero? level)
         (set (last acc))
         (recur (dec level) (next-level acc))))))

 (fn [f] (= [#{""} #{"()"} #{"()()" "(())"}] (map (fn [n] (f n)) [0 1 2])))
 (fn [f] (= #{"((()))" "()()()" "()(())" "(())()" "(()())"} (f 3)))
 (fn [f] (= 16796 (count (f 10))))
 (fn [f] (= (nth (sort (filter #(.contains ^String % "(()()()())") (f 9))) 6) "(((()()()())(())))"))
 (fn [f] (= (nth (sort (f 12)) 5000) "(((((()()()()()))))(()))")))
