package com.delphix.masking.initializer.pojo;

import java.util.List;

public class FileConnectorList {

    private PageInfo _pageInfo;
    private List<FileConnector> responseList;

    public FileConnectorList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<FileConnector> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<FileConnector> responseList) {
        this.responseList = responseList;
    }

}