package com.myweb.weblog.web.service;

import com.myweb.weblog.common.utils.Response;
import com.myweb.weblog.web.model.vo.search.SearchArticlePageListReqVO;

public interface SearchService {

    /**
     * 关键词分页搜索
     * @param searchArticlePageListReqVO
     * @return
     */
    Response searchArticlePageList(SearchArticlePageListReqVO searchArticlePageListReqVO);
}


