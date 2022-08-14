package edu.gdut.juejinserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.gdut.juejinserver.mapper.AuthorUserMapper;
import edu.gdut.juejinserver.mapper.TagsMapper;
import edu.gdut.juejinserver.pojo.ArticleInfo;
import edu.gdut.juejinserver.mapper.ArticleInfoMapper;
import edu.gdut.juejinserver.pojo.AuthorUser;
import edu.gdut.juejinserver.pojo.Tags;
import edu.gdut.juejinserver.service.ArticleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.gdut.juejinserver.utils.JuejinStringUtils;
import edu.gdut.juejinserver.vo.ArticleDetailVo;
import edu.gdut.juejinserver.vo.ArticleInfoVo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Trust会长
 * @since 2022-07-30
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements ArticleInfoService {

    @Resource
    private ArticleInfoMapper articleInfoMapper;
    @Resource
    private AuthorUserMapper authorUserMapper;
    @Resource
    private TagsMapper tagsMapper;

    @Override
    @Cacheable(value = "juejin", key = "'articleList' + #current + 'Current' + #limit + 'Limit'")
    public List<ArticleInfoVo> queryArticleInfoList(int current, int limit) {
        List<ArticleInfoVo> list = new ArrayList<>();
        // 分页查询article数据
        Page<ArticleInfo> page = new Page<>(current, limit);
        articleInfoMapper.selectPage(page, null);
        List<ArticleInfo> articleInfos = null;
        if (page.getRecords().size() < limit) {
            // 不足limit条记录的时候
            // 随机查连续limit条记录
            QueryWrapper<ArticleInfo> wrapper = new QueryWrapper<>();
            Integer count = articleInfoMapper.selectCount(null);
            // 生成一个随机数。范围为 0 —— （count - limit）
            int random = (int)(Math.random() * (count - limit));
            wrapper.last("limit "+ random +"," + limit);
            articleInfos = articleInfoMapper.selectList(wrapper);
        } else {
            // 足够
            articleInfos = page.getRecords();
        }
        // 根据userId查作者
        // 根据tagId查tag
        for (ArticleInfo article : articleInfos) {
            ArticleInfoVo vo = new ArticleInfoVo();
            // 封装数据
            vo.setArticleId(article.getArticleId());
            vo.setBriefContent(article.getBriefContent());
            vo.setCollectCount(article.getCollectCount());
            vo.setCommentCount(article.getCommentCount());
            vo.setCtime(article.getCtime());
            vo.setCoverImage(article.getCoverImage());
            vo.setDiggCount(article.getDiggCount());
            vo.setMtime(article.getMtime());
            vo.setRtime(article.getRtime());
            vo.setTitle(article.getTitle());
            vo.setUserId(article.getUserId());
            vo.setViewCount(article.getViewCount());

            // 二次处理的数据
            AuthorUser user = authorUserMapper.selectById(article.getUserId());
            vo.setUserName(user.getUserName());

            // tagIds和tagNames
            String tagIds = article.getTagIds();
            String[] tagIdsArr = JuejinStringUtils.getTagIdsArray(tagIds);
            vo.setTagsIds(tagIdsArr);
            // 根据tagId查tagName
            List<String> tagNames = new ArrayList<>();
            for (int i = 0; i < tagIdsArr.length; i++) {
                QueryWrapper<Tags> wrapper = new QueryWrapper<>();
                wrapper.eq("tag_id", tagIdsArr[i]);
                Tags tag = tagsMapper.selectOne(wrapper);
                if (tag != null) tagNames.add(tag.getTagName());
            }
            // 设置tagNames
            vo.setTagNames(tagNames);
            list.add(vo);
        }
        return list;
    }

    @Override
    public ArticleDetailVo getArticleDetailById(String articleId) {
        return articleInfoMapper.queryArticleInfoById(articleId);
    }

    @Override
    public List<String> getArticleTagsById(String articleId) {
        ArticleInfo articleInfo = articleInfoMapper.selectById(articleId);
        String tagIds = articleInfo.getTagIds();
        String[] tagIdsArray = JuejinStringUtils.getTagIdsArray(tagIds);
        List<String> tags = new ArrayList<>();
        // 根据tagId查tagName
        for (String s : tagIdsArray) {
            QueryWrapper<Tags> wrapper = new QueryWrapper<>();
            wrapper.eq("tag_id", s);
            Tags tag = tagsMapper.selectOne(wrapper);
            if (tag != null) tags.add(tag.getTagName());
        }
        return tags;
    }

}
