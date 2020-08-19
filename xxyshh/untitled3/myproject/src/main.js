// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import './plugins/axios'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import '../static/iconfont.css'
import SliderVerificationCode from 'slider-verification-code';
import 'slider-verification-code/lib/slider-verification-code.css';
import VueParticles from 'vue-particles';
import axios from 'axios';
// import Pin from 'vue-pin';

// Vue.use(Pin);
Vue.use(ElementUI);
Vue.use(SliderVerificationCode);
Vue.use(VueParticles)
Vue.config.productionTip = false;
Vue.prototype.$ajax = axios;
axios.defaults.timeout=10000;
axios.defaults.baseURL="http://127.0.0.1:8081"
// Vue.use(axios);
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';
// axios.defaults.headers.post["Content-Type"]='application/json';

/* eslint-disable no-new */

/*Vue.directive('pin',function(el, binding){
  var pinned = binding.value;
  if(pinned){
    el.style.position = 'fixed';
    el.style.top = '80px';
    el.style.right = '30px';
  }
})*/

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
