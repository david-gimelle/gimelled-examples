package com.gimelle.sandbox.optional.domain;

public class USB {

    private String version;

    public String getVersion() {
        return version;
    }

    public USB withVersion(String version) {
        this.version = version;
        return this;
    }
}