(ns four-clojure-solutions.problem130
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [new-node tree]
   (letfn [(f [new-node [node & children :as sub-tree]]
             (cond
               (= new-node node) (list sub-tree)
               (nil? children) nil
               :else (let [arg-res (map #(vector % (f new-node %)) children)
                           others (map first (filter (comp nil? second) arg-res))
                           new-nodes (first (drop-while nil? (map second arg-res)))]
                       (if (not-empty new-nodes)
                         (cons (cons node others) new-nodes)
                         nil))))]
     (reduce (fn [acc e] (concat e (list acc)))
             (f new-node tree))))

 (fn [f] (= '(n)
            (f 'n '(n))))
 #(= '(e (t (a)))
     (% 'e '(a (t (e)))))
 #(= '(a (t (e)))
     (% 'a '(t (e) (a))))
 (fn [f](= '(a (b (c)))
           (f 'a '(c (b (a))))))
 (fn [f](= '(d
             (b
              (c)
              (e)
              (a
               (f
                (g)
                (h)))))
           (f 'd '(a
                   (b
                    (c)
                    (d)
                    (e))
                   (f
                    (g)
                    (h))))))
 (fn [f] (= '(c
              (d)
              (e)
              (b
               (f
                (g)
                (h))
               (a
                (i
                 (j
                  (k)
                  (l))
                 (m
                  (n)
                  (o))))))
            (f 'c '(a
                    (b
                     (c
                      (d)
                      (e))
                     (f
                      (g)
                      (h)))
                    (i
                     (j
                      (k)
                      (l))
                     (m
                      (n)
                      (o))))))))
