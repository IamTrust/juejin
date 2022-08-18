<template>
    <div class="page__main" ref="listWrap" >
        <Header :msg="true"/>
        <!-- 文章列表 -->
        <div class="page__main__contents">
            <!-- 文章列表主体 -->
            <div class="contents__list" ref="scrollBar">
                <div class="list__header" >
                    <div class="nav__list">
                        <ul>
                            <li><a href="" style="color: #1e80ff;">推荐</a></li>
                            <li><a href="">最新</a></li>
                            <li><a href="">热榜</a></li>
                        </ul>
                    </div>
                </div>

                <!-- 数据加载时呈现的骨架 -->
                <el-skeleton :rows="4" animated style="width:700px" class="listSkeleton" v-if="loading" />
                
                <div class="list__content">
                    <ul class="article__list" ref="list">
                        <li v-for="article in showList" :key="article.articleId" class="list__item">
                            <router-link target="_blank" :to="`/detail/${article.articleId}`"  class="title">
                                <div class="entry" @click="article.color = !article.color">
                                    <div class="article__inform">
                                        <div class="nav__list">
                                            <ul>
                                                <li><a href="">{{article.userName}}</a></li>
                                                <li><a href="" >{{article.mtime}}</a></li>
                                                <li class="tag__a">
                                                    <div class="tag__name" v-for="(tag, index) in article.tagNames" :key="index">
                                                        <a href="">{{tag}}</a>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="article__content">
                                        <div class="content-main">
                                            <div class="title" :class="{titleColor: article.color}">                                                {{article.title}}
                                            </div>
                                            <div class="abstract">
                                                <div>{{article.briefContent}}</div>
                                            </div>
                                            <ul class="action-list">
                                                <li class="item">
                                                    <i class="eye"></i>
                                                    <span>{{article.viewCount}}</span>
                                                </li>
                                                <li class="item">
                                                    <i class="zan"></i>
                                                    <span>{{article.diggCount}}</span>
                                                </li>
                                                <li class="item">
                                                    <i class="cloud"></i>
                                                    <span>{{article.commentCount}}</span>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="content-img" v-if="article.coverImage">
                                            <img :src="article.coverImage" alt="" class="lazy">
                                        </div>
                                    </div>
                                </div>
                            </router-link>
                        </li>
                    </ul>
                </div>
            </div>

            <!-- 右侧信息栏 -->
            <div class="sidebar">
                <!-- 签到信息 -->
                <div class="signin__top">
                    <div class="first__line">
                        <div class="icon__text">
                            <img src="../assets/img/day.png" alt="">
                            {{showTimeStage}}
                        </div>
                        <button class="signedin__btn">
                            已签到
                        </button>
                    </div>
                    <div class="second__line">           
                        你已经连续签到<span style="color:#1e80ff; font-size: 16px;">100</span>天
                    </div>
                </div>
                <!-- 广告 -->
                <div class="sidebar__block">
                    <img src="https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/0b6a58397c77485495a051142f1d863d~tplv-k3u1fbpfcp-no-mark:480:400:0:0.awebp?" alt="">
                </div>
                <!-- 广告 -->
                <div class="sidebar__block">
                    <img src="https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/a88a1ea956734105a5b002dfb48840cb~tplv-k3u1fbpfcp-no-mark:480:400:0:0.awebp?" alt="">
                </div>
                <!-- 掘金官网链接 -->
                <div class="block-body">
                    <img src="https://lf3-cdn-tos.bytescm.com/obj/static/xitu_juejin_web/img/home.59780ae.png" alt="">
                    <div class="block-body-text">
                        <div>下载稀土掘金APP</div>
                        <div>一个帮助开发者成长的社区</div>
                    </div>
                </div>
                <!-- 作者榜 -->
                <div class="user-body user-top">
                    <div class="header-block">🎖️作者榜</div>
                    <div class="user-list">
                        <div class="item">
                            <div class="item__img-box">
                                <img src="https://p3-passport.byteacctimg.com/img/mosaic-legacy/3792/5112637127~300x300.image" alt="">
                            </div>
                            <div class="item__user-info">
                                小明同学
                                <img src="../assets/img/lv-2.png" alt="">
                            </div>
                        </div>
                        <div class="item">
                            <div class="item__img-box">
                                <img src="https://p9-passport.byteacctimg.com/img/mosaic-legacy/3793/3131589739~300x300.image" alt="">
                            </div>
                            <div class="item__user-info">
                                工匠若水
                                <img src="../assets/img/lv-2.png" alt="">
                            </div>
                        </div>
                        <div class="item">
                            <div class="item__img-box">
                                <img src="https://p9-passport.byteacctimg.com/img/mosaic-legacy/3796/2975850990~300x300.image" alt="">
                            </div>
                            <div class="item__user-info">
                                固体物质搬运工
                                <img src="../assets/img/lv-2.png" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="author-list">
                        完整榜单&nbsp;&nbsp;>
                    </div>
                </div>

                <!-- 悬浮信息栏 -->
                <transition name="el-fade-in-linear" >
                <div class="suspended" v-show="show" ref="suspendBox">
                    <div class="signin__top ">
                        <div class="first__line">
                            <div class="icon__text">
                                <img src="../assets/img/day.png" alt="">
                                {{showTimeStage}}
                            </div>
                            <button class="signedin__btn">
                                已签到
                            </button>
                        </div>
                        <div class="second__line">           
                            你已经连续签到<span style="color:#1e80ff; font-size: 16px;">100</span>天
                        </div>
                    </div>
                    <div class="sidebar__block user-top ">
                        <div class="header-block">🎖️作者榜</div>
                        <div class="user-list">
                            <div class="item">
                                <div class="item__img-box">
                                    <img src="https://p3-passport.byteacctimg.com/img/mosaic-legacy/3792/5112637127~300x300.image" alt="">
                                </div>
                                <div class="item__user-info">
                                    小明同学
                                    <img src="../assets/img/lv-2.png" alt="">
                                </div>
                            </div>
                            <div class="item">
                                <div class="item__img-box">
                                    <img src="https://p9-passport.byteacctimg.com/img/mosaic-legacy/3793/3131589739~300x300.image" alt="">
                                </div>
                                <div class="item__user-info">
                                    工匠若水
                                    <img src="../assets/img/lv-2.png" alt="">
                                </div>
                            </div>
                            <div class="item">
                                <div class="item__img-box">
                                    <img src="https://p9-passport.byteacctimg.com/img/mosaic-legacy/3796/2975850990~300x300.image" alt="">
                                </div>
                                <div class="item__user-info">
                                    固体物质搬运工
                                    <img src="../assets/img/lv-2.png" alt="">
                                </div>
                            </div>
                        </div>
                        <div class="author-list">
                            完整榜单&nbsp;&nbsp;>
                        </div>
                    </div>
                </div>
                </transition>

            </div>
        </div>
    </div>
