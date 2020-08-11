package com.delphix.masking.initializer.pojo;

import java.util.List;

public class MaskingJobScriptList {

    private PageInfo _pageInfo;
    private List<MaskingJobScript> responseList;

    public MaskingJobScriptList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<MaskingJobScript> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<MaskingJobScript> responseList) {
        this.responseList = responseList;
    }

}