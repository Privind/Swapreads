package com.japa.backend.beans;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aravindan on 17/4/15.
 */
public class SearchBean {

    String query;
    @XmlElement( name = "query" )
    public void setQuery( String query ) {
        this.query = query;
    }

    int results_start;
    @XmlElement( name = "results-start" )
    public void setResults_Start( int results_start ) {
        this.results_start = results_start;
    }

    int results_end;
    @XmlElement( name = "results-end" )
    public void setResults_End( int results_end ) {
        this.results_end = results_end;
    }

    int total_results;
    @XmlElement( name = "total-results" )
    public void setTotal_Results( int total_results ) {
        this.total_results = total_results;
    }

    String source;
    @XmlElement( name = "source" )
    public void setSource( String source ) {
        this.source = source;
    }

    double query_time_seconds;
    @XmlElement( name = "query-time-seconds" )
    public void setQuery_Time_Seconds( double query_time_seconds ) {
        this.query_time_seconds = query_time_seconds;
    }

    public String getQuery() {
        return query;
    }

    public int getResults_start() {
        return results_start;
    }

    public int getResults_end() {
        return results_end;
    }

    public int getTotal_results() {
        return total_results;
    }

    public String getSource() {
        return source;
    }

    public double getQuery_time_seconds() {
        return query_time_seconds;
    }

    ResultsBean results;

    public ResultsBean getResults() {
        return results;
    }
    @XmlElement( name = "results" )
    public void setResults(ResultsBean results) {
        this.results = results;
    }
}
