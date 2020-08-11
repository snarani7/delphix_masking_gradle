package com.delphix.masking.initializer.pojo;

import java.util.List;

public class FileFormatList {

    private PageInfo _pageInfo;
    private List<FileFormat> responseList;

    public FileFormatList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<FileFormat> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<FileFormat> responseList) {
        this.responseList = responseList;
    }

}