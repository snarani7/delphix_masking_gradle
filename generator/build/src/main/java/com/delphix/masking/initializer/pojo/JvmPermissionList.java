package com.delphix.masking.initializer.pojo;

import java.util.List;

public class JvmPermissionList {

    private PageInfo _pageInfo;
    private List<JvmPermission> responseList;

    public JvmPermissionList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<JvmPermission> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<JvmPermission> responseList) {
        this.responseList = responseList;
    }

}