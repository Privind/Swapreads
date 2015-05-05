package com.japa.backend.beans;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aravindan on 17/4/15.
 */
public class SearchBean {

    String query;
    int resultStart;
    int resultEnd;
    int total_results;
    String source;
    double queryTimeSeconds;
    ResultsBean results;

    @XmlElement( name = "query" )
    public void setQuery( String query ) {
        this.query = query;
    }
    public String getQuery() {
        return query;
    }

    @XmlElement( name = "results-start" )
    public void setResultStart( int resultStart ) {
        this.resultStart = resultStart;
    }
    public int getResultStart() {
        return resultStart;
    }

    @XmlElement( name = "results-end" )
    public void setResultEnd( int resultEnd ) {
        this.resultEnd = resultEnd;
    }
    public int getResultEnd() {
        return resultEnd;
    }

    @XmlElement( name = "total-results" )
    public void setTotal_results( int total_results ) {
        this.total_results = total_results;
    }
    public int getTotal_results() {
        return total_results;
    }

    @XmlElement( name = "source" )
    public void setSource( String source ) {
        this.source = source;
    }
    public String getSource() {
        return source;
    }

    @XmlElement( name = "query-time-seconds" )
    public void setQueryTimeSeconds( double queryTimeSeconds ) {
        this.queryTimeSeconds = queryTimeSeconds;
    }
    public double getQueryTimeSeconds() {
        return queryTimeSeconds;
    }

    public ResultsBean getResults() {
        return results;
    }
    @XmlElement( name = "results" )
    public void setResults(ResultsBean results) {
        this.results = results;
    }
}
