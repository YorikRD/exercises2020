package com.exercisses20.auxiliary;

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
