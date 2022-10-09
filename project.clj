(defproject thrift-clj "0.3.3-Snapshot"
  :description "Clojure and Thrift working hand in hand."
  :url "https://github.com/xsc/thrift-clj"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"
            :year 2022
            :key "mit"}

  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/tools.logging "1.2.4"]
                 [org.reflections/reflections "0.10.2"]
                 [org.apache.thrift/libthrift "0.17.0" :exclusions [org.slf4j/slf4j-api]]
                 [javax.servlet/servlet-api "2.5"]
                 [javax.annotation/javax.annotation-api "1.3.2"]
                 [org.apache.httpcomponents/httpcore "4.4.15"]
                 [org.apache.httpcomponents/httpclient "4.5.13"]
                 [potemkin "0.4.6"]]
  :repositories  {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :exclusions [org.clojure/clojure]
  :thriftc {:path          "G:\\APP\\thrift-0.17.0\\bin\\thrift.exe" }
  :profiles {:dev        {:dependencies [[ch.qos.logback/logback-classic "1.4.3"]
                                         [midje "1.10.5"]]
                          :plugins      [[lein-midje "3.1.3"]
                                         [lein-thriftc "0.2.3"]]
                          :hooks        [leiningen.thriftc]
                          :test-paths   ["test-thrift/clj"]
                          :javac-opts   ["-source" "17" "-target" "17"]
                          :thriftc      {:source-paths ["test-thrift/thrift"]}}
             :doc        {:plugins [[codox "0.8.13"]]
                          :codox   {:sources ["src/thrift_clj"]
                                    :include [thrift-clj.core]}}
             :reflection {:warn-on-reflection true}}

  :aliases {"test" "midje"
            "doc" ["with-profile" "doc" "doc"]})
