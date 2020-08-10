import Vue from 'vue'
import Router from 'vue-router'
import Home from "../components/Home";
import App from "../App";
import HelloWorld from "../components/HelloWorld";
import Register1 from "../components/Register1";
import Edit from "../components/Edit";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/hello',
      name: '/hello',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/register1',
      name: 'register1',
      component: Register1
    },
    {
      path: '/edit',
      name: 'edit',
      component: Edit
    }
  ]
})
