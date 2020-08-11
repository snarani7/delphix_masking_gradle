package com.delphix.masking.initializer.pojo;

import java.util.List;

public class AlgorithmList {

    private PageInfo _pageInfo;
    private List<Algorithm> responseList;

    public AlgorithmList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<Algorithm> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Algorithm> responseList) {
        this.responseList = responseList;
    }

}