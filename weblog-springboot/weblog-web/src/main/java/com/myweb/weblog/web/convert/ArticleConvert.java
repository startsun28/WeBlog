package com.myweb.weblog.web.convert;

import com.myweb.weblog.common.domain.dos.ArticleDO;
import com.myweb.weblog.web.model.vo.article.FindIndexArticlePageListRspVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * convert 装换接口
 */
@Mapper
public interface ArticleConvert {
    /**
     * 初始化 convert 实例
     */
    ArticleConvert INSTANCE = Mappers.getMapper(ArticleConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindIndexArticlePageListRspVO convertDO2VO(ArticleDO bean);

}

