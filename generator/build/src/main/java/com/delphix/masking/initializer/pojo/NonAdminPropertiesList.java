package com.delphix.masking.initializer.pojo;

import java.util.List;

public class NonAdminPropertiesList {

    private PageInfo _pageInfo;
    private List<NonAdminProperties> responseList;

    public NonAdminPropertiesList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<NonAdminProperties> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<NonAdminProperties> responseList) {
        this.responseList = responseList;
    }

}