package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ProfileExpressionList {

    private PageInfo _pageInfo;
    private List<ProfileExpression> responseList;

    public ProfileExpressionList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ProfileExpression> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ProfileExpression> responseList) {
        this.responseList = responseList;
    }

}