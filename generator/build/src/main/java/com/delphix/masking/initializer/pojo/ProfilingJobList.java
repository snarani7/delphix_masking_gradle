package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ProfilingJobList {

    private PageInfo _pageInfo;
    private List<ProfilingJob> responseList;

    public ProfilingJobList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ProfilingJob> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ProfilingJob> responseList) {
        this.responseList = responseList;
    }

}