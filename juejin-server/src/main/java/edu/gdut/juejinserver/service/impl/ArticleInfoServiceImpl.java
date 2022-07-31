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
import edu.gdut.juejinserver.vo.ArticleInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
            // tagIds: [123, 456, 789, 2142]
            String tagIds = article.getTagIds();
            tagIds = tagIds.substring(1, tagIds.length() - 1);  // 去掉中括号
            // tagIds = tagIds.trim(); // 这个方法只能去除首尾空格
            tagIds = tagIds.replace(" ", "");
            String[] tagIdsArr = tagIds.split(",");
            vo.setTagsIds(tagIdsArr);
            // 根据tagId查tagName
            String[] tagNames = new String[tagIdsArr.length];
            for (int i = 0; i < tagIdsArr.length; i++) {
                QueryWrapper<Tags> wrapper = new QueryWrapper<>();
                wrapper.eq("tag_id", tagIdsArr[i]);
                Tags tag = tagsMapper.selectOne(wrapper);
                if (tag != null) tagNames[i] = tag.getTagName();
            }
            // 设置tagNames
            vo.setTagNames(tagNames);
            list.add(vo);
        }
        return list;
    }

}
