<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px">
      <SideBar  currentindex=4></SideBar>
      </el-aside>
      <el-main>
        <h2 class="h2color">加入的团队</h2>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "../components/NavBar";
import SideBar from "./SideBar";

export default {
  name: "Team",
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