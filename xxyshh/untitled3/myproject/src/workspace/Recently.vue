<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%" >
        <SideBar currentindex="1"></SideBar>
      </el-aside>
      <el-main style="width: 80%">
        <h2 class="h2color">最近浏览的文档</h2>
        <!-- <doc-list :docs="showDocs"></doc-list> -->
        <doc-list :docs="Docs"></doc-list>
      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "../components/NavBar";
import SideBar from "./SideBar";
import DocList from "./DocList";
import RightBar from "./RightBar";

export default {
  name: "Recently",
  components: { NavBar, SideBar, DocList,RightBar },
  data() {
    return {
      headUrl: require("../assets/head.jpg"),
      Docs: [
        {
          id: "1",
          title: "第111",
        }
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
</style>
