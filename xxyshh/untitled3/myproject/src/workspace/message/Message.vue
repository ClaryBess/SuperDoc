<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
        <mes-side-bar></mes-side-bar>
      </el-aside>
      <el-main style="width: 80%">
        <h2 class="h2color">消息界面</h2>
      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import RightBar from "../RightBar";
import MesSideBar from "./MesSideBar";

export default {
  name: "Message",
  components: { NavBar, RightBar,MesSideBar },
  data() {
    return {
      headUrl: require("@/assets/head.jpg"),
    }
  }

};
</script>

<style>
</style>
