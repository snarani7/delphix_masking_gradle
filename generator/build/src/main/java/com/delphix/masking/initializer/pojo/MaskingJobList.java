package com.delphix.masking.initializer.pojo;

import java.util.List;

public class MaskingJobList {

    private PageInfo _pageInfo;
    private List<MaskingJob> responseList;

    public MaskingJobList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<MaskingJob> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<MaskingJob> responseList) {
        this.responseList = responseList;
    }

}