package com.japa.backend.beans;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aravindan on 26/4/15.
 */
public class RequestBean {
    boolean authentication;
    String key;
    String method;

    public boolean isAuthentication() {
        return authentication;
    }
    @XmlElement( name = "authentication" )
    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }

    public String getKey() {
        return key;
    }
    @XmlElement( name = "key" )
    public void setKey(String key) {
        this.key = key;
    }

    public String getMethod() {
        return method;
    }
    @XmlElement( name = "method" )
    public void setMethod(String method) {
        this.method = method;
    }
}