</template>

<script>
    import "../assets/css/header.css"
    import "../assets/css/main.css"
    import Header from '../components/Header'
    import article from "../api/article"
    import eventBus from "../assets/js/EventBus"
    import timeDispose from "../utils/timeDispose"

    export default {
        data() {
            return {
                loading: true,
                articleInfoList: [],
                current: 1,  // 当前页
                limit: 20,   // 每页记录数

                itemHeight: 136,//每一列的高度
                showNum: 10,//显示几条数据
                start: 0,//滚动过程显示的开始索引
                end: 10,//滚动过程显示的结束索引
                
                color: true,
                show: false,
                headerNavSign: true
            }
        },
        components: {
            Header
        },
        updated(){
            //计算全部数据需要的高度，撑开滚动条高度
            this.$refs.scrollBar.style.height = this.itemHeight * this.articleInfoList.length + 'px';
        },
        computed: {
            //显示的数组，用计算属性计算
            showList(){  return this.articleInfoList.slice(this.start, this.end);  },
            // 显示上午好 下午好 晚上好
            showTimeStage(){ return timeDispose.newTime() }

        },
        methods: {
            // 计算文章列表呈现在页面上开头和结尾的位置
            scrollListener(scrollTop){
                //计算总的数据需要的高度，构造滚动条高度
                this.$refs.scrollBar.style.height = this.itemHeight * this.articleInfoList.length + 'px';
                //开始的数组索引
                let first = Math.floor(scrollTop / this.itemHeight) - 1;
                this.start = first<0 ? 0 : first
                // if(first<0){
                //     this.start = 0;
                // }else{
                //     this.start = first
                // }
                //结束索引
                this.end = this.start + this.showNum;
                //定位列表的顶部的偏移量
                this.$refs.list.style.marginTop = this.start * this.itemHeight + 'px';
            },

            // 获取数据
            getArticleInfoList(current, limit){
                if (current) this.current = current
                if (limit) this.limit = limit
                article.getArticleInfo(this.current, this.limit).then(resp => {
                    let arr = resp.data.data.article_info;
                    arr.forEach((e,i)=>{
                        // arr[i].mtime = this.getLocalTime(e.mtime);
                        arr[i].mtime = timeDispose.timeInterval(e.mtime);
                        arr[i].viewCount = this.setAction(e.viewCount,1);
                        arr[i].diggCount = this.setAction(e.diggCount,2);
                        arr[i].commentCount = this.setAction(e.commentCount,3);
                        arr[i].color = true;
                    })
                    // 防抖处理，防止数据加载过快，骨架一闪而过影响效果
                    const promise = new Promise((resolve, reject)=>{
                        let self = this;
                        setTimeout(() => {
                            self.loading = false;
                            resolve();
                        }, 500);
                    })
                    promise.then(resp=>{
                        this.articleInfoList.push(...arr)
                    })
                })
            },

            // 滚动到底部后加载数据
            lasyLoading() {
                let scrollTop = document.documentElement.scrollTop || document.body.scrollTop
                let clientHeight = document.documentElement.clientHeight
                let scrollHeight = document.documentElement.scrollHeight
                if (scrollTop + clientHeight >= scrollHeight) {
                    this.current++;
                    this.getArticleInfoList()
                }
                this.scrollListener(scrollTop);
                this.show = scrollTop > 1000 ? true : false;

                // 通过事件总线监听消息
                eventBus.$on('pushMsg', (children1Msg) => {
                    this.headerNavSign = children1Msg
                })
                if(this.headerNavSign){
                    this.$refs.suspendBox.style.marginTop = '0px';
                }else{
                    this.$refs.suspendBox.style.marginTop = '-60px'
                }

            },

            // 将浏览、点赞、评论数缩写
            setAction(num,type){
                if(num == 0 && type == 1){
                    return '浏览';
                }
                if(num == 0 && type == 2){
                    return '点赞';
                }
                if(num == 0 && type == 3){
                    return '评论';
                }
                if(num < 10000){
                    return num;
                }else if(num >= 10000){
                    return `${Math.trunc(num/10000)}.${Math.trunc((num%10000)/1000)}w`
                }
            }
        },
        watch:{
            
        },
        mounted () {
            
        },
        // 监听滚动到底部事件
        created() {
            window.addEventListener("scroll", this.lasyLoading);
            this.getArticleInfoList();
        },
        // 销毁监听事件
        destroyed() {
            window.removeEventListener("scroll", this.lasyLoading)    
        }
    }
</script>

<style scoped>
    .listSkeleton{
        padding: 30px 20px;
        box-sizing: border-box;
        background: #fff;
    }
    .router-link-exact-active{
        color: #86909c;
    }

    .suspended{
        width: 240px;
        position: fixed;
        top: 130px;
        transition: all .3s linear;
    }
    .suspended>div{
        margin-bottom: 20px;
    }
</style>