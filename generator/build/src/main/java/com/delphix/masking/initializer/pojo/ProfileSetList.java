package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ProfileSetList {

    private PageInfo _pageInfo;
    private List<ProfileSet> responseList;

    public ProfileSetList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ProfileSet> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ProfileSet> responseList) {
        this.responseList = responseList;
    }

}