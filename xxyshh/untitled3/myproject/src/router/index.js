import Vue from 'vue'
import VueRouter from 'vue-router'
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
import Team from "../workspace/teamview/Team";
import Recycle from "../workspace/Recycle";
import Change from "../components/Change";
import TeamView1 from "../workspace/teamview/TeamView1";
import TeamView2 from "../workspace/teamview/TeamView2";
import View from "../components/View";
import TeamDoc from "../workspace/teamview/TeamDoc";
import TeamDoc2 from "../workspace/teamview/TeamDoc2";

import TemLib from "../workspace/temLib/TemLib";
import EditTeamDoc from "../components/EditTeamDoc";
import ChangeTeamDoc from "../components/ChangeTeamDoc";

import Message from "../workspace/message/Message";

Vue.use(VueRouter)

const routes = [
  { // 注册步骤1
    path: '/register1',
    name: 'register1',
    component: Register1
  },
  {// 注册步骤2
    path: '/register2',
    name: 'register2',
    component: Register2
  },
  {// 注册步骤3
    path: '/register3',
    name: 'register3',
    component: Register3
  },
  {
    path: '/edit',
    name: 'edit',
    component: Edit
  },
  { //个人空间
    path: '/homepage',
    name: 'homepage',
    component: Homepage
  },
  { //修改个人空间
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
    path: '/detail/:id',
    name: 'view',
    component: View
  },
  // {
  //   path: '/team/:id',
  //   name: 'teamview',
  //   component: TeamView
  // },
  //用于测试创建者的团队界面
  {
    path: '/team/1',
    name: 'teamview1',
    component: TeamView1
  },
  //用于测试成员的团队界面
  {
    path: '/team/2',
    name: 'teamview2',
    component: TeamView2
  },
  { // 首页
    path: '/',
    name: 'welcome',
    component: Welcome
  },
  //模板库页面
  {
    path: '/temlib',
    name: 'temlib',
    component: TemLib
  },
  // 团队文档-组长
  {
    path: '/team/teamdoc',
    name: 'teamdoc',
    component: TeamDoc
  },
  // 团队文档-成员
  {
    path: '/team/teamdoc2',
    name: 'teamdoc2',
    component: TeamDoc2
  },
  //消息页面
  {
    path: '/message',
    name: 'message',
    component: Message
  },
  {
    path: '/change',
    name: 'change',
    component: Change
  },
  {
    path: '/editTeam',
    name: 'editTeam',
    component: EditTeamDoc
  },
  {
    path: '/changeTeam',
    name: 'changeTeam',
    component: ChangeTeamDoc
  }
]
const router = new VueRouter({
  routes,
  mode: 'history'
});

export default router
