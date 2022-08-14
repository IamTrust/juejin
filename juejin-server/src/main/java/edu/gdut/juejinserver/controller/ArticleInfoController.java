package edu.gdut.juejinserver.controller;

import edu.gdut.juejinserver.service.ArticleInfoService;
import edu.gdut.juejinserver.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Trust会长
 * @since 2022-07-30
 */
@RestController
@RequestMapping("/juejinserver/index_data")
@CrossOrigin
public class ArticleInfoController {

    @Resource
    private ArticleInfoService articleInfoService;

    /**
     * 分页查询首页文章
     * @param current 当前页
     * @param limit 每页记录数
     * @return 统一返回结果
     */
    @GetMapping("/find_article/{current}/{limit}")
    public Result findIndexArticle(@PathVariable Integer current, @PathVariable Integer limit) {
//        Page<ArticleInfo> page = new Page<>(current, limit);
//        articleInfoService.page(page, null);
//        return Result.success().data("article_info", page.getRecords());
        return Result.success().data("article_info", articleInfoService.queryArticleInfoList(current, limit));
    }

    /**
     * test接口
     * @param current
     * @param limit
     * @return
     */
    @GetMapping("/find_article_info_items/{current}/{limit}")
    public Result findIndexArticleInfoItems(@PathVariable Integer current, @PathVariable Integer limit) {
        return Result.success().data("article_info", articleInfoService.queryArticleInfoList(current, limit));
    }

    @GetMapping("/findArticleDetail/{articleId}")
    public Result findArticleDetailById(@PathVariable String articleId) {
        return Result.success().data("articleDetail", articleInfoService.getArticleDetailById(articleId));
    }

    @GetMapping("/findArticleTags/{articleId}")
    public Result findArticleTagsById(@PathVariable String articleId) {
        return Result.success().data("tags", articleInfoService.getArticleTagsById(articleId));
    }

}

