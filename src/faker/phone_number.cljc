(ns faker.phone-number
  "Generate fake phone numbers."
  (:require
   [clojure.string :as string]
   [random :refer :all])
  (:refer-clojure :exclude [rand-int rand rand-nth shuffle]))

(def ^{:private true} formats
  ["###-###-####",
   "(###)###-####",
   "1-###-###-####",
   "###.###.####",
   "###-###-####",
   "(###)###-####",
   "1-###-###-####",
   "###.###.####",
   "###-###-#### x###",
   "(###)###-#### x###",
   "1-###-###-#### x###",
   "###.###.#### x###",
   "###-###-#### x####",
   "(###)###-#### x####",
   "1-###-###-#### x####",
   "###.###.#### x####",
   "###-###-#### x#####",
   "(###)###-#### x#####",
   "1-###-###-#### x#####",
   "###.###.#### x#####"])

(defn phone-numbers []
  "Lazy sequence of random phone numbers."
  (repeatedly
    (fn []
      (string/replace (rand-nth formats)
                      #"#"
                      (fn [_] (str (rand-int 10)))))))

