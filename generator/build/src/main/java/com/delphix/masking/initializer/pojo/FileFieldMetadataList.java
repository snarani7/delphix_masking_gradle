package com.delphix.masking.initializer.pojo;

import java.util.List;

public class FileFieldMetadataList {

    private PageInfo _pageInfo;
    private List<FileFieldMetadata> responseList;

    public FileFieldMetadataList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<FileFieldMetadata> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<FileFieldMetadata> responseList) {
        this.responseList = responseList;
    }

}