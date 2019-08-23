package com.mall.portal.controller;


import com.mall.portal.Common.SearchItem;
import com.mall.portal.Common.SearchResult;
import com.mall.portal.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    private int SEARCH_RESULT_ROWS=60;

    @RequestMapping("/Search")
    public String SearchTest(@RequestParam("keyword") String queryString ,Model model,@RequestParam(defaultValue = "1") int page){


        System.out.println(queryString);
        //执行查询
        SearchResult result =  searchService.search(queryString,page,SEARCH_RESULT_ROWS);

        //传值到前台页面
        model.addAttribute("query",queryString);
        model.addAttribute("totalPages",result.getTotalPages());
        model.addAttribute("itemList",result.getItemList());
        model.addAttribute("page",page);
        model.addAttribute("recourdCount", result.getRecordCount());


        return "User/Search";


    }

}
