// 创建者的页面
<template>
  <el-container>
    <el-header>
      <div>
        <nav-bar :headSrc="headUrl"></nav-bar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px">
      <team-side-bar2></team-side-bar2>
      </el-aside>
      <el-main>
        <h2>团队界面1</h2>
        <h2>团队创建者</h2>
        <h2>团队成员</h2>
        <h2>团队信息</h2>
        <h2>团队文档</h2>
        <!-- <doc-list :docs="teamDocs"></doc-list> -->
        <doc-list :docs="Docs"></doc-list>
        <h2>{{id}}</h2>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import TeamSideBar2 from "./TeamSideBar2";
import DocList from "../DocList";

export default {
  name: "TeamView2",
  components: { NavBar, TeamSideBar2,DocList },
  data() {
    return {
      headUrl: require("@/assets/head.jpg"),
      // team的id
      id: null,
      Docs: [
        {
          id: '1',
          title: "第111",
        },
        {
          id: '2',
          title: "第二个hhhhh文档",
        }
      ]
    };
  },
  created() {
    //获取团队id
    this.id = this.$route.params.id;
  },
};
</script>

<style>
</style>
