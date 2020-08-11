package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ExportObjectList {

    private PageInfo _pageInfo;
    private List<ExportObject> responseList;

    public ExportObjectList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ExportObject> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ExportObject> responseList) {
        this.responseList = responseList;
    }

}