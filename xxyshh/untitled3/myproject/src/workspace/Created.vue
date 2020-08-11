<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px">
      <SideBar  currentindex='3'></SideBar>
      </el-aside>
      <el-main>
        <h2 class="h2color">自己创建的文件</h2>
        <!-- <doc-list :docs="createdDocs"></doc-list> -->
        <doc-list :docs="Docs"></doc-list>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "../components/NavBar";
import SideBar from "./SideBar";
import DocList from "./DocList";

export default {
  name: "Created",
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
</style>