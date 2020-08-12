<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px">
      <SideBar></SideBar>
      </el-aside>
      <el-main>Main</el-main>
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
</style>