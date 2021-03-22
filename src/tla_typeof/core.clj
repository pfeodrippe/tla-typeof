(ns tla-typeof.core
  (:require
   [clojure.string :as str]
   [tla-edn.core :as edn]
   [tla-edn.spec :as spec]))

(spec/defop TypeOf {:module "Types"}
  [v]
  (-> v
      type
      str
      (str/split #"\.")
      last
      (str/split #"Value")
      first
      edn/to-tla-value))

(comment

  (spec/run (.getAbsolutePath (java.io.File. "Example/Eita.tla")) "Eita.cfg")

  ())
