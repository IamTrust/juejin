<template>
    <div class="page__main" ref="listWrap" >
        <div class="page__main__contents">
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

                <div class="list__content">
                    <ul class="article__list" ref="list">
                        <li v-for="article in showList" :key="article.articleId" class="list__item">
                            <div class="entry">
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
                                        <div class="title">
                                            <a href="#" class="title">{{article.title}}</a>
                                        </div>
                                        <div class="abstract">
                                            <a href="#">
                                                <div>{{article.briefContent}}</div>
                                            </a>
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
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import "../assets/css/page__header.css"
    import "../assets/css/page__main.css"
    import article from "../api/article"

    export default {
        data() {
            return {
                articleInfoList: [],
                current: 1, // 当前页
                limit: 20,   // 每页记录数

                itemHeight: 136,//每一列的高度
                showNum: 10,//显示几条数据
                start: 0,//滚动过程显示的开始索引
                end: 10,//滚动过程显示的结束索引
            }
        },
        updated(){
            //计算全部数据需要的高度，撑开滚动条高度
            this.$refs.scrollBar.style.height = this.itemHeight * this.articleInfoList.length + 'px';
        },
        computed: {
            //显示的数组，用计算属性计算
            showList(){  return this.articleInfoList.slice(this.start, this.end);  }
        },
        methods: {
            // 计算呈现在页面上列表开头和结尾的位置
            scrollListener(scrollTop){
                // //计算总的数据需要的高度，构造滚动条高度
                this.$refs.scrollBar.style.height = this.itemHeight * this.articleInfoList.length + 'px';
                //开始的数组索引
                let first = Math.floor(scrollTop / this.itemHeight) - 1;
                if(first<0){
                    this.start = 0;
                }else{
                    this.start = first
                }
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
                        arr[i].mtime = this.getLocalTime(e.mtime);
                        arr[i].viewCount = this.setAction(e.viewCount,1);
                        arr[i].diggCount = this.setAction(e.diggCount,2);
                        arr[i].commentCount = this.setAction(e.commentCount,3);
                    })
                   
                    this.articleInfoList.push(...arr);
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
            },
            // 时间戳转为距今多久
            getLocalTime(dateTime) {
                // 如果为null,则格式化当前时间
                if (!dateTime) dateTime = Number(new Date());
                // 如果dateTime长度为10或者13，则为秒和毫秒的时间戳，如果超过13位，则为其他的时间格式
                if (dateTime.toString().length == 10) dateTime *= 1000;
                let timestamp = +new Date(Number(dateTime));
        
                let timer = (Number(new Date()) - timestamp) / 1000;
                // 如果小于5分钟,则返回"刚刚",其他以此类推
                let tips = '';
                switch (true) {
                    case timer < 300:
                        tips = '刚刚';
                        break;
                    case timer >= 300 && timer < 3600:
                        tips = parseInt(timer / 60) + '分钟前';
                        break;
                    case timer >= 3600 && timer < 86400:
                        tips = parseInt(timer / 3600) + '小时前';
                        break;
                    case timer >= 86400 && timer < 2592000:
                        tips = parseInt(timer / 86400) + '天前';
                        break;
                    default:
                        if (timer >= 2592000 && timer < 365 * 86400) {
                            tips = parseInt(timer / (86400 * 30)) + '个月前';
                        } else {
                            tips = parseInt(timer / (86400 * 365)) + '年前';
                        }
                }
                return tips; 
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

<style>

</style>