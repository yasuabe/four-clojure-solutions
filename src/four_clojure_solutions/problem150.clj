(ns four-clojure-solutions.problem150
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n]
   (let [div-mod #(vec [(quot % 10) (mod % 10)])
         palin-fun (fn [init-func]
                     #(loop [acc (init-func %)
                             cur %]
                        (if (zero? cur) acc
                            (let [[d m] (div-mod cur)]
                              (recur (+ (* 10 acc) m) d)))))
         odd-palin (palin-fun #(quot % 10))
         even-palin (palin-fun identity)
         log (loop [n n
                    cnt 0]
               (if (zero? n) cnt (recur (quot n 10) (inc cnt))))
         init (loop [m n
                     cnt (quot log 2)
                     ten-n (if (even? log) 1 10)]
                (if (zero? cnt) [(even? log) m ten-n]
                    (recur (quot m 10) (dec cnt) (* 10 ten-n))))]
     (letfn [(palins [is-even-palin start end]
               (if is-even-palin
                 (lazy-cat (map even-palin (range start end))
                           (palins false end (* 10 end)))
                 (lazy-cat (map odd-palin (range start end))
                           (palins true (quot end 10) end))))]
       (drop-while #(< % n) (apply palins init)))))

 (fn [f] (= (take 26 (f 0))
            [0 1 2 3 4 5 6 7 8 9
             11 22 33 44 55 66 77 88 99
             101 111 121 131 141 151 161]))

 (fn [f] (= (take 16 (f 162))
            [171 181 191 202
             212 222 232 242
             252 262 272 282
             292 303 313 323]))

 (fn [f] (= (take 6 (f 1234550000))
            [1234554321 1234664321 1234774321
             1234884321 1234994321 1235005321]))

 (fn [f] (= (first (f (* 111111111 111111111)))
            (* 111111111 111111111)))

 (fn [f] (= (set (take 199 (f 0)))
            (set (map #(first (f %)) (range 0 10000)))))

 (fn [f] (= true
            (apply < (take 6666 (f 9999999)))))

 (fn [f] (= (nth (f 0) 10101)
            9102019)))
