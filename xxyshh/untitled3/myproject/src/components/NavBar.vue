// 这是登录后导航栏组件，通过属性headSrc来更换头像
<template>
  <div id="root" class="tabBar">
    <router-link to="/" ><img class="logo" src="../assets/nav-logo.png"  alt=""/></router-link>

    <ul class="nav">
      <li>
        <router-link to="/recently">工作台</router-link>
      </li>
      <li>
        <router-link to="/unreadmessage">消息</router-link>
        <!-- <a href="#">消息</a> -->
      </li>
      <li>
        <router-link to="/team">团队</router-link>
      </li>
    </ul>

    <div :class="search">
      <a href="#"><i class="iconfont iconsearch"></i></a>
      <input type="text" class="searchInput" placeholder="搜索我的文档" @focus="inputFocus" @blur="inputBlur" />
    </div>
    <div class="right">
      <ul class="rightNav">
        <li class="dropdown">
          <router-link to="/homepage">
              <img :src='headSrc' class="userhead" />
          </router-link>
        </li>
        <li>
          <div >
            <router-link to="/" > <el-button round >退出</el-button></router-link>
          </div>
        </li>
      </ul>

    </div>

  </div>
</template>

<script>
    export default {
        name: "NavBar",
      data() {
        return {
          headSrc: require("../assets/head.jpg"),
          itemList: [{
            title: '我的工作台',
            subItemList: []
          },
            {
              title: '消息',
              subItemList: []
            }
          ],
          userList: [],
          search:'search'
        }
      },
      methods: {
        inputFocus: function() {
          this.search = 'searchLong'
        },
        inputBlur: function() {
          this.search = 'search'
        }
      }
    }
</script>

