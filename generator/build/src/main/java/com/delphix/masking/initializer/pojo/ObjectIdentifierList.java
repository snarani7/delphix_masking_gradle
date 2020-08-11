package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ObjectIdentifierList {

    private PageInfo _pageInfo;
    private List<ObjectIdentifier> responseList;

    public ObjectIdentifierList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ObjectIdentifier> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ObjectIdentifier> responseList) {
        this.responseList = responseList;
    }

}