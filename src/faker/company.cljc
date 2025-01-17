(ns faker.company
  "Create fake company data"
  (:require [faker.name :as fkname]
            [clojure.string :refer [join]]
            [faker.company-data :as cd]
            [random :refer :all])
  (:refer-clojure :exclude [rand-int rand rand-nth shuffle]))

(defn suffix
  "Return a random company suffix, like Inc or Group."
  []
  (rand-nth cd/suffixes))

(defn- phrase [source]
  (join " " (map #(rand-nth %) source)))

(defn catch-phrase
  "Return a random company catch phrase."
  []
  (phrase cd/catch-phrase-words))

(defn bs
  "Return random company BS goals."
  []
  (phrase cd/bs-words))

(def ^{:private true} formats
  [#(str (first (fkname/names)) " " (suffix))
   #(str (fkname/last-name) "-" (fkname/last-name))
   #(format "%s, %s and %s" (fkname/last-name) (fkname/last-name) (fkname/last-name))])


(defn names []
  "Lazy sequence of random company names"
  (repeatedly
    (fn []
      ((rand-nth formats)))))
