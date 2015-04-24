(defproject lein-tag-no-sign "0.1.0-SNAPSHOT"
  :description "Leiningen plugin to provide a non-signing variant of vcs tag"
  :url "http://github.com/nberger/lein-tag-no-sign"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-tag-no-sign "0.1.0-SNAPSHOT"]]

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version"
                   "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["tag-no-sign"]
                  ["deploy" "clojars"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]

  :eval-in-leiningen true)
