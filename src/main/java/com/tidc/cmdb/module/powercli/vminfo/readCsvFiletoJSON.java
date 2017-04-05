package com.tidc.cmdb.module.powercli.vminfo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by heogeunhyeong on 2017. 3. 15..
 */
public class readCsvFiletoJSON {

    private JSONObject obj = new JSONObject();
    private JSONArray jsonArray = new JSONArray();
    private List<Map<String ,String>> VMsinfo = new ArrayList<Map<String,String>>();

    public readCsvFiletoJSON(List<Map<String,String>> VMinfo ) throws IOException{

        VMsinfo =VMinfo;
    }


    public JSONArray getJSON() throws IOException {

        for( Map<String,String> map1 : VMsinfo) {

            obj.putAll(map1);
            jsonArray.add(obj);
        }

        return jsonArray;

    }

}
