package com.delphix.masking.initializer.pojo;

import java.util.List;

public class EnvironmentList {

    private PageInfo _pageInfo;
    private List<Environment> responseList;

    public EnvironmentList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<Environment> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Environment> responseList) {
        this.responseList = responseList;
    }

}