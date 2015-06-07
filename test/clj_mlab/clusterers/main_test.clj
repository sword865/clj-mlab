(ns clj-mlab.clusterers.main-test
  (:require [clj-mlab.core.data :as data]
            [clj-mlab.clusterers.simplekmeans :as kmeans]
            [clj-mlab.clusterers.clusterer :as clusters]
            [clojure.test :refer :all]))

(deftest a-test
  (let [dataset (data/new-dataset "data/iris.arff")
        numattrs (data/num-attribute dataset)
        cls (kmeans/create-SimpleKmeans)]
    (do
      (data/set-class-index dataset (- numattrs 1))
      (clusters/setNumClusters cls (data/num-classes dataset))
      (data/set-class-index dataset -1)
      (data/delete-attribute-at dataset (- numattrs 1))
      (clusters/buildClusterer cls dataset)
      (println (clusters/clusterDateSet cls dataset))
      (testing "FIXME, I fail."
        (= 1 1)
        ))))