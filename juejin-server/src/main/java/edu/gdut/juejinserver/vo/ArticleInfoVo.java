package edu.gdut.juejinserver.vo;

import lombok.Data;

import java.util.List;

/**
 * 文章数据
 */
@Data
public class ArticleInfoVo {

    private String articleId;

    private String userId;

    private String userName;

    private String[] tagsIds;

    private List<String> tagNames;

    private String ctime;

    private String mtime;

    private String rtime;

    private String title;

    private String coverImage;

    private String briefContent;

    private Integer viewCount;

    private Integer collectCount;

    private Integer diggCount;

    private Integer commentCount;

}
