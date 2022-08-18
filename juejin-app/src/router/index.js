// 路由配置
import VueRouter from "vue-router";
import Vue from "vue";

Vue.use(VueRouter);

export default new VueRouter({
    routes: [{
        path: "/",
        component: () => import("../pages/Index"),
        meta: {
            title: '主页'
        }
    }, {
        path: "/detail/:articleId",
        component: () => import("../pages/Detail"),
        meta: {
            title: '文章详情'
        }
    }]
});