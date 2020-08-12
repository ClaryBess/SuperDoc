<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
        <SideBar currentindex="4"></SideBar>
      </el-aside>
      <el-main style="width: 80%">
        <h2 class="h2color">加入的团队</h2>
        <!-- <teams-list :teams="joinedteams"></teams-list> -->
        <teams-list :teams="teams"></teams-list>
      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import SideBar from "../SideBar";
import TeamsList from "./TeamsList";
import RightBar from "../RightBar";

export default {
  name: "Team",
  components: { NavBar, SideBar, TeamsList,RightBar },
  data() {
    return {
      headUrl: require("@/assets/head.jpg"),
      teams: [
        {
          id: '1',
          title: '湍湍湍湍'
        },
        {
          id: '2',
          title: 'mmmmm'
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
