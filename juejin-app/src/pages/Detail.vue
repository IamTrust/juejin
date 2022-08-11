<template>
  <div class="page">
      <div class="page__main">
        <!-- 文章区域 -->
        <div class="article-main">
            <!-- 文章内容 与 评论区域 -->
            <div class="article-area">
                <!-- 文章主体区域 -->
                <div class="article">
                    <!-- 标题 -->
                    <div class="article-title">{{articleDetail.title}}</div>

                    <!-- 作者信息区域 -->
                    <div class="article-info-box">
                        <a href="" class="user-photo">
                            <img :src="articleDetail.avatarLarge" alt="用户头像">
                        </a>
                        <div class="author-info">
                            <div class="author-name">
                                <span class="name">{{articleDetail.userName}}</span>
                                <span><img src="../assets/img/lv-2.png" alt=""></span>
                            </div>
                            <div class="meta-box">
                                <span class="time">2022年08月07日 22:23</span>
                                <span>阅读 {{articleDetail.viewCount}}</span>
                            </div>
                        </div>
                        <button class="follow-btn">+ 关注</button>
                    </div>

                    <!-- 文章图片展示（可能没有） -->
                    <div v-if="articleDetail.coverImage" class="article-img">
                        <img :src="articleDetail.coverImage" alt="">
                    </div>

                    <!-- 文章主体内容 -->
                    <div class="article-content">
                        <h2>前言</h2><p>最近一段时间在忙着开发公司的产品，第一阶段也结束了，今天想跟大家聊聊一个产品的正常的开发流程。正常的流程应该是：前期需求对接；中期研发过程；后期测试与版本。</p><p><br></p><h2>需求对接</h2><h3>需求来源</h3><ul><li>来自客户的直接需求，日常售后运维收集的；</li><li>参考资料，其他公司的竞品；</li><li>与项目部、售后部门等沟通，需求调研；</li><li>公司产品规划；</li><li>主要原则，不闭门造车，不想当然，参考已有成熟产品或业界规范，或者最新的政策文件；</li></ul><h3>输入输出</h3><ul><li>需求规格说明书，或者简单的说明文档；</li><li>功能脑图、原型图 Axure RP；</li><li>产品预期的目标；</li><li>产品与相关研发人员，进行需求说明评审会议；</li><li>会议前，相关文档提前发给相关人员（UI、开发和测试），供阅读思考；</li><li>会议时，产品经理按需求点逐一讲解，待讲解完一个大的功能点，大家提问讨论，统一对需求的理解；</li><li>一个简单的会议纪要，记录一下大家有矛盾的点；</li></ul><h3>解决方案编写</h3><ul><li>需求会议后，研发人员针对需求编写解决方案；</li><li>解决方案包括功能模块划分、表结构设计等，产出一个解决方案文档，包含对需求的理解，功能实现方式，包括一些业务流程图、架构图、部署图、SQL脚本等；</li><li>如果是完全的新项目，可能还需要考虑技术选型，例如使用哪种编程语言、开发框架、数据库等，是否需要集群部署，一般与团队原有知识体系保持一致；</li><li>解决方案，经研发负责人评审后，进行任务分解分配，到具体人员；</li><li>根据现有资源情况，进行大致工期规划，列一个时间表；</li><li>项目进度工期可以使用project等管理，明确任务时间点，人员等；</li><li>需求可以使用JIRA、禅道等工具进行管理，可以将资料作为附件放在记录里；</li><li>注意：一般根据项目情况，要按照1.5倍时间预估，因为总有突发情况，而且前期的估算不一定准确；</li></ul><h3>需求变更处理</h3><ul><li>对于新产品研发，或者客户项目开发，需求变更无法避免；</li><li>主要是新的东西，大家没法一开始就能明确其所有特性，后续可能有一些更好的想法，或者发现现有设计有重大缺陷；</li><li>需求变更，则需要对变更需求进行对接、评审（对现有框架、工期等的影响）、解决方案编写、工期计划的调整；</li><li>对于需求变更处理，要有原则，并不是所有的变更都要立即接受处理；</li><li>对于重大缺陷，或越往后期改动成本越大的，可优先处理；</li><li>对于一些不影响使用的优化或需求，可按列入写一个版本计划；</li><li>所有的需求变更，需要在JIRA或禅道里记录，新增一条记录；</li></ul><p><br></p><h2>研发过程</h2><h3>功能开发</h3><ul><li>重点任务，及时跟踪，根据需要加班完成；</li><li>进行阶段性短会，或者周会，每周要有项目进度说明；</li><li>前后端分离，要做好API接口维护，要尽量保证一个稳定环境和数据，供前端调试；</li><li>针对部分疑难问题，短时间无法处理掉的，及时汇报，大家一起解决；</li><li>宜早不宜迟，前中期多干点，留出冗余时间处理突发情况，尽量不要卡着时间点去完成任务；</li><li>及时维护JIRA或禅道里的任务状态，任务完成情况作为一项考核指标；</li><li>不能简单粗暴使用，因为有的关键任务可能要好几天完成，小任务可能半小时完成，所以数量和按时完成率也只是参考；</li></ul><h3>代码审查</h3><ul><li>编码规范，约定大于配置，阿里编程规范、数据库规约等；</li><li>合理的类和变量命名，合理的注释，合理的方法长度；</li><li>代码静态审查 sonar cube；</li><li>人工审查，代码走读；</li><li>审查完成后，整理出现的问题并宣讲，大家一起学习下，避免类似问题；</li></ul><h3>知识库</h3><ul><li>产品相关文档，包括需求文档、设计文档、用户手册等；</li><li>功能模块的文档，开发人员编写和使用，包括功能实现逻辑，在什么位置、有哪些类和表、有哪些接口等，可作为阶段性的工作文档，减少后续维护成本；</li><li>疑难问题的文档，记录遇到的问题，解决过程，解决结果等；</li><li>知识分享文档，产品中用到的关键技术，或者新技术，进行简单的介绍，包括特性、使用方式等；</li></ul><p><br></p><h2>测试与版本</h2><h3>测试要求</h3><ul><li>首先要按层功能自测，自己测试通过，再交由前端联调或测试人员测试；</li><li>保留必要的测试数据，接口测试要保留好输入输出；</li><li>对测试人员的测试要持续跟进，对于影响测试的问题优先处理，其他缺陷或优化，后续处理；</li><li>对于多变的阶段，来不及使用JIRA禅道等管理工具时，可以使用腾讯在线文档，使用表格管理；</li><li>对于稳定期，可以使用JIRA禅道等管理工具，对问题追踪；</li><li>测试介入越早越好，最好在需求阶段介入，方便更早的开始编写维护测试用例，测试完成后要有测试报告；</li><li>如果条件允许，一个大的功能模块完成后，可以让测试人员对这个功能先行测试；</li><li>至少两轮完整测试，一轮集成测试，一轮测试问题修改后的回归测试；</li></ul><h3>版本管理</h3><ul><li>代码主线分支管理；</li><li>产品代码管理；</li><li>项目代码管理；</li><li>发布版本管理（程序包、文档、SQL/shell脚本）；</li><li>部署文档（自动化部署脚本，数据库初始化脚本）；</li></ul><p><br></p><h2>后记</h2><h3>保持学习</h3><ul><li>学会利用互联网，开源免费的各种资料，源码；</li><li>推荐掘金、B站、腾讯课堂、开源中国等；</li><li>学习的广度和深度，根据需要针对性学习，学了要用起来，要有总结和记录；</li><li>有计划、有一定强度的持续学习，日积月累；</li></ul><h3>经验分享</h3><ul><li>工作中提升开发效率，每天要完成的任务列个列表，按优先级和紧急程度顺序完成，实在无法按时完成要及时主动的和上级领导沟通；</li><li>IT行业加班是常态，几乎所有公司都无法避免，要尽量按时吃饭。身体是自己的，照顾好自己，每周进行锻炼（例如跑步/打篮球等）；</li><li>学会理财，人生本就起起落落，没有谁是一帆风顺的，但只有存下来的钱，是你失意时最大的支撑；</li><li>管理自己的情绪，而管理情绪最好的方式是，<strong>不生闲气、不争对错、不理烂人</strong>。</li></ul>
                    </div>
                    
                    <!-- 文章标签区域 -->
                    <div class="tag-list-box">
                        <div class="list">分类：
                            <span>后端</span>
                        </div>
                        <div class="list">标签：
                            <span>后端</span>
                            <span>后端</span>
                            <span>后端</span>
                        </div>
                    </div>
                </div>

                <!-- 评论区 -->
                <div class="comment">
                    <!-- 发送评论 -->
                    <div class="comment-form">
                        <div class="form-header">评论</div>
                        <div class="form-content">
                            <div class="form-userimg">
                                <img src="../assets/img/user.png" alt="">
                            </div>
                            <div class="form-box">
                                <textarea name="" id="" cols="92" rows="3" style="resize:none" placeholder="输入评论 (Enter换行，Ctrl + Enter发送)"></textarea>
                                <div class="action-box">
                                    <div class="emoji-btn">😀表情</div>
                                    <div class="image-btn">🖼图片</div>
                                    <div class="submit-box">
                                        <span>Ctrl + Enter</span>
                                        <button class="submit">发表评论</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- 热门评论 -->
                    <div class="hot-list">
                        <div class="title">
                            <span>热门评论</span>
                            <img src="../assets/img/fire.png" alt="">
                        </div>
                        <div class="list">
                            <!-- 一条评论 -->
                            <div class="comment-item">
                                <div class="comment-userImg">
                                    <a href="" class="userImg">
                                        <img src="../assets/img/user.png" alt="">
                                    </a>
                                </div>
                                <div class="comment-content">
                                    <div class="comment-main">
                                        <div class="user-box">
                                            <span class="name">青山绿水长流</span>
                                            <span class="level"><img src="../assets/img/lv-2.png" alt=""></span>
                                            <span class="jueyou-level"><img src="../assets/img/jy.png" alt=""></span>
                                            <span class="position">移动端开发</span>
                                            <span class="time">1个月</span>
                                        </div>
                                        <div class="content-main">hi，想问你一个问题，flutter如何做长截屏？</div>
                                        <div class="comment-action-box">
                                            <div class="item-zan">
                                                <img src="../assets/img/zan__off.png" alt="">点赞
                                            </div>
                                            <div class="item-comNum">
                                                <img src="../assets/img/ping.png" alt="">回复
                                            </div>
                                        </div>
                                    </div>
                                    <div class="subcomment-wrapper"></div>
                                </div>
                            </div>

                            <div class="comment-item">
                                <div class="comment-userImg">
                                    <a href="" class="userImg">
                                        <img src="../assets/img/user.png" alt="">
                                    </a>
                                </div>
                                <div class="comment-content">
                                    <div class="comment-main">
                                        <div class="user-box">
                                            <span class="name">青山绿水长流</span>
                                            <span class="level"><img src="../assets/img/lv-2.png" alt=""></span>
                                            <span class="jueyou-level"><img src="../assets/img/jy.png" alt=""></span>
                                            <span class="position">移动端开发</span>
                                            <span class="time">1个月</span>
                                        </div>
                                        <div class="content-main">hi，想问你一个问题，flutter如何做长截屏？</div>
                                        <div class="comment-action-box">
                                            <div class="item-zan">
                                                <img src="../assets/img/zan__off.png" alt="">点赞
                                            </div>
                                            <div class="item-comNum">
                                                <img src="../assets/img/ping.png" alt="">回复
                                            </div>
                                        </div>
                                    </div>
                                    <div class="subcomment-wrapper"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- 全部评论 -->
                    <div class="comment-list-wrapper">
                        <div class="title">
                            <span>全部评论</span>
                            <span>&nbsp;&nbsp;11</span>
                        </div>
                        <div class="list">
                            <div class="comment-item">
                                <div class="comment-userImg">
                                    <a href="" class="userImg">
                                        <img src="../assets/img/user.png" alt="">
                                    </a>
                                </div>
                                <div class="comment-content">
                                    <div class="comment-main">
                                        <div class="user-box">
                                            <span class="name">青山绿水长流</span>
                                            <span class="level"><img src="../assets/img/lv-2.png" alt=""></span>
                                            <span class="jueyou-level"><img src="../assets/img/jy.png" alt=""></span>
                                            <span class="position">移动端开发</span>
                                            <span class="time">1个月</span>
                                        </div>
                                        <div class="content-main">hi，想问你一个问题，flutter如何做长截屏？</div>
                                        <div class="comment-action-box">
                                            <div class="item-zan">
                                                <img src="../assets/img/zan__off.png" alt="">点赞
                                            </div>
                                            <div class="item-comNum">
                                                <img src="../assets/img/ping.png" alt="">回复
                                            </div>
                                        </div>
                                    </div>
                                    <div class="subcomment-wrapper"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 侧边栏 -->
            <div class="sidebar">
                <!-- 作者信息栏 -->
                <div class="author-block">
                    <div class="user-item">
                        <div class="userimg">
                            <img :src="articleDetail.avatarLarge" alt="用户头像">
                        </div>
                    
                        <div class="info-box">
                            <div class="userName">
                                <span>{{articleDetail.userName}}</span>
                                <img src="../assets/img/lv-2.png" alt="">
                            </div>
                            <div class="position">{{articleDetail.jobTitle}}</div>
                        </div>
                    </div>
                    <div class="stat-item">
                        <div><img src="../assets/img/userZan.png" alt=""></div>
                        <span>获得点赞 {{articleDetail.diggCount}}</span>
                    </div>
                    <div class="stat-item">
                        <div><img src="../assets/img/userEye.png" alt=""></div>
                        <span>文章被阅读 {{articleDetail.viewCount}}</span>
                    </div>
                </div>

                <!-- 文章目录 -->
                <div class="sticky-block-box">
                    <div class="sticky-title">目录</div>

                    <!-- 目录主体 -->
                    <div class="sticky-content">
                        <ul class="sticky-list first">
                            <li class="item">
                                <a href="">
                                    <div class="a-container">1</div>
                                </a>
                                <ul class="sticky-list">
                                    <li class="item">
                                        <a href="">
                                            <div class="a-container">1.1</div>
                                        </a>

                                    </li>
                                    <li class="item">
                                        <a href="">
                                            <div class="a-container">1.2</div>
                                        </a>
                                        <ul class="sticky-list">
                                            <li class="item">
                                                <a href="">
                                                    <div class="a-container">1.2.1</div>
                                                </a>
                                            </li>
                                            <li class="item">
                                                <a href="">
                                                    <div class="a-container">1.2.2</div>
                                                </a>
                                            </li>
                                
                                        </ul>
                                    </li>
                                    <li class="item">
                                        <a href="">
                                            <div class="a-container">1.3</div>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="item">
                                <a href="">
                                    <div class="a-container">2</div>
                                </a>
                                <ul class="sticky-list">
                                    <li class="item">
                                        <a href="">
                                            <div class="a-container">2.1</div>
                                        </a>
                                    </li>
                                    <li class="item">
                                        <a href="">
                                            <div class="a-container">2.2</div>
                                        </a>
                                    </li>
                                    <li class="item">
                                        <a href="">
                                            <div class="a-container">2.3</div>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="item">
                                <a href="">
                                    <div class="a-container">3</div>
                                </a>
                            </li>
                            <li class="item">
                                <a href="">
                                    <div class="a-container">4</div>
                                </a>
                            </li>
                            <li class="item">
                                <a href="">
                                    <div class="a-container">5</div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- 左侧功能面板 -->
        <div class="article-suspended-panel">
            <div class="panel-btn">
                <img src="../assets/img/panelZan.png" alt="">
            </div>
            <div class="panel-btn">
                <img src="../assets/img/panelLiu.png" alt="">
            </div>
            <div class="panel-btn">
                <img src="../assets/img/panelStar.png" alt="">
            </div>
            <div class="panel-btn">
                <img src="../assets/img/panelFa.png" alt="">
            </div>
            <div class="panel-btn">
                <img src="../assets/img/paneljing.png" alt="">
            </div>
            <div class="panel-btn">
                <img src="../assets/img/panelQuan.png" alt="">
            </div>
        </div>
      </div>
  </div>
