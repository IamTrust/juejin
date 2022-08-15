<template>
  <div class="page">
      <div class="page__header">
          <Header />
      </div>

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
                    <div class="article-content" ref="articleBox">
                        
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
                <div class="author-block" ref="authorBox">
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
                <div class="sticky-block-box activeBox" :class="stickyStatus" ref="stickyBox" style="margin-top: 60px;">
                    <div class="sticky-title">目录</div>

                    <!-- 目录主体 -->
                    <div class="sticky-content" ref="stickyContentBox">
                        <!-- <div class="first" ref="listFirstBox"></div> -->
                        <ul class="sticky-list">
                            <li class="item" :class="[currentTitle == title.currentTitleId ? 'first' : '']" v-for="title in titles" :key="title.id">
                                <div class="a-container" :style="{ marginLeft: title.level * 20 + 'px' }" :title="title.rawName" @click="scrollToView(title.scrollTop - 40)">{{ title.name }}</div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- 左侧功能面板 -->
        <div class="article-suspended-panel">
            <div class="panel-btn" @click="setZanNum">               
                <img src="../assets/img/panelZan__on.png" alt="" v-if="zanObj.status">
                <img src="../assets/img/panelZan__off.png" alt="" v-else>
                <div class="btn-num" ref="zanNumBOX">{{zanObj.number}}</div>
            </div>
            <div class="panel-btn">
                <img src="../assets/img/panelLiu.png" alt="">
                <div class="btn-num">50</div>
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
    import '../assets/css/article.css'
    import Header from '../components/Header'
    import articleApi from '../api/article'
    import eventBus from "../assets/js/EventBus"
    // import { reactive, ref } from "../assets/js/vue";
    

    export default {
        data() {
            return {
                articleDetail: {},
                stickyStatus: {
                    stickyBoxStatus: false
                },
                headerNavSign: true,

                zanObj: {    //点赞的状态
                    number: 100,
                    status: false
                },

                titles: [],  //目录列表
                titlesLen: null,
                currentTitle: 0,
            }
        },
        components: {
            Header
        },
        methods: {
            // 获取文章标题结构
            getTitles() {
                let titles = [];
                let levels = ["h1", "h2", "h3"];

                // let articleElement = document.querySelector(props.container);
                let articleElement = this.$refs.articleBox;
                if (!articleElement) {
                    return titles;
                }

                let elements = Array.from(articleElement.querySelectorAll("*"));

                // 调整标签等级
                let tagNames = new Set(
                    elements.map((el) => el.tagName.toLowerCase())
                );
                for (let i = levels.length - 1; i >= 0; i--) {
                    if (!tagNames.has(levels[i])) {
                        levels.splice(i, 1);
                    }
                }

                let serialNumbers = levels.map(() => 0);
                for (let i = 0; i < elements.length; i++) {
                    const element = elements[i];
                    let tagName = element.tagName.toLowerCase();
                    let level = levels.indexOf(tagName);
                    if (level == -1) continue;

                    let id = tagName + "-" + element.innerText + "-" + i;
                    let node = {
                        id,
                        level,
                        parent: null,
                        children: [],
                        rawName: element.innerText,
                        scrollTop: element.offsetTop + 500
                    };

                    if (titles.length > 0) {
                        let lastNode = titles.at(-1);

                        // 遇到子标题
                        if (lastNode.level < node.level) {
                            node.parent = lastNode;
                            lastNode.children.push(node);
                        }
                        // 遇到上一级标题
                        else if (lastNode.level > node.level) {
                            serialNumbers.fill(0, level + 1);
                            let parent = lastNode.parent;
                            while (parent) {
                                if (parent.level < node.level) {
                                    parent.children.push(node);
                                    node.parent = parent;
                                    break;
                                }
                                parent = parent.parent;
                            }
                        }
                        // 遇到平级
                        else if (lastNode.parent) {
                            node.parent = lastNode.parent;
                            lastNode.parent.children.push(node);
                        }
                    }

                    serialNumbers[level] += 1;
                    let serialNumber = serialNumbers.slice(0, level + 1).join(".");

                    node.isVisible = node.parent == null;
                    node.name = serialNumber + ". " + element.innerText;
                    titles.push(node);
                }
                for(let i=0; i<titles.length; i++){
                    titles[i].currentTitleId = i;
                }
                console.log(titles);
                this.titlesLen = titles.length;
                return titles;
            },
            // 设置点赞样式
            setZanNum(){
                if(!this.zanObj.status){
                    this.zanObj.number++;
                    this.zanObj.status = true;
                    this.$refs.zanNumBOX.style.background = '#1e80ff'
                }else{
                    this.zanObj.number--;
                    this.zanObj.status = false;
                    this.$refs.zanNumBOX.style.background = '#c2c8d1'
                }
            },
            // 设置目录的位置
            setStickyBoxTop(){
                // 通过事件总线监听消息
                eventBus.$on('pushMsg', (children1Msg) => {
                    this.headerNavSign = children1Msg
                })

                let rect = this.$refs.authorBox.getBoundingClientRect();
                // 判断头部导航栏是否出现
                if(this.headerNavSign){
                    this.$refs.stickyBox.style.marginTop = '60px';
                }else{
                    this.$refs.stickyBox.style.marginTop = '0px'
                }

                // 判断目录是否被固定
                if(rect.top < -165){
                    this.stickyStatus.stickyBoxStatus = true;
                    
                }else{
                    this.stickyStatus.stickyBoxStatus = false;
                }
            },

            // 设置目录的滚动事件
            setStickyBox(){
                if(!this.timer){
                    // this.screenWidth = val
                    this.timer = true
                    let that = this
                    let num = 0;
                    setTimeout(function(){
                        for (let item of that.titles) {
                            if (item.scrollTop <= window.scrollY) {
                                num++;
                            }
                        }
                        that.currentTitle = num >= that.titlesLen ? that.titlesLen-1 : num
                        that.$refs.stickyContentBox.scrollTo({ top: num * 44 - 20, behavior: "smooth" });
                        that.timer = false;
                    },500)
                }
            },

            // 滚动到指定的位置
            scrollToView(scrollTop) {
                window.scrollTo({ top: scrollTop, behavior: "smooth" });
            }
        },
        mounted(){
            // 将页面置顶
            window.scrollTo(0, 0);
            
            // 得到文章目录列表
            this.titles = this.getTitles();
        },
        created() {
            // this.currentTitle = reactive({});
            window.addEventListener("scroll", this.setStickyBoxTop)
            window.addEventListener("scroll", this.setStickyBox)

            // 发请求拿数据
            this.articleDetail.articleId = this.$route.params.articleId
            // 文章信息
            articleApi.getArticleDetailById(this.articleDetail.articleId).then(resp => {
                this.articleDetail = resp.data.data.articleDetail
            })
            // 文章标签信息
            articleApi.getArticleTagsById(this.articleDetail.articleId).then(resp => {
                this.articleDetail.tags = resp.data.data.tags
            })
            // 文章内容
            articleApi.getArticleContentById(this.articleDetail.articleId).then(resp => {
                this.articleDetail.markContent = resp.data.data.articleContent
            })
        },
    }
</script>

<style scoped>

</style>