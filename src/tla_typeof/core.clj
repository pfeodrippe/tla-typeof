(ns tla-typeof.core
  (:require
   [clojure.string :as str]
   [tla-edn.core :as edn]
   [tla-edn.spec :as spec]))

(spec/defop TypeOf {:module "Types"}
  [v]
  ;; `->` is the pipeline operator.
  (-> v
      type                        ; Here we get the type of the value.
      str ; Stringify it (now a Integer is `"class tlc2.value.impl.IntegerValue"`).
      (str/split #"\.") ; Then we dot split it, `[]"class" ...  "..." ... "IntegerValue"]`.
      last              ; Get the last element, "IntegerValue".
      (str/split #"Value")
      first                   ; Get rid of `Value` suffix, `"Integer"`.
      ;; And finally convert back to a String which TLC understands.
      edn/to-tla-value))

(comment

  ;; Run this in a REPL o/
  (spec/run (.getAbsolutePath (java.io.File. "Example/Eita.tla")) "Eita.cfg")

  ())
