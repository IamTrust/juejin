<template>
    <div class="page__header" id="header">
        <!-- 导航内容 -->
        <div class="page__header__nav" v-if="headerNavSign">
            <div class="nav__sign">
                <a href="/" class="logo">
                    <img class="logo__img" src="../assets/img/juejin-logo.png" alt="">
                </a>
            </div>
            <div class="nav__main">
                <ul class="nav__main-list">
                    <li class="list-left">
                        <div class="list-left-list">
                            <ul class="list__contents">
                                <li><a href="#" style="color: #1e80ff;">首页</a></li>
                                <li><a href="#">沸点</a></li>
                                <li><a href="#">课程</a></li>
                                <li><a href="#">直播</a></li>
                                <li><a href="#">资讯</a></li>
                                <li><a href="#">活动</a></li>
                                <li class="com">
                                    <a href="#" class="community">开放社区</a>
                                    <ul class="community__list">
                                        <li class="item">
                                            <span>青训营社区</span>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="#">商城</a></li>
                                <li><a href="#">APP</a></li>
                                <li><a href="#">插件</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="list-right">
                        <div class="list-right-list">
                            <ul class="list__contents">
                                <li>
                                    <div class="input__frame" tabindex="0">
                                        <input class="input" type="text" placeholder="搜索稀土掘金">
                                        <div class="input__sign">
                                            <div class="input__img"></div>
                                        </div>
                                        <div class="input__typehead">
                                            <div class="title">
                                                <span>搜索历史</span>
                                                <span class="clear" style="color:#1e80ff">清空</span>
                                            </div>
                                            <div class="list">
                                                <ul>
                                                    <li class="list-item">HTML基础</li>
                                                    <li class="list-item">CSS样式</li>
                                                    <li class="list-item">JavaScript入门</li>
                                                    <li class="list-item">node</li>
                                                    <li class="list-item">vue 3</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="creator">
                                        <button class="crea-btn">创作者中心</button>
                                        <input type="checkbox" id="dianj">
                                        <!-- 利用input单选框的单点‘开关’的特性 -->
                                        <label for="dianj">
                                            <div class="more">
                                                <div class="more__tri"></div>
                                            </div>
                                        </label>
                                        <ul class="more__list">
                                            <li class="item">
                                                <span>写文章</span>
                                            </li>
                                            <li class="item">
                                                <span>发沸点</span>
                                            </li>
                                        </ul>
                                    </div>

                                </li>
                                <li>
                                    <div class="vip__title">
                                        <img class="vip__img" src="../assets/img/juejinVip.png" alt="">
                                        <div class="vip__words">会员</div>
                                    </div>
                                </li>
                                <li>
                                    <div class="inform">
                                        <div class="inform__img"></div>
                                        <!-- <img class="inform__img" src="../assets/img/inform-logo.png" alt=""> -->
                                    </div>
                                </li>
                                <li>
                                    <div class="user">
                                        <img src="../assets/img//user.png" alt="" class="user__img">
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>

        <!-- 导航标签 -->
        <div class="page__header__tag">
            <div class="tag__contents">
                <div class="tag__list">
                    <ul class="list__contents">
                        <li><a href="#" style="color: #1e80ff;">综合</a></li>
                        <li><a href="#">关注</a></li>
                        <li><a href="#">后端</a></li>
                        <li><a href="#">前端</a></li>
                        <li><a href="#">Android</a></li>
                        <li><a href="#">iOS</a></li>
                        <li><a href="#">人工智能</a></li>
                        <li><a href="#">开发工具</a></li>
                        <li><a href="#">代码人生</a></li>
                        <li><a href="#">阅读</a></li>
                    </ul>
                </div>
                <div class="tag__manage">
                    <span><a href="#">标签管理</a></span>
                </div>
            </div>

        </div>

        <!-- 一键回到顶部 -->
        <div class="page__header__side" v-if="headerSide">
            <a href="javascript:scroll(0,0)"><div class="backTop">
                <img src="../assets/img/top.png" alt="">
            </div></a>
        </div>
    </div>    
</template>

<script>
    import "../assets/css/page__header.css"

    export default {
        data() {
            return {
                headerNavSign: true,
                headerSide: false,
                oldScrollTop: 0,
            }
        },
        methods: {
            setHeaderNavSign(){
                // 滚动条距文档顶部的距离
                let scrollTop = window.pageYOffset || document.documentElement.scrollTop ||
                    document.body.scrollTop
                // 滚动条滚动的距离
                let scrollStep = scrollTop - this.oldScrollTop;
                // 更新——滚动前，滚动条距文档顶部的距离
                if(scrollTop > 420){
                    this.oldScrollTop = scrollTop;
                    if (scrollStep < 0) {
                        this.headerNavSign = true;
                    } else {
                        this.headerNavSign = false;
                    }
                }
                // 回到顶部是显示头部导航栏
                if(scrollTop == 0){
                    this.headerNavSign = true;
                }
                // 一键回到页面顶部
                if(scrollTop > 800){
                    this.headerSide = true;
                }else{
                    this.headerSide = false;
                }
            }
        },
        created() {
            window.addEventListener("scroll", this.setHeaderNavSign)   // 监听滚动到底部事件
        },
        destroyed() {
            window.removeEventListener("scroll", this.setHeaderNavSign)    // 销毁监听事件
        }
    }
</script>

<style scoped>

</style>