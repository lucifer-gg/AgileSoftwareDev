import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
  /* eslint-disable */
Vue.config.productionTip = false

Vue.use(ElementUI)

Vue.directive('title',  function (el, binding) {
  document.title = el.dataset.title
})

new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
