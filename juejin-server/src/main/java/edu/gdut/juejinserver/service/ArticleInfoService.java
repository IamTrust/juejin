package edu.gdut.juejinserver.service;

import edu.gdut.juejinserver.pojo.ArticleInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.gdut.juejinserver.vo.ArticleDetailVo;
import edu.gdut.juejinserver.vo.ArticleInfoVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Trust会长
 * @since 2022-07-30
 */
public interface ArticleInfoService extends IService<ArticleInfo> {

    /**
     * 分页查询数据
     * @param current 当前页
     * @param limit 每页记录数
     * @return
     */
    List<ArticleInfoVo> queryArticleInfoList(int current, int limit);

    /**
     * 查询文章和作者详情
     * @param articleId 文章id
     * @return 文章详情
     */
    ArticleDetailVo getArticleDetailById(String articleId);

    List<String> getArticleTagsById(String articleId);
}
