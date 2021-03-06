package com.tidc.cmdb.module.powercli.vminfo;

public class VminfoObject {

    private static final String[] key = {"HostKey","HostName","HostIP","HostMac","ServiceNm","MotherIp","CpuNum","MemVol","DiskSize","DataStore","OsName"};
    private String Hostkey;
    private String HostName;
    private String HostIP;
    private String HostMac;
    private String ServiceNm;
    private String MotherIp;
    private String CpuNum;
    private String MemVol;
    private String DiskSize;
    private String DataStore;
    private String OsName;


    readCsvFile readcsvfile = new readCsvFile();





    public static String[] getKey() {
        return key;
    }

    @Override
    public String toString() {
        String result;
        return result = key[0]+":"+Hostkey+","
                + key[1]+":"+HostName+","
                + key[2]+":"+HostIP+","
                + key[3]+":"+HostMac+","
                + key[4]+":"+ServiceNm+","
                + key[5]+":"+MotherIp+","
                + key[6]+":"+CpuNum+","
                + key[7]+":"+MemVol+","
                + key[8]+":"+DiskSize+","
                + key[9]+":"+DataStore+","
                + key[10]+":"+OsName;
    }

    public String getHostkey() {
        return Hostkey;
    }

    public void setHostkey(String hostkey) {
        Hostkey = hostkey;
    }

    public String getHostName() {
        return HostName;
    }

    public void setHostName(String hostName) {
        HostName = hostName;
    }

    public String getHostIP() {
        return HostIP;
    }

    public void setHostIP(String hostIP) {
        HostIP = hostIP;
    }

    public String getHostMac() {
        return HostMac;
    }

    public void setHostMac(String hostMac) {
        HostMac = hostMac;
    }

    public String getServiceNm() {
        return ServiceNm;
    }

    public void setServiceNm(String serviceNm) {
        ServiceNm = serviceNm;
    }

    public String getMotherIp() {
        return MotherIp;
    }

    public void setMotherIp(String motherIp) {
        MotherIp = motherIp;
    }

    public String getCpuNum() {
        return CpuNum;
    }

    public void setCpuNum(String cpuNum) {
        CpuNum = cpuNum;
    }

    public String getMemVol() {
        return MemVol;
    }

    public void setMemVol(String memVol) {
        MemVol = memVol;
    }

    public String getDiskSize() {
        return DiskSize;
    }

    public void setDiskSize(String diskSize) {
        DiskSize = diskSize;
    }

    public String getDataStore() {
        return DataStore;
    }

    public void setDataStore(String dataStore) {
        DataStore = dataStore;
    }

    public String getOsName() {
        return OsName;
    }

    public void setOsName(String osName) {
        OsName = osName;
    }
}
