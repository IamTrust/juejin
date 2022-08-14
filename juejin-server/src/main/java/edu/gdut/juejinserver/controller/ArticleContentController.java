package edu.gdut.juejinserver.controller;


import edu.gdut.juejinserver.service.ArticleContentService;
import edu.gdut.juejinserver.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Trust会长
 * @since 2022-08-14
 */
@RestController
@RequestMapping("/juejinserver/article_content")
@CrossOrigin
public class ArticleContentController {

    @Resource
    private ArticleContentService articleContentService;

    /**
     * 根据文章id查询文章内容
     * @param articleId 文章id
     * @return 结果
     */
    @GetMapping("/getArticleContent/{articleId}")
    public Result getArticleContent(@PathVariable String articleId) {
        return Result.success().data("articleContent", articleContentService.getById(articleId).getMarkContent());
    }

}