</template>

<script>
    import articleApi from '../api/article'

    export default {
        data() {
            return {
                articleDetail: {}
            }
        },

        created() {
            this.articleDetail.articleId = this.$route.params.articleId
            articleApi.getArticleDetailById(this.articleDetail.articleId).then(resp => {
                this.articleDetail = resp.data.data.articleDetail
            })
        }
    }
</script>

<style scoped>
:root {
    --juejin-brand-1-normal: #1e80ff;
    --juejin-brand-2-hover: #1171ee;
    --juejin-brand-3-click: #0060dd;
    --juejin-brand-4-disable: #abcdff;
    --juejin-brand-5-light: #eaf2ff;
    --juejin-font-1: #252933;
    --juejin-font-2: #515767;
    --juejin-font-3: #8a919f;
    --juejin-font-4: #c2c8d1;
}

* {
    margin: 0;
    padding: 0;
}

html,
body {
    background-color: #f4f5f5;
}

.page{
    width: 98.93vw;
}

.page__header{
    width: 100%;
    height: 60px;
    background: rgba(144, 243, 78, 0.171);
}

.page__main{
    max-width: 1140px;
    width: 100%;
    /* height: 800px; */
    margin: 0 auto;
    position: relative;
    margin-top: 81px;
}
.article-main{
    width: 100%;
    height: 600px;
    /* background: rgba(61, 155, 231, 0.219); */
    margin: 0 auto;
    display: flex;

}

