(ns frontmatter.core-test
  (:require
    [frontmatter.core :refer :all]
    [midje.sweet      :refer :all]
    [conjure.core     :refer :all]))

(defn- test-path
  [name]
  (str "./test/files/" name))

(def ^:private expected-data
  {:frontmatter {:hello "world"
                 :nums  ["one" "two" "three"]}
   :body        "this is body"})

(facts "parse should work fine."
  (fact "YAML"
    (parse (test-path "yaml.txt")) => expected-data)
  (fact "JSON"
    (parse (test-path "json.txt")) => expected-data)
  (fact "EDN"
    (parse (test-path "edn.txt")) => expected-data)
  (fact "No front matter"
    (parse (test-path "dummy.txt")) => {:frontmatter {} :body "this is body"}))
