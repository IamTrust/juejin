<template>
    <div class="page__main">
        <div class="page__main__contents">
            <div class="contents__list">
                <div class="list__header">
                    <div class="nav__list">
                        <ul>
                            <li><a href="" style="color: #1e80ff;">推荐</a></li>
                            <li><a href="">最新</a></li>
                            <li><a href="">热榜</a></li>
                        </ul>
                    </div>

                </div>
                <div class="list__content">
                    <ul class="article__list">

                        <li v-for="article in articleInfoList" :key="article.articleId" class="list__item">
                            <div class="entry">
                                <div class="article__inform">
                                    <div class="nav__list">
                                        <ul>
                                            <li><a href="">DS小龙哥</a></li>
                                            <li><a href="">7天前</a></li>
                                            <li><a href="">后端</a></li>
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
                                    <img :src="article.coverImage" alt="" class="lazy">
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
                limit: 20   // 每页记录数
            }
        },
        methods: {
            // 获取数据
            getArticleInfoList(current, limit) {
                if (current) this.current = current
                if (limit) this.limit = limit
                article.getArticleInfo(this.current, this.limit).then(resp => {
                    this.articleInfoList = resp.data.data.article_info
                })
            },
            // 滚动到底部后加载数据
            lasyLoading() {
                let scrollTop = document.documentElement.scrollTop || document.body.scrollTop
                let clientHeight = document.documentElement.clientHeight
                let scrollHeight = document.documentElement.scrollHeight
                if (scrollTop + clientHeight >= scrollHeight) {
                    // 滚动到了页面底部
                    // 再次请求数据
                    this.limit += 20;
                    this.getArticleInfoList()
                }
            }
        },
        created() {
            window.addEventListener("scroll", this.lasyLoading)   // 监听滚动到底部事件
            this.getArticleInfoList()
        },
        destroyed() {
            window.removeEventListener("scroll", this.lasyLoading)    // 销毁监听事件
        }
    }
</script>

<style>

</style>