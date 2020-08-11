package com.delphix.masking.initializer.pojo;

import java.util.List;

public class DatabaseRulesetList {

    private PageInfo _pageInfo;
    private List<DatabaseRuleset> responseList;

    public DatabaseRulesetList() {}

    public PageInfo getPageInfo() {
        return _pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this._pageInfo = pageInfo;
    }

    public List<DatabaseRuleset> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<DatabaseRuleset> responseList) {
        this.responseList = responseList;
    }

}