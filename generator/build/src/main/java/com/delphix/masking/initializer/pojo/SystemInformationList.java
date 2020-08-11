package com.delphix.masking.initializer.pojo;

import java.util.List;

public class SystemInformationList {

    private PageInfo _pageInfo;
    private List<SystemInformation> responseList;

    public SystemInformationList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<SystemInformation> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<SystemInformation> responseList) {
        this.responseList = responseList;
    }

}