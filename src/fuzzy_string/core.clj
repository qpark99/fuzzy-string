(ns fuzzy-string.core
  (:use [clojure set]))

(defn bigram 
  "create bigrams out of a string"
  [strn]
  (loop [os strn
         rs []]
    (if (<= (. os length) 2)
      (conj rs os)
      (recur (. os substring 1) 
             (conj rs (. os substring 0 2))))))
      

(defn set-length
  "returns the number of elements in a set"
  [st]
  (. (into [] st) length))

(defn dice 
  "The dice comparison, takes two strings - compares bigrams
   The dice algorithm always returns a value between 0 and 1"
  [a b]
  (let [a (set (bigram a))
        b (set (bigram b))]
    (/ (* 2 (set-length (intersection a b)))
       (+ (set-length a) (set-length b)))))

(defn levenshtein
  "calculates the levenshtein distane between two strings"
  [a b]
  (let 
      [len-a (. (into [] a) length)
       len-b (. (into [] b) length)
       cost (if (= (first a) (first b)) 0 1)]
    (if (or (= len-a 0) (= len-b 0)) 
      (+ len-a len-b)
      (apply min
             (map (fn [x y z] 
                     (+ (levenshtein x y) z))
                   [(rest a) a (rest a)]
                   [b (rest b) (rest b)]c
                   [1 1 cost])))))
            