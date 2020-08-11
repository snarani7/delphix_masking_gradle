package com.delphix.masking.initializer.pojo;

import java.util.List;

public class OnTheFlyMaskingSourceList {

    private PageInfo _pageInfo;
    private List<OnTheFlyMaskingSource> responseList;

    public OnTheFlyMaskingSourceList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<OnTheFlyMaskingSource> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<OnTheFlyMaskingSource> responseList) {
        this.responseList = responseList;
    }

}