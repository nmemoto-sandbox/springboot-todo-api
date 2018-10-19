import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css' 
import App from './App.vue'

Vue.use(http)
import http from './http.js';
import router from './router.js'
import store from './store.js'

Vue.use(Vuetify)

new Vue({
  el: '#app',
  store,
  router,
  render: h => h(App)
})
