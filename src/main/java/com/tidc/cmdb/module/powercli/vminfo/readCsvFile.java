package com.tidc.cmdb.module.powercli.vminfo;

import com.opencsv.CSVReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by heogeunhyeong on 2017. 4. 5..
 */
public class readCsvFile {

    private CSVReader csvReader;
    private List<String[]> vminfo_string;
    private String[] keyrow;

    private JSONArray vminfos_json = new JSONArray();

    private String[] path;

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }

    public JSONArray getVminfos_json() throws IOException {

        for (String pathseg : path) {

            csvReader = new CSVReader(new FileReader(pathseg), ',', '"', 1);
            vminfo_string = csvReader.readAll();

            keyrow = vminfo_string.get(0);
            JSONObject vminfo_json = new JSONObject();
            for (String[] vminfo1 : vminfo_string) {


                int i = 0;
                for (String vminfo2 : vminfo1) {

                    String[] vms = vminfo2.split("\\s+");
                    if (vms.length >= 2) {

                        JSONArray jsonArray = new JSONArray();
                        for (String vm : vms) {
                            jsonArray.add(vm);
                        }

                        vminfo_json.put(keyrow[i], jsonArray);
                    } else {
                        vminfo_json.put(keyrow[i], vminfo2);
                    }
                    i++;
                }
                vminfos_json.add(vminfo_json);

            }


        }
        return vminfos_json;
    }

}
