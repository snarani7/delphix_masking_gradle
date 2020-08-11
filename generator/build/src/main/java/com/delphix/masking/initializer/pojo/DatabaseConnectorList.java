package com.delphix.masking.initializer.pojo;

import java.util.List;

public class DatabaseConnectorList {

    private PageInfo _pageInfo;
    private List<DatabaseConnector> responseList;

    public DatabaseConnectorList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<DatabaseConnector> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<DatabaseConnector> responseList) {
        this.responseList = responseList;
    }

}