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
            String[] path={"/home/keunhyoung/2017-04-11_8층VM현황자료.csv"};
            vminfo.setPath(path);

            List<VminfoObject> vminfos_object = vminfo.getvminfos_object();
            JSONArray vminfos_json = new JSONArray();
            for(VminfoObject vminfo_object : vminfos_object) {
                JsonFormat vminfo_json = new JsonFormat(vminfo_object);
                vminfos_json.add(vminfo_json.getVminfo_json());

            }

                System.out.println("==================");
                System.out.println(vminfos_json.get(30));
                System.out.println("==================");


            // Send JSON HTTP POST Message

            //RestTemplate rest = new RestTemplate();

            //String url="http://10.40.99.89/api/vm/update";

            //System.out.println(rest.postForObject(url,vminfos_json.get(0),JSONObject.class));


        }

}
