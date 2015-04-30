package com.japa.backend.beans;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aravindan on 26/4/15.
 */
public class BookBean {
    long id;
    String title;
    String image_url;
    String small_image_url;
    AuthorBean author;

    public long getId() {
        return id;
    }
    @XmlElement( name = "id" )
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    @XmlElement( name = "title" )
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }
    @XmlElement( name = "image_url" )
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSmall_image_url() {
        return small_image_url;
    }
    @XmlElement( name = "small_image_url" )
    public void setSmall_image_url(String small_image_url) {
        this.small_image_url = small_image_url;
    }

    public AuthorBean getAuthor() {
        return author;
    }
    @XmlElement( name = "author" )
    public void setAuthor(AuthorBean author) {
        this.author = author;
    }
}