<style scoped>
  .LoginForm{
    margin: 0 auto;
    width: 80%;
  }
  .tabBar {
    height: 56px;
    width: 100%;
    border-bottom-color: #f2f2f2;
    background-color: #ffffff;
    border-bottom-width: 2px;
    border-bottom-style: inset;
    display: flex;
    z-index: 9999;
  }

  .logo {
    height: 56px;
  }

  li {
    list-style: none;
  }

  a {
    text-decoration: none;
    display: block;
  }

  .nav {
    width: 225px;
    margin-left: 100px;
  }

  .nav li {
    width: 65px;
    height: 56px;
    float: left;
  }

  .nav>li>a {
    width: 65px;
    line-height: 56px;
    color: #333;
    text-align: center;
    font-size: 17px;
  }

  .nav li:hover {
    background-color: #f5f5f5;
  }

  .subNav {
    height: 350px;
    width: 180px;
    visibility: hidden;
    border: #eeeeee solid 1px;
    background-color: #ffffff;
    box-shadow: 0 2px 2px #eeeeee;

  }

  .subNav li:first-child {
    margin-top: 7px;
  }

  .subNav li {
    height: 48px;
    width: 180px;
  }

  .nav>li:last-child:hover .subNav {
    visibility: visible;
  }

  .subNav li a {
    width: 180px;
    height: 48px;
    background-color: #ffffff;
    line-height: 48px;
    color: #333333;
  }

  .subNav li span,
  .subNav li i {
    margin-left: 15px;
  }

  .subNav li a:hover {
    background-color: #f5f5f5;
  }

  .search,
  .searchLong {
    height: 38px;
    background-color: #eee;
    margin: auto 0;
    display: flex;
    align-items: center;
    flex-direction: row-reverse;
    border-radius: 38px;
    transition: width 0.5s;
    transition-delay: 0.5s;
    -webkit-transition-delay: 0.5s;
    -webkit-transition: width 0.5s;
  }

  .search {
    width: 160px;
  }

  .searchLong {
    width: 220px;
  }

  .search i,.searchLong i {
    display: block;
    width: 30px;
    height: 30px;
    line-height: 30px;
    color: rgb(156, 149, 149);
  }

  .searchLong i {
    text-align: center;
    border-radius: 15px;
    color: #fff;
    margin-right: 5px;
    line-height: 30px;
    background-color: #969696;
  }

  .searchInput {
    width: 100%;
    height: 38px;
    padding-left: 15px;
    background: none;
    border: 0px;
    outline: none;
    font-size: 15px;
  }

  ::-webkit-input-placeholder {
    color: #a1a1a1;
  }

  ::-moz-placeholder {
    color: #a1a1a1;
  }

  /* firefox 19+ */
  :-ms-input-placeholder {
    color: #a1a1a1;
  }

  /* ie */
  input:-moz-placeholder {
    color: #a1a1a1;
  }

  .right {
    flex: 1;
    margin-right: 80px;
    display: flex;
    flex-direction: row-reverse;
  }

  .rightNav li {
    height: 56px;
    float: left;
    line-height: 56px;
  }

  .rightNav li:first-child a {
    width: 65px;
    color: #333;
  }

  .rightNav .login:hover{
    background-color: #f5f5f5;
  }

  .write {
    width: 100px;
    height: 40px;
    display: inline-block;
    background-color: #ffffff;
    color: #50BFFF;
    font-size: 15px;
    line-height: 40px;
    text-align: center;
    border-radius: 20px;
    margin-left: 30px;
    border-color: #50BFFF;
    border-style: solid;
    border-width: thin;
  }

  .write:hover {
    border-color: #409EFF;
    color: #409EFF;
    transition: color 0.7s;
  }

  .dropdown {
    width: 90px;
    margin: 0 20px;
  }

  .dropdown>a {
    display: flex;
    flex-direction: row;
    align-items: center;
    height: 56px;
    justify-content: center;
    color: #333;
  }

  .dropdown>a i {
    color: rgb(156, 149, 149);
  }

  .userhead {
    width: 40px;
    height: 40px;
    border: 1px solid #ddd;
    border-radius: 50%;
  }

  .dropdown:hover {
    background-color: #f5f5f5;
  }

  .dropdownNav {
    width: 180px;
    height: 420px;
    visibility: hidden;
    border: #eeeeee solid 1px;
    background-color: #ffffff;
    box-shadow: 0 2px 2px #eeeeee;
  }

  .dropdownNav li:first-child {
    margin-top: 10px;
  }

  .dropdown:hover .dropdownNav {
    visibility: visible;
  }

  .dropdownNav li {
    width: 180px;
    height: 50px;
    line-height: 50px;
    background-color: #ffffff;
  }

  .dropdownNav li:hover {
    background-color: #f5f5f5;
  }

  .dropdownNav li a span,
  .dropdownNav li a i {
    color: #333;
    margin-left: 15px;
  }



  html, body, div, span, applet, object, iframe,
  h1, h2, h3, h4, h5, h6, p, blockquote, pre,
  a, abbr, acronym, address, big, cite, code,
  del, dfn, em, img, ins, kbd, q, s, samp,
  small, strike, strong, sub, sup, tt, var,
  b, u, i, center,
  dl, dt, dd, ol, ul, li,
  fieldset, form, label, legend,
  table, caption, tbody, tfoot, thead, tr, th, td,
  article, aside, canvas, details, embed,
  figure, figcaption, footer, header, hgroup,
  menu, nav, output, ruby, section, summary,
  time, mark, audio, video {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
  }
  /* HTML5 display-role reset for older browsers */
  article, aside, details, figcaption, figure,
  footer, header, hgroup, menu, nav, section {
    display: block;
  }
  body {
    line-height: 1;
  }
  ol, ul {
    list-style: none;
  }
  blockquote, q {
    quotes: none;
  }
  blockquote:before, blockquote:after,
  q:before, q:after {
    content: '';
    content: none;
  }
  table {
    border-collapse: collapse;
    border-spacing: 0;
  }
</style>
