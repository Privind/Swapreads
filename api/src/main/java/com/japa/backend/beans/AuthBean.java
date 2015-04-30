package com.japa.backend.beans;

/**
 * The object model for the data we are sending through endpoints
 */
public class AuthBean {

    private String authUrl;

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }
}