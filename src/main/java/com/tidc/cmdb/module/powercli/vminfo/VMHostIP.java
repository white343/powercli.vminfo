package com.tidc.cmdb.module.powercli.vminfo;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by keunhyoung on 17. 4. 14.
 */
public class VMHostIP {


    private String path ="/home/keunhyoung/vminfo/VMHOSTIP.csv";
    Map<String,String> vmhosts_info = new HashMap<String,String>();
    private List<String[]> vminfo_string;
    private CSVReader csvReader;

    public Map<String, String> getVmhosts_info() throws IOException {

        csvReader = new CSVReader(new FileReader(path),',', '"', 2);
        vminfo_string = csvReader.readAll();

        for( String[] vmhostinfo : vminfo_string){
            String hostname =vmhostinfo[0];
            String MotherIp =vmhostinfo[2];


            vmhosts_info.put(hostname,MotherIp);

        }

        return vmhosts_info;
    }

    

   
}
