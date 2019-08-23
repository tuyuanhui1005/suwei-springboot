package com.mall.portal.Common;

import java.io.Serializable;
import java.util.List;

public class SearchResult  implements Serializable {

    private long totalPages;//总条数
    private long recordCount;//总条数
    private List<SearchItem> itemList;//数据信息
    public long getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
    public long getRecordCount() {
        return recordCount;
    }
    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }
    public List<SearchItem> getItemList() {
        return itemList;
    }
    public void setItemList(List<SearchItem> itemList) {
        this.itemList = itemList;
    }
}
