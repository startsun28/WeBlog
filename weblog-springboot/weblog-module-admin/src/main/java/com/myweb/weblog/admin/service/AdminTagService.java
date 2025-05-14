package com.myweb.weblog.admin.service;

import com.myweb.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.myweb.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.myweb.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.myweb.weblog.admin.model.vo.tag.AddTagReqVO;
import com.myweb.weblog.admin.model.vo.tag.DeleteTagReqVO;
import com.myweb.weblog.admin.model.vo.tag.FindTagPageListReqVO;
import com.myweb.weblog.admin.model.vo.tag.SearchTagsReqVO;
import com.myweb.weblog.common.domain.mapper.TagMapper;
import com.myweb.weblog.common.utils.PageResponse;
import com.myweb.weblog.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;

public interface AdminTagService {

    /**
     * 添加标签集合
     * @param addTagReqVO
     * @return
     */
    Response addTags(AddTagReqVO addTagReqVO);

    /**
     * 查询标签分页
     * @param findTagPageListReqVO(FindTagPageListReqVO findTagPageListReqVO)
     * @return
     */
    PageResponse findTagPageList(FindTagPageListReqVO findTagPageListReqVO);

    /**
     * 删除标签
     * @param deleteTagReqVO
     * @return
     */
    Response deleteTag(DeleteTagReqVO deleteTagReqVO);

    /**
     * 根据标签关键词模糊查询
     * @param searchTagsReqVO
     * @return
     */
    Response searchTags(SearchTagsReqVO searchTagsReqVO);

    /**
     * 查询标签 Select 列表数据
     * @return
     */
    Response findTagSelectList();
}
