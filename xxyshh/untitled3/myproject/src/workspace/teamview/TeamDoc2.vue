// 创建者的页面
<template>
  <el-container>
    <el-header>
      <div>
        <nav-bar :headSrc="headUrl"></nav-bar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
        <team-side-bar2></team-side-bar2>
      </el-aside>
      <el-main style="width: 80%">
        <!-- <doc-list :docs="teamDocs"></doc-list> -->
        <doc-list :docs="Docs" style="margin-top: 50px; margin-left: 25px"></doc-list>
        <h2>{{id}}</h2>
      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
  import NavBar from "@/components/NavBar";
  import TeamSideBar2 from "./TeamSideBar2";
  import DocList from "../DocList";
  import RightBar from "../RightBar";
  export default {
    name: "TeamDoc2",
    components: { NavBar, TeamSideBar2, DocList, RightBar },
    data() {
      return {
        headUrl: require("@/assets/head.jpg"),
        // team的id
        id: null,
        Docs: [
          {
            id: "1",
            title: "第111",
          },
          {
            id: "2",
            title: "第二个hhhhh文档",
          },
          {
            id: "3",
            title: "第三个文dashdkjlashdjkl档",
          },
          {
            id: "4",
            title: "四sssssssssssssssssssssssssssssss",
          },
          {
            id: "5",
            title: "第五wwuwuwuwuwwwwwwwwwwwwwwwwwwwwwwwwwwwwww个文档",
          },
          {
            id: "6",
            title: "第六",
          },
        ],
      };
    },
    created() {
      //获取团队id
      this.id = this.$route.params.id;
    },
  };
</script>

<style>
  .h2color {
    color: #7093ff;
  }
  .rightBar{
    width: 5%;
    float: right;
    margin-right: 80px;
    margin-top: 60px;
  }
</style>