.article-area{
    /* flex: 1; */
    width: 820px;
    margin-right: 21px;
}
.article{
    /* width: 100%; */
    /* height: 400px; */
    padding: 32px;
    box-sizing: border-box;
    background: #fff;
    border-radius: 4px;
}
.article>div{
    margin-bottom: 20px;
}
.article .article-title{
    font-size: 1.9rem;
    font-weight: 600;
    color: #252933;
    word-wrap: break-word;
}
.article .article-info-box{
    width: 100%;
    height: 48px;
    /* background: rgba(0, 0, 0, 0.13); */
    display: flex;
    align-items: center;
}
.user-photo{
    width: 40px;
    height: 40px;
    border-radius: 50%;
    margin-right: 8px;
    overflow: hidden;
    display: flex;
    justify-content: center;
    align-items: center;
}
.user-photo img{
    height: 100%;
}
.author-info{
    flex: 1px;
}
.author-info .author-name{
    font-size: 1rem;
    font-weight: 500;
    color: #515767;
    line-height: 2rem;
    display: flex;
}
.author-name span{
    width: 20%;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
    display: block;
    margin-right: 5px;
}
.author-name img{
    width: 35px;
    height: 16px;
}
.author-info .meta-box{
    font-size: .9rem;
    color: #8a919f;
    line-height: 20px;
    display: flex;
}
.meta-box span{
    margin-right: 15px;
    position: relative;
}
.meta-box span:not(:last-child)::after{
    content: '·';
    position: absolute;
    right: -8px;
}
.follow-btn{
    width: 70px;
    height: 34px;
    font-size: 14px;
    color: #1e80ff;
    background: rgba(30, 128, 255, .05);
    border: 1px solid rgba(30, 128, 255, .3);
    border-radius: 4px;
}
.article-img{
    width: 100%;
    height: 425px;
    overflow: hidden;
    display: flex;
    align-items: center;
}
.article-img img{
    width: 100%;
}


