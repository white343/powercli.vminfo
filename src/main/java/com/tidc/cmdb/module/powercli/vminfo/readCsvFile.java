package com.tidc.cmdb.module.powercli.vminfo;

import com.opencsv.CSVReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by heogeunhyeong on 2017. 4. 5..
 */
public class readCsvFile {

    private CSVReader csvReader;
    private List<String[]> vminfo_string;
    private String[] keyrow;

    private List<VminfoObject> vminfos_object = new ArrayList<VminfoObject>();

    private String[] path;


    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }

    public List<VminfoObject> getvminfos_object() throws IOException {

        for (String pathseg : path) {

            csvReader = new CSVReader(new FileReader(pathseg), ',', '"', 1);
            vminfo_string = csvReader.readAll();

            for (String[] vminfo1 : vminfo_string) {

                VminfoObject vminfo_object = new VminfoObject();

                vminfo_object.setHostkey(vminfo1[0]);
                vminfo_object.setHostName(vminfo1[1]);
                vminfo_object.setHostIP(vminfo1[2]);
                vminfo_object.setHostMac(vminfo1[3]);
                vminfo_object.setServiceNm(vminfo1[5]);
                vminfo_object.setMotherIp(vminfo1[6]);
                vminfo_object.setCpuNum(vminfo1[7]);
                vminfo_object.setMemVol(vminfo1[8]);
                vminfo_object.setDiskSize(vminfo1[9]);
                vminfo_object.setDataStore(vminfo1[10]);
                vminfo_object.setOsName(vminfo1[11]);

                vminfos_object.add(vminfo_object);


            }
        }
        return vminfos_object;

    }

}
