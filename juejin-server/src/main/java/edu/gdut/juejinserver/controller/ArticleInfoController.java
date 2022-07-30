package edu.gdut.juejinserver.controller;


import edu.gdut.juejinserver.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Trust会长
 * @since 2022-07-30
 */
@RestController
@RequestMapping("/juejinserver/article-info")
public class ArticleInfoController {

    /**
     * 分页查询首页文章
     * @param current 当前页
     * @param limit 每页记录数
     * @return 统一返回结果
     */
    @GetMapping("/find_article/{current}/{limit}")
    public Result findIndexArticle(@PathVariable Integer current, @PathVariable Integer limit) {
        return null;
    }

}

