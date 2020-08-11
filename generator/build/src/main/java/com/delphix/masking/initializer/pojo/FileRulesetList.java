package com.delphix.masking.initializer.pojo;

import java.util.List;

public class FileRulesetList {

    private PageInfo _pageInfo;
    private List<FileRuleset> responseList;

    public FileRulesetList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<FileRuleset> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<FileRuleset> responseList) {
        this.responseList = responseList;
    }

}