.tag-list-box{
    width: 100%;
    height: 32px;
    display: flex;
    /* background: rgba(0, 0, 0, 0.089); */
    font-size: .9rem;
    line-height: 32px;
    color: #515767d8;
}
.tag-list-box .list{
    margin-right: 20px;
    display: flex;
}
.tag-list-box .list>span{
    display: block;
    color: #1e80ff;
    background: #eaf2ff;
    padding: 0 12px;
    border-radius: 4px;
    margin-right: 5px;
}

.comment{
    width: 100%;
    /* height: 176px; */
    background: #fff;
    margin-top: 21px;
    border-radius: 4px;
    padding: 0px 32px;
    box-sizing: border-box;
}
.comment>div{
    padding-top: 24px;
}
.comment-form .form-header{
    font-size: 18px;
    line-height: 30px;
    font-weight: 600;
    color: #252933;
    margin-bottom: 24px;
}
.comment-form .form-content{
    display: flex;
    /* height: 74px; */
}
.form-userimg{
    width: 40px;
    height: 40px;
    border-radius: 50%;
    overflow: hidden;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-right: 16px;
}
.form-userimg>img{
    height: 100%;
}
.form-box>textarea{
    border: none;
    background: #f2f3f5;
    border-radius: 4px;
    padding: 8px 12px;
    box-sizing: border-box;
    color: #252933;
    line-height: 22px;
    font-size: 14px;
}
.form-box>textarea:focus-within{
    outline: 1px solid var(--juejin-brand-1-normal); 
}
.form-box:focus-within .action-box{
    display: flex;
}
.action-box{
    height: 36px;
   
    align-items: center;
    margin-top: 8px;
    font-size: 13px;
    color: #515767; 
    /* display: flex; */
    display: none;
}

