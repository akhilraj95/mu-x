package com.endurance.india.mux.page;


import javax.persistence.*;

/**
 * Created by akhil on 23/6/17.
 */
@Entity
public class Page {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    @Column( length = 1000000)
    private String html;

    public Page() {
    }

    public Page(String html) {
        this.html = html;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
