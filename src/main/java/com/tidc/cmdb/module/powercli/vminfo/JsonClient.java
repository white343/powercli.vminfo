package com.tidc.cmdb.module.powercli.vminfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.tidc.cmdb.module.powercli.*;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

/**
 * Created by heogeunhyeong on 2017. 3. 15..
 */
@SpringBootApplication
public class JsonClient {


        public static void main(String[] args) throws Exception {

            readCsvFiletoMap vminfo = new readCsvFiletoMap();

            // Settings MAP
            String path="/Users/heogeunhyeong/Downloads/2017-03-14_8F.csv";
            vminfo.setPath(path);

            List<Map<String ,String>> VMsinfo = new ArrayList<Map<String, String>>();
            VMsinfo= vminfo.getMap();

            // setting JSON

            readCsvFiletoJSON JSON_vminfo = new readCsvFiletoJSON(VMsinfo);
            JSONArray JSON_VMsinfo = JSON_vminfo.getJSON();

            for( Object VMTEST : JSON_VMsinfo){

                System.out.println("==================");
                System.out.println(VMTEST);
                System.out.println("==================");

            }


            // Send JSON HTTP POST Message
            /*
            RestTemplate rest = new RestTemplate();

            String url="https://jsonplaceholder.typicode.com/posts";

            System.out.println(rest.postForObject(url,JSON_VMsinfo,JSONArray.class))
            */

        }

}
