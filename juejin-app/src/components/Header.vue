<template>
    <div class="page__header">
        
        <div class="page__header__box activeBox" ref="headerBox">
            <!-- 导航内容 -->
            <div class="page__header__nav">
                <div class="nav__sign">
                    <a href="/" class="logo">
                        <img class="logo__img" src="../assets/img/juejin-logo.png" alt="">
                    </a>
                </div>
                <div class="nav__main">
                    <ul class="nav__main-list">
                        <li class="list-left" ref="listLeftBox">
                            <div class="list-left-list">
                                <ul class="list__contents" ref="listBox">
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
                                            <input class="input" type="text" placeholder="搜索稀土掘金" ref="inputBox">
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
            <div class="page__header__tag" v-if="headeTag">
                <div class="tag__contents" ref="tagContent">
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
                    <div class="tag__manage" ref="tagManage">
                        <span><a href="#">标签管理</a></span>
                    </div>
                </div> 
            </div>
        </div>

        <!-- 一键回到顶部 -->
        <div class="page__header__side" v-show="headerSide">
            <a href="javascript:scroll(0,0)"><div class="backTop">
                <img src="../assets/img/top.png" alt="">
            </div></a>
        </div>
    </div>    
</template>

<script>
    import "../assets/css/page__header.css"
    import eventBus from "../assets/js/EventBus"

    export default {
        data() {
            return {
                headerNavSign: true,
                headeTag:  this.msg,
                headerSide: false,
                oldScrollTop: 0,
                screenWidth: document.body.clientWidth
            }
        },
        props: {
            msg:{
                type:Boolean,
                default: false
            }
        },
        watch:{
            screenWidth(val){
                // 为了避免频繁触发resize函数导致页面卡顿，使用定时器
                if(!this.timer){
                    // 一旦监听到的screenWidth值改变，就将其重新赋给data里的screenWidth
                    this.screenWidth = val
                    this.timer = true
                    let that = this
                    let listArr = that.$refs.listBox;
                    setTimeout(function(){
                        // 打印screenWidth变化的值
                        // console.log(that.screenWidth)
                        if(that.screenWidth < 1385){
                            that.$refs.listLeftBox.style.width = '100%';
                            listArr.style.display = 'none'
                        }else{
                            listArr.style.display = 'flex';
                        }
                        
                        that.timer = false;
                    },100)
                }
            }
        },
        methods: {
            setHeaderNavSign(){
                // 滚动条距文档顶部的距离
                let scrollTop = window.pageYOffset || document.documentElement.scrollTop ||
                    document.body.scrollTop
                // 滚动条滚动的距离
                let scrollStep = scrollTop - this.oldScrollTop;
                //  控制头部的显示
                // 回到顶部是显示头部导航栏
                if(scrollTop == 0){
                    this.$refs.headerBox.style.marginTop = '0px';
                    this.headerNavSign = true;
                    this.pushMsg();
                }
                // 更新——滚动前，滚动条距文档顶部的距离
                if(scrollTop > 420){
                    this.oldScrollTop = scrollTop;
                    if (scrollStep < 0) {
                        this.$refs.headerBox.style.marginTop = '0px';
                        this.headerNavSign = true;
                        this.pushMsg();
                    } else {
                        this.$refs.headerBox.style.marginTop = '-60px';
                        this.headerNavSign = false;
                        this.pushMsg();
                    }
                }
                
                // 一键回到页面顶部  (控制一键回到顶部按钮的显示)
                if(scrollTop > 800){
                    this.headerSide = true;
                }else{
                    this.headerSide = false;
                }
            },
            pushMsg(){
            	// 通过事件总线发送消息
                eventBus.$emit('pushMsg',this.headerNavSign)
            }
        },
        mounted () {
            const self = this;
            window.onresize = () => {
                return (() => {
                    window.screenWidth = document.body.clientWidth
                    self.screenWidth = window.screenWidth
                })()
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

    /* .v-enter-active{
        animation: showHeader .3s linear;
    }
    .v-leave-active{
        animation: showHeader .3s linear reverse;
    }

    @keyframes showHeader{
        from{
            transform: translateY(-60px);
        }
        to{
            transform: translateY(0px);
        }
    } */
</style>