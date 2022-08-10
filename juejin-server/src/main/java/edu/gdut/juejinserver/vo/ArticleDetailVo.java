package edu.gdut.juejinserver.vo;

import lombok.Data;

@Data
public class ArticleDetailVo {

    private String articleId;

    private String title;

    private String coverImage;

    private String ctime;

    private String mtime;

    private String rtime;

    private Integer viewCount;

    private Integer collectCount;

    private Integer diggCount;

    private Integer commentCount;

    private String userId;

    private String userName;

    private String company;

    private String jobTitle;

    private String avatarLarge;

}
