package com.myweb.weblog.admin.service;

import com.myweb.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.myweb.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.myweb.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.myweb.weblog.common.utils.PageResponse;
import com.myweb.weblog.common.utils.Response;

/**
 * service层，只负责业务的代码
 *业务层，只负责业务，比如对象的转换
 */
public interface AdminCategoryService {
    /**
     * 添加分类
     * @param addCategoryReqVO
     * @return
     */
    Response addCategory(AddCategoryReqVO addCategoryReqVO);

    /**
     * 分类分页数据查询
     * @param findCategoryPageListReqVO
     * @return
     */
    PageResponse findCategoryPageList(FindCategoryPageListReqVO findCategoryPageListReqVO);

    /**
     * 删除分类
     * @param deleteCategoryReqVO
     * @return
     */
    Response deleteCategory(DeleteCategoryReqVO deleteCategoryReqVO);

    /**
     * 获取文章分类的 Select 列表数据
     * @return
     */
    Response findCategorySelectList();
}
