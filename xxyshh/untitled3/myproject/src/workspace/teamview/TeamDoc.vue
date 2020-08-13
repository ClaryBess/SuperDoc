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
        <team-side-bar1></team-side-bar1>
      </el-aside>
      <el-main style="width: 80%">
        <!-- <doc-list :docs="teamDocs"></doc-list> -->
        <doc-list :docs="Docs" style="margin-top: 50px; margin-left: 25px"></doc-list>
        <h2>{{id}}</h2>
      </el-main>
      <div class="rightBar">
        <el-button size="small"type="primary" style="margin-bottom: 18px;margin-left: 4px">新建文档<i class="el-icon-edit el-icon--right"></i></el-button>
        <el-button size="small" type="primary" style="margin-bottom: 18px">模板库<i class="el-icon-link el-icon--right"></i></el-button>
      </div>
    </el-container>
  </el-container>
</template>

<script>
  import NavBar from "@/components/NavBar";
  import TeamSideBar1 from "./TeamSideBar1";
  import DocList from "../DocList";
  export default {
    name: "TeamDoc",
    components: { NavBar, TeamSideBar1, DocList },
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
