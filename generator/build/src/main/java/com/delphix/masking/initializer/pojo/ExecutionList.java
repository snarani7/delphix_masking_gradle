package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ExecutionList {

    private PageInfo _pageInfo;
    private List<Execution> responseList;

    public ExecutionList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<Execution> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Execution> responseList) {
        this.responseList = responseList;
    }

}