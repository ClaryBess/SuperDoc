<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <SideBar currentindex="1"></SideBar>
      </el-aside>
      <el-main>
        <h2 class="h2color">最近浏览的文档</h2>
        <!-- <doc-list :docs="showDocs"></doc-list> -->
        <doc-list :docs="Docs"></doc-list>
      </el-main>
      <div class="rightBar">
        <el-button size="small" type="primary" style="margin-bottom: 18px;margin-left: 2px">新建文档<i class="el-icon-edit el-icon--right"></i></el-button>
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
  name: "Recently",
  components: { NavBar, SideBar, DocList },
  data() {
    return {
      headUrl: require("../assets/head.jpg"),
      Docs: [
        {
          id: "1",
          title: "第111",
        },
        {
          id: "2",
          title: "第二个hhhhh文档",
        },
        {
          id: "3",
          title: "第三个文dashdkjlashdjkl档",
        },
        {
          id: "4",
          title: "四",
        },
        {
          id: "5",
          title: "第五wwuwuwuwu个文档",
        },
        {
          id: "6",
          title: "第六",
        },
      ],
    };
  },
  computed: {
    // showDocs() {
    //   return 浏览的文档列表
    // }
  },
};
</script>

<style>
  .h2color {
    color:#7093FF;
  }
  .rightBar{
    width: 150px;
    float: right;
    margin-right: 80px;
    margin-top: 60px;
  }
</style>
