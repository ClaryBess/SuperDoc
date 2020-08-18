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
        <!-- 此处传入的是收藏的文档数组 -->
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
          isCollected: true
        },
        {
          id: '2',
          title: "第二个hhhhh文档",
          isCollected: true
        },
        {
          id: '3',
          title: "第三个文dashdkjlashdjkl档",
          isCollected: true
        },
        {
          id: '4',
          title: "四ssssswwwwwwwwwwwwwwwss",
          isCollected: true
        },
        {
          id: '5',
          title: "第五wwuwuwuwuwuwwwwwwww个文档",
          isCollected: true
        },
        {
          id: '6',
          title: "第六",
          isCollected: true
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
