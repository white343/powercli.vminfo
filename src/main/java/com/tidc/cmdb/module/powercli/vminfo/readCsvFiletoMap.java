package com.tidc.cmdb.module.powercli.vminfo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.opencsv.*;

/**
 * Created by heogeunhyeong on 2017. 3. 14..
 */
public class readCsvFiletoMap {

    private String Path;
    private CSVReader reader;
    private List<String[]> VMinfo;
    private String[] row1 ;
    private Map<String,String> Map1 = new HashMap<String,String>();
    private List<Map<String ,String>> VMsinfo = new ArrayList<Map<String,String>>();

    public readCsvFiletoMap() throws IOException {

    }

    public  void setPath(String a){
        Path = a;
    }

    public List<Map<String,String>> getMap() throws IOException {

        reader = new CSVReader ( new FileReader(Path),',','"',1);
        try {
            VMinfo = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        row1 =VMinfo.get(0);

        for (String[] row : VMinfo){
            for (int i=0 ; i < row.length; i++) {
                Map1.put(row1[i], row[i]);
            }

            VMsinfo.add(Map1);
        }

        return VMsinfo;

    }

}






