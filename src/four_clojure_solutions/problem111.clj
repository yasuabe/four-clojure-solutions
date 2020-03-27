(ns four-clojure-solutions.problem111
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [target lines]
   (let [convert #(-> %
                      (clojure.string/replace  " " "")
                      (clojure.string/replace "_" "."))
         patterns (map convert lines)
         find-match (fn [lines]
                      (some
                       (fn [line]
                         (let [len (count target)]
                           (some
                            #(re-matches % target)
                            (map re-pattern (clojure.string/split line #"#")))))
                       lines))
         some? #(not (nil? %))]
     (some? (or (find-match patterns)
                (find-match (apply map str patterns))))))

 (fn [f] (= true  (f "joy" ["c _ _ _"
                            "d _ # e"
                            "r y _ _"])))
 (fn [f] (= false (f "joy" ["c o n j"
                            "_ _ y _"
                            "r _ _ #"])))
 (fn [f] (= true  (f "the" ["_ # _ _ e"])))
 (fn [f] (= false (f "the" ["c _ _ _"
                            "d _ # e"
                            "r y _ _"])))
 (fn [f] (= true  (f "clojure" ["_ _ _ # j o y"
                                "_ _ o _ _ _ _"
                                "_ _ f _ # _ _"]))))
