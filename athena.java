import java.sql.*;
import java.util.Properties;

import com.amazonaws.athena.jdbc.AthenaDriver;
import com.amazonaws.auth.PropertiesFileCredentialsProvider;

public class athena {

    static final String athenaUrl = 
        "jdbc:awsathena://athena.us-east-1.amazonaws.com:443";

    public static void main(String[] args){

        Properties info = new Properties();

        info.put("s3_staging_dir", 
                "s3://athena-devs-perf-query-result/test/");

        info.put("aws_credentials_provider_class",
                "com.amazonaws.auth.PropertiesFileCredentialsProvider");

        try {
            System.out.println("Connecting to Athena...");
            Connection conn = DriverManager.getConnection(athenaUrl, info);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println(args[0]);
        System.out.println("Done.");

    }

}
