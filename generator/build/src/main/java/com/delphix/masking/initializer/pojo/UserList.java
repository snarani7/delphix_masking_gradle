package com.delphix.masking.initializer.pojo;

import java.util.List;

public class UserList {

    private PageInfo _pageInfo;
    private List<User> responseList;

    public UserList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<User> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<User> responseList) {
        this.responseList = responseList;
    }

}