// 路由配置
import VueRouter from "vue-router";
import Vue from "vue";

Vue.use(VueRouter);

export default new VueRouter({
    routes: [{
        path: "/",
        component: () => import("../pages/Index")
    }, {
        path: "/detail/:articleId",
        component: () => import("../pages/Detail")
    }]
});