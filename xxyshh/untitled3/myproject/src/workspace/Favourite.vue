<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
      <SideBar currentindex='2'></SideBar>
      </el-aside>
      <el-main style="width: 80%">
        <h2 class="h2color">收藏的文档</h2>
        <!-- <doc-list :docs="collectedDocs"></doc-list> -->
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
  name: "Favourite",
  components: { NavBar, SideBar, DocList,RightBar },
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
        },
        {
          id: '4',
          title: "四",
        },
        {
          id: '5',
          title: "第五wwuwuwuwu个文档",
        },
        {
          id: '6',
          title: "第六",
        }
      ]
    };
  },
  computed: {
    // collectedDocs() {
    //   return 收藏的文档列表
    // }
  },
};
</script>

<style>
  .h2color {
    color: #7093FF;
  }
</style>
