package com.endurance.india.mux.lambda;

import javax.persistence.*;

/**
 * Created by akhil on 23/6/17.
 */
@Entity
public class Lambda {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    @Column( length = 1000000)
    private String function;
    private String pageId;
    private String formId;

    public Lambda() {
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public Lambda(String function, String formId, String pageId) {
        this.function = function;
        this.formId = formId;
        this.pageId = pageId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
