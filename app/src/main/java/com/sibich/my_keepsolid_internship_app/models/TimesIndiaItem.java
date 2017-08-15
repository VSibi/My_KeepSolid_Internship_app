package com.sibich.my_keepsolid_internship_app.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class TimesIndiaItem {

       /* @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("sortBy")
        @Expose
        private String sortBy;*/
        @SerializedName("articles")
        @Expose
        private List<Article> articles;

    /*public TimesIndiaItem(String status, String source, String sortBy, List<Article> articles) {
        this.status = status;
        this.source = source;
        this.sortBy = sortBy;
        this.articles = articles;
    }*/

    public TimesIndiaItem() {
        articles = new ArrayList<>();
    }


   /* public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSortBy() {
            return sortBy;
        }

        public void setSortBy(String sortBy) {
            this.sortBy = sortBy;
        }*/

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }

/*
    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("link")
    @Expose
    private Object link;
    @SerializedName("elementPureHtml")
    @Expose
    private String elementPureHtml;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getLink() {
        return link;
    }

    public void setLink(Object link) {
        this.link = link;
    }

    public String getElementPureHtml() {
        return elementPureHtml;
    }

    public void setElementPureHtml(String elementPureHtml) {
        this.elementPureHtml = elementPureHtml;
    }
    */

}
