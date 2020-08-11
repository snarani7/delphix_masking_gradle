package com.delphix.masking.initializer.pojo;

import java.util.List;

public class JdbcDriverList {

    private PageInfo _pageInfo;
    private List<JdbcDriver> responseList;

    public JdbcDriverList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<JdbcDriver> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<JdbcDriver> responseList) {
        this.responseList = responseList;
    }

}