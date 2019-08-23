package com.mall.portal.Service.ServiceImpl;

import com.mall.portal.Common.SearchResult;
import com.mall.portal.Dao.SearchDao;
import com.mall.portal.Service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SearchServiceImpl implements SearchService {
    @Resource
    SearchDao searchDao;


    @Override
    public SearchResult search(String queryString, int page, int rows) {

        SolrQuery query = new SolrQuery();

        query.setQuery(queryString);

        if (page < 1)
            page = 1;
        query.setStart((page - 1) * rows);
        if (rows < 1)
            rows = 10;
        query.setRows(rows);

        //设置默认的搜索字段
        query.set("df","item_title");

        SearchResult searchResult = searchDao.search(query);

        long totalCount = searchResult.getRecordCount();

        long totalPage = (long) Math.ceil((totalCount * 1.0) / rows);

        searchResult.setTotalPages(totalPage);

        return searchResult;
    }
}
