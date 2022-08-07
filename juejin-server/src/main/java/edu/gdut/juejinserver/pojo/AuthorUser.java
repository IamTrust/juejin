package edu.gdut.juejinserver.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AuthorUser对象", description="")
public class AuthorUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.ID_WORKER_STR)
    private String userId;

    private String userName;

    private String company;

    private String jobTitle;

    private String avatarLarge;

    private Integer level;

    private String description;

    private Integer followeeCount;

    private Integer followerCount;

    private Integer postArticleCount;

    private Integer diggArticleCount;

    private Integer gotDiggCount;

    private Integer gotViewCount;

    private Integer postShortmsgCount;

    private Integer diggShortmsgCount;

    private String isfollowed;

    private Integer favorableAuthor;

    private Integer power;

    private Integer studyPoint;

    private String university;

    private String major;

    private Integer studentStatus;

    private Integer selectEventCount;

    private Integer selectOnlineCourseCount;

    private Integer identity;

    private String isSelectAnnual;

    private Integer selectAnnualRank;

    private Integer annualListType;

    @TableField("extraMap")
    private String extraMap;

    private Integer isLogout;

    private String annualInfo;

    private Integer accountAmount;

    private String userGrowthInfo;

    private String isVip;


}
