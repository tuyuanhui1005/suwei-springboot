package com.mall.portal.Service;

import com.mall.portal.Common.SearchResult;

public  interface SearchService {

    /**
     *
     * @param queryString  查询条件
     * @param page  页数
     * @param rows
     * @return
     */
    public SearchResult search(String queryString , int page, int rows);
}
