(ns four-clojure-solutions.problem113
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [& args]
   (let [str-result (clojure.string/join ", " (sort args))
         seq-result (loop [res (), used #{}, coll args]
              (if (empty? coll)
                (reverse res)
                (let [[h & t] coll]
                  (if (used h)
                    (recur res used t)
                    (recur (cons h res) (conj used h) t)))))]
     (reify Object clojure.lang.Seqable
       (toString [this] str-result)
       (seq [this] (seq seq-result)))))

 (fn [f] (= "1, 2, 3" (str (f 2 1 3))))
 (fn [f] (= '(2 1 3) (seq (f 2 1 3))))
 (fn [f] (= '(2 1 3) (seq (f 2 1 3 3 1 2))))
 (fn [f] (= '(1) (seq (apply f (repeat 5 1)))))
 (fn [f](= "1, 1, 1, 1, 1" (str (apply f (repeat 5 1)))))
 (fn [f] (and (= nil (seq (f)))
              (=  "" (str (f))))))
