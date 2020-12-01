package com.exam02.auxiliary;


/**
 * Enum with primitive data allowing to create ClientMultiThread and Simpleserver instances in a simple wat
 */

public enum LocalhostOrLan {
    LAN("server.port","server.ip"), LOCALHOST("local.port","local.server.ip")
    ;
    private String port;
    private String ip;
    static final public String path = "config.properties";

    public String getPath() {
        return path;
    }

    public String getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    LocalhostOrLan(String portKey, String ipKey) {
        this.port = portKey;
        this.ip = ipKey;
    }
}
