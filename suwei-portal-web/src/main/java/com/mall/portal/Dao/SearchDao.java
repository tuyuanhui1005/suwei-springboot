package com.mall.portal.Dao;

import javax.annotation.Resource;

import com.mall.portal.Common.SearchItem;
import com.mall.portal.Common.SearchResult;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class SearchDao {


    @Resource
    SolrClient solrClient;

    public SearchResult search(SolrQuery query) {

        SearchResult result = new SearchResult();

        try {

            QueryResponse response = solrClient.query(query);

            SolrDocumentList solrDocumentList = response.getResults();

            long numFound = solrDocumentList.getNumFound();

            result.setRecordCount(numFound);

            List<SearchItem> list = new ArrayList<>();

            for (SolrDocument doc : solrDocumentList) {

                SearchItem item = new SearchItem();
                item.setId((String)doc.get("id"));
                item.setTitle((String) doc.get("item_title"));
                item.setCategory_name((String) doc.get("item_category_name"));
                item.setImage((String) doc.get("item_image"));
                item.setItem_desc((String) doc.get("item_desc"));
                item.setPrice((long) doc.get("item_price"));
                item.setSell_point((String) doc.get("item_sell_point"));
                list.add(item);
            }

            result.setItemList(list);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return result;
    }


}
