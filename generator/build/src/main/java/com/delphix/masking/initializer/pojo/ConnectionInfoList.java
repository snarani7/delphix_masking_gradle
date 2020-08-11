package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ConnectionInfoList {

    private PageInfo _pageInfo;
    private List<ConnectionInfo> responseList;

    public ConnectionInfoList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ConnectionInfo> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ConnectionInfo> responseList) {
        this.responseList = responseList;
    }

}