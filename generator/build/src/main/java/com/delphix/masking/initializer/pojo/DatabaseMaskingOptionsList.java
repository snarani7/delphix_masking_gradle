package com.delphix.masking.initializer.pojo;

import java.util.List;

public class DatabaseMaskingOptionsList {

    private PageInfo _pageInfo;
    private List<DatabaseMaskingOptions> responseList;

    public DatabaseMaskingOptionsList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<DatabaseMaskingOptions> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<DatabaseMaskingOptions> responseList) {
        this.responseList = responseList;
    }

}