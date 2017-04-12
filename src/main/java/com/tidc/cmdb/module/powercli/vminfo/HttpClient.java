package com.tidc.cmdb.module.powercli.vminfo;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by keunhyoung on 17. 4. 12.
 */
public class HttpClient {

    private final String USER_AGENT = "Mozilla/5.0";

    private String url;
    private String request;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    // HTTP POST request
    public void sendPost() throws Exception {

        String url = "http://10.40.99.89/api/vm/update";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        //con.setRequestProperty("User-Agent", USER_AGENT);
        //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(request);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();


        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + request);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        // logger
        BufferedWriter writer = null;
        String dateLog = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        File logFile = new File("VminfoUpdate"+dateLog+".log");

        try {

            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            writer = new BufferedWriter(new FileWriter(logFile,true));
            writer.newLine();
            writer.write(timeLog+" ");
            writer.write(response.toString());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }

        }


    }
}
