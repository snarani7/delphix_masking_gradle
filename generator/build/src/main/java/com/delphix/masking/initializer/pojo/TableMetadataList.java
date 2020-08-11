package com.delphix.masking.initializer.pojo;

import java.util.List;

public class TableMetadataList {

    private PageInfo _pageInfo;
    private List<TableMetadata> responseList;

    public TableMetadataList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<TableMetadata> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<TableMetadata> responseList) {
        this.responseList = responseList;
    }

}