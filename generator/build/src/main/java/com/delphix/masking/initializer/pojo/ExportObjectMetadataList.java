package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ExportObjectMetadataList {

    private PageInfo _pageInfo;
    private List<ExportObjectMetadata> responseList;

    public ExportObjectMetadataList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ExportObjectMetadata> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ExportObjectMetadata> responseList) {
        this.responseList = responseList;
    }

}