import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    hasLogin: false
  },
  mutations: {
    update(state,[key,value]){
      state[key]=value;
    },
  }
})

export default store
