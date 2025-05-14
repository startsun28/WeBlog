package com.myweb.weblog.admin.service;

import com.myweb.weblog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import com.myweb.weblog.common.utils.Response;

/**
 *@description:博客接口
 **/
public interface AdminBlogSettingsService {
    /**
     * 更新博客设置信息
     * @param updateBlogSettingsReqVO
     * @return
     */
    Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO);

    /**
     * 获取博客设置详情
     * @return
     */
    Response findDetail();
}
