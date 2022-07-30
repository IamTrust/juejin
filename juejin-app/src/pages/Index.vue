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
                        <li class="list__item">
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
                                            <a href="#" class="title">如何在React中应用SOLID原则？</a>
                                        </div>
                                        <div class="abstract">
                                            <a href="#">
                                                <div>大家好，我是CUGGZ。 在面向对象编程（OOP）中，SOLID 原则是设计模式的基础，它的每个字母代表一种设计原则：
                                                    单一职责原则（SRP） 开放封闭原则（OCP） 里氏替换原则（LSP） 接口隔离</div>
                                            </a>
                                        </div>
                                        <ul class="action-list">
                                            <li class="item">
                                                <i class="eye"></i>
                                                <span>651</span>
                                            </li>
                                            <li class="item">
                                                <i class="zan"></i>
                                                <span>20</span>
                                            </li>
                                            <li class="item">
                                                <i class="cloud"></i>
                                                <span>6</span>
                                            </li>
                                        </ul>
                                    </div>
                                    <img src="../assets/img/article__01.png" alt="" class="lazy">
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

    export default {
        data() {
            return {
                articleInfo: {}
            }
        }
    }
</script>

<style>

</style>