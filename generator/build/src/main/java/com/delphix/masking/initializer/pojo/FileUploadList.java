package com.delphix.masking.initializer.pojo;

import java.util.List;

public class FileUploadList {

    private PageInfo _pageInfo;
    private List<FileUpload> responseList;

    public FileUploadList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<FileUpload> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<FileUpload> responseList) {
        this.responseList = responseList;
    }

}