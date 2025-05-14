package com.myweb.weblog.admin.service;

import com.myweb.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.myweb.weblog.common.utils.Response;

public interface AdminUserService {
    /**
     * 修改密码
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Response findUserInfo();
}
