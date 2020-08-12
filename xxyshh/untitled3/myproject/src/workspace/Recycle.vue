<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
      <SideBar  currentindex='5'></SideBar>
      </el-aside>
      <el-main style="width: 80%">
        <h2 class="h2color">回收站</h2>
        <!-- <doc-list :docs="recycleDocs"></doc-list> -->
        <doc-list :docs="Docs"></doc-list>
      </el-main>
      <div class="rightBar">
        <el-button size="small"type="primary" style="margin-bottom: 18px;margin-left: 2px">新建文档<i class="el-icon-edit el-icon--right"></i></el-button>
        <el-button size="small" type="primary">模板库<i class="el-icon-link el-icon--right"></i></el-button>
      </div>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "../components/NavBar";
import SideBar from "./SideBar";
import DocList from "./DocList";

export default {
  name: "Recycle",
  components: { NavBar, SideBar,DocList },
  data() {
    return {
      headUrl: require("../assets/head.jpg"),
      Docs: [
        {
          id: '1',
          title: "第111",
        },
        {
          id: '2',
          title: "第二个hhhhh文档",
        },
        {
          id: '3',
          title: "第三个文dashdkjlashdjkl档",
        }
      ]
    };
  },
};
</script>
<style>
  .h2color {
    color: #7093FF;
  }
  .rightBar{
    width: 5%;
    float: right;
    margin-right: 80px;
    margin-top: 60px;
  }
</style>
