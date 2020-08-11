package com.delphix.masking.initializer.pojo;

import java.util.List;

public class MountInformationList {

    private PageInfo _pageInfo;
    private List<MountInformation> responseList;

    public MountInformationList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<MountInformation> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<MountInformation> responseList) {
        this.responseList = responseList;
    }

}