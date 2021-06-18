package com.prueba.demo.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ReadWriteFiles {

    public static Map leerArchivoConfig(String dir) {
        ResourceBundle bundle = ResourceBundle.getBundle(dir);
        Map<String, String> mapParam= new HashMap<String, String>();
        mapParam.put("userName", bundle.getString("userName"));
        mapParam.put("password", bundle.getString("password"));
        mapParam.put("dbms", bundle.getString("dbms"));
        mapParam.put("serverName", bundle.getString("serverName"));
        mapParam.put("portNumber", bundle.getString("portNumber"));
        mapParam.put("logFileFolder", bundle.getString("logFileFolder"));
        mapParam.put("nameDB", bundle.getString("nameDB"));
        return mapParam;
    }

}