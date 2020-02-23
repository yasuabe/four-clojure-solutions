(ns four-clojure-solutions.problem98
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [f s]
   (into
    #{}
    (vals
     (reduce
      (fn [acc e]
        (let [k (f e)
              cur (acc k)]
          (assoc acc k (if (nil? cur) #{e} (conj cur e)))))
      {}
      s))))
 (fn [f] (= (f #(* % %) #{-2 -1 0 1 2})
            #{#{0} #{1 -1} #{2 -2}}))
 (fn [f] (= (f #(rem % 3) #{0 1 2 3 4 5 })
            #{#{0 3} #{1 4} #{2 5}}))
 (fn [f] (= (f identity #{0 1 2 3 4})
            #{#{0} #{1} #{2} #{3} #{4}}))
 (fn [f] (= (f (constantly true) #{0 1 2 3 4})
            #{#{0 1 2 3 4}})))
