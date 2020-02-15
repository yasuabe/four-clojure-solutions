(ns four-clojure-solutions.problem95
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn is-tree? [node]
   (letfn [(is-leaf? [n] (nil? n))
           (is-branch? [n] (and
                            (coll? n)
                            (= (count n) 3)
                            (is-tree? (second n))
                            (is-tree? (nth n 2))))]
     (or (is-leaf? node) (is-branch? node))))

 
  #(= (% '(:a (:b nil nil) nil)) true)
  #(= (% '(:a (:b nil nil))) false)
  #(= (% [1 nil [2 [3 nil nil] [4 nil nil]]]) true)
  #(= (% [1 [2 nil nil] [3 nil nil] [4 nil nil]]) false)
  #(= (% [1 [2 [3 [4 nil nil] nil] nil] nil]) true)
  #(= (% [1 [2 [3 [4 false nil] nil] nil] nil]) false)
  #(= (% '(:a nil ())) false))
