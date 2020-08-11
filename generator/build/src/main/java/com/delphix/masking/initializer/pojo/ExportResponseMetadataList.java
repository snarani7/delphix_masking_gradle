package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ExportResponseMetadataList {

    private PageInfo _pageInfo;
    private List<ExportResponseMetadata> responseList;

    public ExportResponseMetadataList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ExportResponseMetadata> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ExportResponseMetadata> responseList) {
        this.responseList = responseList;
    }

}