import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import lodash from 'lodash'
import ElementUI from 'element-ui'
import '@/assets/theme/index.css'
import '@/assets/icon/iconfont.css'
import {formatTime} from "./utils/time";
  /* eslint-disable */
Vue.config.productionTip = false

Vue.use(ElementUI)

Object.defineProperty(Vue.prototype, '$_', { value: lodash })

Vue.directive('title',  function (el, binding) {
  document.title = el.dataset.title
})

Vue.filter('format', formatTime)

new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
