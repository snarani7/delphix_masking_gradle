package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ApplicationList {

    private PageInfo _pageInfo;
    private List<Application> responseList;

    public ApplicationList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<Application> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Application> responseList) {
        this.responseList = responseList;
    }

}