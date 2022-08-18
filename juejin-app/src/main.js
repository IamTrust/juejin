import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
// 引入路由器
import router from './router'
// 设置标题
import VueWechatTitle from 'vue-wechat-title'

Vue.use(ElementUI);
Vue.use(VueWechatTitle)
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
