(ns athena-cmd.core
  (:gen-class))

(import '(java.sql DriverManager) 
        'java.util.Properties
        'com.amazonaws.athena.jdbc.AthenaDriver)

(def athenaURI 
  "jdbc:awsathena://athena.us-east-1.amazonaws.com:443")

(def info (Properties.))

(.put info "s3_staging_dir" 
           "s3://aws-athena-query-results1/")

(.put info "aws_credentials_provider_class"
           "com.amazonaws.auth.InstanceProfileCredentialsProvider")

(.put info "log_path"
           "./.athena/athenajdbc.log")

(def conn (DriverManager/getConnection athenaURI info))
(def stmt (.createStatement conn))

(defn -main
  [& args]

  (println "executing query")

  (let [query (nth args 0)
        rs (.executeQuery stmt query)]
    )

  (println "done"))
