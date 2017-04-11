package com.tidc.cmdb.module.powercli.vminfo;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by keunhyoung on 17. 4. 11.
 */
public class JsonFormat {

    private JSONObject vminfo_json = new JSONObject();

    public JsonFormat(VminfoObject vminfo_object) throws JSONException {
        String[] key = vminfo_object.getKey();
        // IP spilt with space
        String[] ips = vminfo_object.getHostIP().split("\\s+");
        JSONArray ips_jsonarray = new JSONArray();
        for(String ip : ips) ips_jsonarray.put(ip);
        // Mac spilt with space
        String[] macs = vminfo_object.getHostMac().split("\\s+");
        JSONArray macs_jsonarray = new JSONArray();
        for(String mac : macs) macs_jsonarray.put(mac);

        vminfo_json.put(key[0],vminfo_object.getHostkey());
        vminfo_json.put(key[1],vminfo_object.getHostName());
        vminfo_json.put(key[2],ips_jsonarray);
        vminfo_json.put(key[3],macs_jsonarray);
        vminfo_json.put(key[4],vminfo_object.getServiceNm());
        vminfo_json.put(key[5],vminfo_object.getMotherIp());
        vminfo_json.put(key[6],vminfo_object.getCpuNum());
        vminfo_json.put(key[7],vminfo_object.getMemVol());
        vminfo_json.put(key[8],vminfo_object.getDiskSize());
        vminfo_json.put(key[9],vminfo_object.getDataStore());
        vminfo_json.put(key[10],vminfo_object.getOsName());
    }

    public void setVminfo_json(VminfoObject vminfo_object) throws JSONException {

        String[] key = vminfo_object.getKey();

        vminfo_json.put(key[0],vminfo_object.getHostkey());
        vminfo_json.put(key[1],vminfo_object.getHostName());
        vminfo_json.put(key[2],vminfo_object.getHostIP());
        vminfo_json.put(key[3],vminfo_object.getHostMac());
        vminfo_json.put(key[4],vminfo_object.getServiceNm());
        vminfo_json.put(key[5],vminfo_object.getMotherIp());
        vminfo_json.put(key[6],vminfo_object.getCpuNum());
        vminfo_json.put(key[7],vminfo_object.getMemVol());
        vminfo_json.put(key[8],vminfo_object.getDiskSize());
        vminfo_json.put(key[9],vminfo_object.getDataStore());
        vminfo_json.put(key[10],vminfo_object.getOsName());

    }

    public JSONObject getVminfo_json() {
        return vminfo_json;
    }
}
