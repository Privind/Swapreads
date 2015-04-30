package com.japa.backend.beans;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aravindan on 26/4/15.
 */
public class AuthorBean {

    long author_id;
    String author_name;

    public long getAuthor_id() {
        return author_id;
    }
    @XmlElement( name = "id" )
    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }
    @XmlElement( name = "name" )
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

}
