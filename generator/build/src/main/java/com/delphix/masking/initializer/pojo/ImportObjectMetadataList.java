package com.delphix.masking.initializer.pojo;

import java.util.List;

public class ImportObjectMetadataList {

    private PageInfo _pageInfo;
    private List<ImportObjectMetadata> responseList;

    public ImportObjectMetadataList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<ImportObjectMetadata> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<ImportObjectMetadata> responseList) {
        this.responseList = responseList;
    }

}