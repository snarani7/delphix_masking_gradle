package com.delphix.masking.initializer.pojo;

import java.util.List;

public class DomainList {

    private PageInfo _pageInfo;
    private List<Domain> responseList;

    public DomainList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<Domain> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Domain> responseList) {
        this.responseList = responseList;
    }

}