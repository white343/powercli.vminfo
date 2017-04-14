package com.tidc.cmdb.module.powercli.vminfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by heogeunhyeong on 2017. 3. 15..
 */
@SpringBootApplication
public class JsonClient {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(JsonClient.class);

        public static void main(String[] args) throws Exception {

            //read CsvFile
            readCsvFile vminfo = new readCsvFile();

            // Settings CsvFile Path
            String[] path={"/home/keunhyoung/vminfo/Bora_6F.csv"};

            vminfo.setPath(path);
            List<VminfoObject> vminfos_object = vminfo.getvminfos_object();

            JSONArray vminfos_json = new JSONArray();

            for(VminfoObject vminfo_object : vminfos_object) {
                JsonFormat vminfo_json = new JsonFormat(vminfo_object);
                vminfos_json.add(vminfo_json.getVminfo_json());

            }

                        // Send JSON HTTP POST Message

            HttpClient httpClient = new HttpClient();

            System.out.println(vminfos_json.size());

            System.out.println("object="+vminfos_json.get(30).toString());
            /*
            for ( Object vminfo_json1 : vminfos_json){

                String request="object="+vminfo_json1.toString();

                System.out.println(request);
                //httpClient.setUrl("http://10.40.99.89/api/vm/update");
                //httpClient.setRequest(request);

                //httpClient.sendPost(); //test
            }

*/

        }

}
