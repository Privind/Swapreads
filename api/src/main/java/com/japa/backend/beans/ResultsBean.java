package com.japa.backend.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aravindan on 26/4/15.
 */
public class ResultsBean {

    List<WorksBean> works;
    @XmlElement( name = "work" )
    public void setWorks( List<WorksBean> works ) {
        this.works = works;
    }

    public List<WorksBean> getWorks() {
        return works;
    }

}