.image-btn{
    margin-left: 24px;
}
.submit-box{
    flex: 1;
    display: flex;
    justify-content: flex-end;
    font-size: 14px;
    color: #86909c;
    line-height: 36px;
}
.submit-box .submit{
    width: 92px;
    height: 36px;
    border: none;
    font-size: 14px;
    color: #fff;
    background: #1e80ff;
    border-radius: 4px;
    margin-left: 16px;
}
.hot-list{
    /* height: 600px; */
}
.title{
    font-size: 18px;
    line-height: 30px;
    font-weight: 600;
    color: #252933;
    margin-bottom: 24px;
    display: flex;
    align-items: center;
}
.title>img{
    width: 20px;
    height: 20px;
}


/* 一条评论的样式   开始 */
.comment-item{
    width: 100%;
    display: flex;
    padding: 16px 0px;
}
.comment-userImg .userImg{
    width: 40px;
    height: 40px;
    border-radius: 50%;
    overflow: hidden;
    display: flex;
    justify-content: center;
    align-items: center;
}
.comment-userImg .userImg>img{
    height: 100%;
}
.comment-content{
    flex: 1;
    margin-left: 16px;
}
.comment-main>div{
    margin-bottom: 8px;
}
.user-box span:not(:last-child){
    margin-right: 7px;
}
.user-box{
    width: 100%;
    height: 26px;
    display: flex;
    align-items: center;
}
.user-box .name{
    max-width: 128px;
    font-size: 15px;
    color: #252933;
    line-height: 26px;

    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
}
.user-box .level{
    width: 45px;
    height: 16px;
}
.user-box .jueyou-level{
    width: 45px;
    height: 16px;
}
.user-box img{
    width: 45px;
    height: 16px;
}
.user-box .position{
    max-width: 150px;
    font-size: 14px;
    color: #8a919f;

    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;

    margin-left: 10px;
}
.user-box .time{
    flex: 1;
    font-size: 14px;
    color: #8a919f;
    text-align: right;
}
.content-main{
    font-size: 14px;
    line-height: 24px;
    color: #515767;
}
.comment-action-box{
    display: flex;
    font-size: 14px;
    color: #8a919f;
}
.comment-action-box div{
    display: flex;
    align-items: center;
    margin-right: 15px;
}
.comment-action-box img{
    width: 16px;
    height: 16px;
    margin-right: 5px;
}
/* 一条评论的样式   结束 */




