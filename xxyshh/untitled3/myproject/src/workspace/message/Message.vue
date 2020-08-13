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
        <!-- 获取的消息列表 -->
        <mes-list :mess="mess"></mes-list>
      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import RightBar from "../RightBar";
import MesSideBar from "./MesSideBar";
import MesList from "./MesList";

export default {
  name: "Message",
  components: { NavBar, RightBar, MesSideBar, MesList },
  data() {
    return {
      headUrl: require("@/assets/head.jpg"),
      mess: [
        {
          id: "1",
          title: "hhh",
        },
        {
          id: "2",
          title: "不许笑",
        },
      ],
    };
  },
};
</script>

<style>
.h2color {
  color: #7093ff;
}
</style>
