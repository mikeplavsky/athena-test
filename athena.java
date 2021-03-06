import java.sql.*;
import java.util.Properties;

import com.amazonaws.athena.jdbc.AthenaDriver;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;

public class athena {

    static final String athenaUrl = 
        "jdbc:awsathena://athena.us-east-1.amazonaws.com:443";

    public static void main(String[] args){

        String query = "select COUNT(*) from test";

        Properties info = new Properties();

        info.put("s3_staging_dir", 
                "s3://aws-athena-query-results1/");

        info.put("aws_credentials_provider_class",
                "com.amazonaws.auth.InstanceProfileCredentialsProvider");

        info.put("log_path", "./.athena/athenajdbc.log");

        try {

            System.out.println("Connecting to Athena...");
            Connection conn = DriverManager.getConnection(
                    athenaUrl, info);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){

                String v = rs.getString(1);
                System.out.println(v);

            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("Done.");

    }

}
