(ns leiningen.tag-no-sign
  (:require [leiningen.core.eval :as eval]))

(defn tag-no-sign [{:keys [root version vcs-options]} & [prefix]]
  (binding [eval/*dir* root]
    (let [tag (if prefix
                (str prefix version)
                version)]
      (eval/sh "git" "tag" tag "-m" (str "Release " version)))))
