package edu.gdut.juejinserver.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Trust会长
 * @since 2022-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ArticleInfo对象", description="")
public class ArticleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "article_id", type = IdType.ID_WORKER_STR)
    private String articleId;

    private String userId;

    private String categoryId;

    private String tagIds;

    private Integer visibleLevel;

    private String linkUrl;

    private String coverImage;

    private Integer isGfw;

    private String title;

    private String briefContent;

    private Integer isEnglish;

    private Integer isOriginal;

    private Double userIndex;

    private Integer originalType;

    private String originalAuthor;

    private String content;

    private String ctime;

    private String mtime;

    private String rtime;

    private String draftId;

    private Integer viewCount;

    private Integer collectCount;

    private Integer diggCount;

    private Integer commentCount;

    private Integer hotIndex;

    private Integer isHot;

    private Double rankIndex;

    private Integer status;

    private Integer verifyStatus;

    private Integer auditStatus;

    private String markContent;

    private Integer displayCount;


}
