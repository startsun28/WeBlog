package com.myweb.weblog.admin.convert;

import com.myweb.weblog.admin.model.vo.article.FindArticleDetailRspVO;
import com.myweb.weblog.common.domain.dos.ArticleDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct 转换接口
 */
@Mapper
public interface ArticleDetailConvert {
    /**
     * 初始化 convert 实例
     */
    ArticleDetailConvert INSTANCE = Mappers.getMapper(ArticleDetailConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindArticleDetailRspVO convertDO2VO(ArticleDO bean);

}
