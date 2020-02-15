(ns four-clojure-solutions.problem96
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn is-symmetric? [tree]
   (letfn [(flip [n]
             (if (nil? n) nil
                 (let [[b l r] n] [b (flip r) (flip l)])))]
     (= (flip tree) tree)))
  
   #(= (% '(:a (:b nil nil) (:b nil nil))) true)
   #(= (% '(:a (:b nil nil) nil)) false)
   #(= (% '(:a (:b nil nil) (:c nil nil))) false)
   #(= (% [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]]) true)
   #(= (% [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]]) false)
   #(= (% [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]]) false))