/* 侧边栏  开始 */
.sidebar{
    position: absolute;
    top: 0;
    right: 0;
    width: 300px;
    height: 600px;
    flex: 1;
    /* background: rgba(146, 231, 77, 0.63); */
    /* background: #fff; */
    
}
.sidebar>div{
    width: 100%;
    /* padding: 20px; */
    margin-bottom: 20px;
    box-sizing: border-box;
    border-radius: 4px;
    background: #fff;
}

/* 作者信息栏 */
.author-block{
    /* background: #fff; */
    padding: 20px;
}
.user-item{
    display: flex;
    padding-bottom: 17px;
    position: relative;
}
.userimg{
    width: 48px;
    height: 48px;
    border-radius: 50%;
    overflow: hidden;
    display: flex;
    justify-content: center;
    align-items: center;
}
.userimg>img{
    height: 48px;
    margin-left: 5px;
}
.info-box{
    margin-left: 16px;
}
.info-box>div{
    max-width: 196px;
    height: 24px;
    font-size: 16px;
    font-weight: 400;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
.info-box .userName{
    color: #252933;
    display: flex;
    align-items: center;
}
.userName>span{
    max-width: 155px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
.userName>img{
    width: 35px;
    height: 16px;
}
.info-box .position{
    color: #515767;
}

.stat-item{
    margin-top: 17px;
    display: flex;
    font-size: 15px;
    line-height: 25px;
    color: #252933;
}
.stat-item>div{
    width: 25px;
    height: 25px;
    border-radius: 50%;
    background: #e1efff;
    margin-right: 12px;
    display: flex;
    justify-content: center;
    align-items: center;
}
.stat-item img{
    width: 16px;
    height: 16px;
}
.user-item::after{
    content: '';
    position: absolute;
    bottom: 0;
    width: 100%;
    height: 1px;
    background: rgba(0, 0, 0, 0.178);
    transform: scaleY(.5);
}


/* 文章目录 */
ul{
    list-style: none;
}
a{
    text-decoration: none;
    color: #515767;
}
.sticky-block-box{
    /* height: 524px; */
}
.sticky-title{
    position: relative;
    margin: 0 20px;
    padding: 16px 0;
}
.sticky-title::after{
    content: '';
    position: absolute;
    bottom: 0px;
    left: 0px;
    width: 100%;
    height: 1px;
    background: rgba(0, 0, 0, 0.178);
    transform: scaleY(.5);
}

.sticky-content{
    width: 100%;
    max-height: 460px;
    overflow-y: scroll;
    padding: 20px 5px;
    box-sizing: border-box;
}

/* 目录滑动条样式 */
.sticky-content::-webkit-scrollbar{
    width: 6px;
}
.sticky-content::-webkit-scrollbar-thumb{
    border-radius: 10px;  
    background: #c2c8d19b;
    margin-left: 10px;
}

.sticky-list{
    width: 100%;
    padding-left: 20px;
    box-sizing: border-box;
    position: relative;

}
.a-container{
    height: 44px;
    border-radius: 4px;
    font-size: 14px;
    color: #515767;
    line-height: 44px;
    padding-left: 5px;
    box-sizing: border-box;

}
.a-container:hover{
    background: #f7f8fa;
}

.first::after{
    content: '';
    position: absolute;
    top: 13px;
    /* 距离下一个标签 top增加53px */
    left: 0;
    width: 5px;
    height: 18px;
    background: #1e80ff;
    border-radius: 3px;
}
/* 侧边栏  结束 */

/* 左侧功能栏 */
.article-suspended-panel{
    width: 48px;
    height: 300px;
    /* background: rgba(0, 0, 0, 0.157); */
    position: fixed;
    top: 140px;
    left: 100px;
}
.panel-btn{
    width: 100%;
    height: 48px;
    border-radius: 50%;
    background: #fff;
    margin-bottom: 20px;
    box-shadow: 1px 1px 20px #dadddd;

    display: flex;
    justify-content: center;
    align-items: center;

}
.panel-btn>img{
    width: 17px;
    height: 17px;
}
.panel-btn:nth-child(4){
    margin-bottom: 40px;
    position: relative;
}
.panel-btn:nth-child(4)::after{
    content: '';
    position: absolute;
    bottom: -20px;
    width: 30px;
    height: 1px;
    background: rgba(0, 0, 0, 0.157);
    transform: scaleY(.5);
}
</style>