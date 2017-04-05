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

            readCsvFile vminfo = new readCsvFile();

            // Settings path
            String[] path={"/Users/heogeunhyeong/Downloads/2017-03-14_8F.csv"};
            vminfo.setPath(path);

            JSONArray vminfos_json = vminfo.getVminfos_json();

                System.out.println("==================");
                System.out.println(vminfos_json.get(0));
                System.out.println("==================");


            // Send JSON HTTP POST Message

            RestTemplate rest = new RestTemplate();

            String url="http://10.40.99.89/api/vm/update";

            System.out.println(rest.postForObject(url,vminfos_json,JSONArray.class))


        }

}
