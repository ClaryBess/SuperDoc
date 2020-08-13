<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
      <SideBar></SideBar>
      </el-aside>
      <el-main style="width: 80% text-align: center">
        <h2 class="h2color">欢迎来到您的个人工作台</h2>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "../components/NavBar";
import SideBar from "./SideBar";

export default {
  name: "WorkSpace",
  components: { NavBar, SideBar },
  data() {
    return {
      headUrl: require("../assets/head.jpg"),
    };
  },
};
</script>

<style>
  .h2color {
    color: #7093FF;
  }
</style>