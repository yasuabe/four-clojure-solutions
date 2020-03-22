(ns four-clojure-solutions.problem117
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [maze]
   (let [offsets [[-1 0] [ 0 -1] [ 0 1] [ 1 0]]
         all-pos   (for [r (range (count maze))
                         c (range (count (nth maze 0)))] [r c])
         at        (fn [[r c]] (-> maze (nth r) (nth c)))
         spaces    (filter #(= (at %) \space) all-pos)
         find-char (fn [ch] (some #(if (= ch (at %)) %) all-pos))
         mouse  (find-char \M)
         cheese (find-char \C)
         init-spaces (set spaces)
         proceed (fn [frontier]
                   (reduce (fn [acc pos] (into acc (map #(map + % pos) offsets)))
                           #{}
                           frontier))]
     (loop [frontier (list mouse)
            spaces (conj init-spaces cheese)]
       (let [around (proceed frontier)
             new-frontier (clojure.set/intersection around spaces)]
         (cond
           (empty? new-frontier) false
           (new-frontier cheese) true
           :else (recur new-frontier (clojure.set/difference spaces new-frontier)))))))

 (fn [f] (= true  (f ["M   C"])))
 (fn [f] (= false (f ["M # C"])))
 (fn [f] (= true  (f ["#######"
                      "#     #"
                      "#  #  #"
                      "#M # C#"
                      "#######"])))
 (fn [f] (= false (f ["########"
                      "#M  #  #"
                      "#   #  #"
                      "# # #  #"
                      "#   #  #"
                      "#  #   #"
                      "#  # # #"
                      "#  #   #"
                      "#  #  C#"
                      "########"])))
 (fn [f] (= false (f ["M     "
                      "      "
                      "      "
                      "      "
                      "    ##"
                      "    #C"])))
 (fn [f] (= true  (f ["C######"
                      " #     "
                      " #   # "
                      " #   #M"
                      "     # "])))
 (fn [f] (= true  (f ["C# # # #"
                      "        "
                      "# # # # "
                      "        "
                      " # # # #"
                      "        "
                      "# # # #M"]))))
