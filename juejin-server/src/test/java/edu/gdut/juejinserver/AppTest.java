package edu.gdut.juejinserver;

import edu.gdut.juejinserver.pojo.ArticleInfo;
import edu.gdut.juejinserver.service.ArticleInfoService;
import edu.gdut.juejinserver.service.impl.ArticleInfoServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class AppTest {

    ArticleInfoService articleInfoService = new ArticleInfoServiceImpl();

    @Test
    public void testQueryData() {
        articleInfoService.queryArticleInfoList(1, 20);
    }

}
