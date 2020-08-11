package com.delphix.masking.initializer.pojo;

import java.util.List;

public class FileMetadataList {

    private PageInfo _pageInfo;
    private List<FileMetadata> responseList;

    public FileMetadataList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<FileMetadata> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<FileMetadata> responseList) {
        this.responseList = responseList;
    }

}