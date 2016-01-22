(defproject thelema "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "http://please.FIXME"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/core.async "0.2.374"]
                 [io.nervous/cljs-lambda "0.2.0"]
                 [io.nervous/cljs-nodejs-externs "0.2.0"]]
  :plugins [[lein-cljsbuild "1.1.2"]
            [lein-npm "0.6.0"]
            [lein-doo "0.1.7-SNAPSHOT"]
            [io.nervous/lein-cljs-lambda "0.3.0"]]
  :npm {:dependencies [[source-map-support "0.2.8"]]}
  :source-paths ["src"]
  :cljs-lambda
  {:defaults {:role "arn:aws:iam::312290181475:role/cljs-lambda-default"}
   :resource-dirs ["static"]
   :functions
   [{:name   "work-magic"
     :invoke thelema.core/work-magic}]}
  :cljsbuild
  {:builds [{:id "thelema"
             :source-paths ["src"]
             :compiler {:output-to "target/thelema/thelema.js"
                        :output-dir "target/thelema"
                        :target :nodejs
                        :optimizations :advanced}}
            {:id "thelema-test"
             :source-paths ["src" "test"]
             :compiler {:output-to "target/thelema-test/thelema.js"
                        :output-dir "target/thelema-test"
                        :target :nodejs
                        :optimizations :none
                        :main thelema.test-runner}}]})
