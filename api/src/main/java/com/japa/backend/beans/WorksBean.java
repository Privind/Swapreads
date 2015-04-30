package com.japa.backend.beans;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aravindan on 25/4/15.
 */
public class WorksBean {

    long id;
    int books_count;
    int ratings_count;
    int text_reviews_count;
    int original_publication_year;
    int original_publication_month;
    int original_publication_day;
    int average_rating;
    BookBean book;

    public long getId() {
        return id;
    }
    @XmlElement( name = "id" )
    public void setId(long id) {
        this.id = id;
    }

    public int getBooks_count() {
        return books_count;
    }
    @XmlElement( name = "books_count" )
    public void setBooks_count(int books_count) {
        this.books_count = books_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }
    @XmlElement( name = "ratings_count" )
    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public int getText_reviews_count() {
        return text_reviews_count;
    }
    @XmlElement( name = "text_reviews_count" )
    public void setText_reviews_count(int text_reviews_count) {
        this.text_reviews_count = text_reviews_count;
    }

    public int getOriginal_publication_year() {
        return original_publication_year;
    }
    @XmlElement( name = "original_publication_year" )
    public void setOriginal_publication_year(int original_publication_year) {
        this.original_publication_year = original_publication_year;
    }

    public int getOriginal_publication_month() {
        return original_publication_month;
    }
    @XmlElement( name = "original_publication_month" )
    public void setOriginal_publication_month(int original_publication_month) {
        this.original_publication_month = original_publication_month;
    }

    public int getOriginal_publication_day() {
        return original_publication_day;
    }
    @XmlElement( name = "original_publication_day" )
    public void setOriginal_publication_day(int original_publication_day) {
        this.original_publication_day = original_publication_day;
    }

    public int getAverage_rating() {
        return average_rating;
    }
    @XmlElement( name = "average_rating" )
    public void setAverage_rating(int average_rating) {
        this.average_rating = average_rating;
    }

    public BookBean getBook() {
        return book;
    }
    @XmlElement( name = "best_book" )
    public void setBook(BookBean book) {
        this.book = book;
    }
}
