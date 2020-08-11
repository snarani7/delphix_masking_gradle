package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ExecutionComponentList {

    private PageInfo _pageInfo;
    private List<ExecutionComponent> responseList;

    public ExecutionComponentList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ExecutionComponent> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ExecutionComponent> responseList) {
        this.responseList = responseList;
    }

}