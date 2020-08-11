import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../components/Home";
import App from "../App";
import HelloWorld from "../components/HelloWorld";
import Register1 from "../components/Register1";
import Register2 from "../components/Register2";
import Register3 from "../components/Register3";
import Edit from "../components/Edit";
import Homepage from "../components/Homepage";
import HomepageEdit from "../components/HomepageEdit";
import Welcome from "../components/Welcome";

import WorkSpace from "../workspace/WorkSpace";
import Recently from "../workspace/Recently";
import Favourite from "../workspace/Favourite";
import Created from "../workspace/Created";
import Team from "../workspace/Team";
import Recycle from "../workspace/Recycle";
import Change from "../components/Change";
import View from "../components/View";

Vue.use(VueRouter)

const routes = [{
    path: '/hello',
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
    path: '/register2',
    name: 'register2',
    component: Register2
  },
  {
    path: '/register3',
    name: 'register3',
    component: Register3
  },
  {
    path: '/edit',
    name: 'edit',
    component: Edit
  },
  {
    path: '/homepage',
    name: 'homepage',
    component: Homepage
  },
  {
    path: '/homepageedit',
    name: 'homepageedit',
    component: HomepageEdit
  },
  {
    path: '/workspace',
    name: 'workspace',
    component: WorkSpace
  },
  {
    path: '/recently',
    name: 'recently',
    component: Recently
  },
  {
    path: '/favourite',
    name: 'favourite',
    component: Favourite
  },
  {
    path: '/created',
    name: 'created',
    component: Created
  },
  {
    path: '/team',
    name: 'team',
    component: Team
  },
  {
    path: '/recycle',
    name: 'recycle',
    component: Recycle
  },
  {
    path: '/detail/1',
    name: 'change',
    component: Change
  },
  {
    path: '/welcome',
    name: 'welcome',
    component: Welcome
  },
  {
    path: '/view',
    name: 'view',
    component: View
  }
]
const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
