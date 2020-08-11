package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ColumnMetadataList {

    private PageInfo _pageInfo;
    private List<ColumnMetadata> responseList;

    public ColumnMetadataList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ColumnMetadata> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ColumnMetadata> responseList) {
        this.responseList = responseList;
    }

}