package com.japa.backend.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by aravindan on 26/4/15.
 */
@XmlRootElement( name = "GoodreadsResponse" )
public class GrResponseBean {
    SearchBean search;
    RequestBean request;

    public SearchBean getSearch() {
        return search;
    }
    @XmlElement( name = "search" )
    public void setSearch(SearchBean search) {
        this.search = search;
    }

    public RequestBean getRequest() {
        return request;
    }
    @XmlElement( name = "Request" )
    public void setRequest(RequestBean request) {
        this.request = request;
    }
}
