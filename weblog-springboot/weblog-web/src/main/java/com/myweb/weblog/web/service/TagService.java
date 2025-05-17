package com.myweb.weblog.web.service;

import com.myweb.weblog.common.utils.Response;

public interface TagService {
    /**
     * 获取标签列表
     * @return
     */
    Response findTagList();
}
