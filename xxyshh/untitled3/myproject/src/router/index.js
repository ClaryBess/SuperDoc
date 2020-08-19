import Vue from 'vue'
import VueRouter from 'vue-router'
import Register1 from "../components/Register1";
import Register2 from "../components/Register2";
import Register3 from "../components/Register3";
import Edit from "../components/Edit";
import Homepage from "../components/Homepage";
import HomepageEdit from "../components/HomepageEdit";
import Welcome from "../components/Welcome";

// import WorkSpace from "../workspace/WorkSpace";
import Recently from "../workspace/Recently";
import Collect from "../workspace/Collect";
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
import UnreadMessage from "../workspace/message/UnreadMessage";
import NavBarOrigin from "../components/NavBarOrigin";

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
    path: '/edit/:template',
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
    component: Recently
  },
  {
    path: '/recently',
    name: 'recently',
    component: Recently
  },
  {
    path: '/collect',
    name: 'collect',
    component: Collect
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
  {
    path: '/teamleader/:id',
    name: 'teamview1',
    component: TeamView1
  },
  //用于测试成员的团队界面
  {
    path: '/teammember/:id',
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
    path: '/teamleader/teamdoc/:id',
    name: 'teamdoc',
    component: TeamDoc
  },
  // 团队文档-成员
  {
    path: '/teammember/teamdoc/:id',
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
    path: '/unreadmessage',
    name: 'unreadmessage',
    component: UnreadMessage
  },
  {
    path: '/change/:id',
    name: 'change',
    component: Change
  },
  {
    path: '/editTeam/:tid/:template',
    name: 'editTeam',
    component: EditTeamDoc
  },
  {
    path: '/changeTeam/:id',
    name: 'changeTeam',
    component: ChangeTeamDoc
  },
  {
    path:'/nav',
    name:'nav',
    component: NavBarOrigin
  }
]
const router = new VueRouter({
  routes,
  mode: 'history'
});

export default router
