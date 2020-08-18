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
        <team-side-bar2 currentindex="2"></team-side-bar2>
      </el-aside>
      <el-main style="width: 80%">

        <el-button class="switch"  type="text" @click="toMenu">
          <i class="el-icon-menu"></i>
        </el-button>
        <el-button class="switch" style="margin-right: -5px" type="text" @click="toList">
          <i class="el-icon-s-unfold"></i>
        </el-button>
        <team-doc-list1 v-show="showList" :docs="Docs" style="margin-top: 50px; margin-left: 25px"></team-doc-list1>
        <team-doc-list2 v-show="showMenu" :tems='Docs' style="width: 100%;"></team-doc-list2>

      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import TeamSideBar2 from "./TeamSideBar2";
import RightBar from "../RightBar";
import TeamDocList1 from "./TeamDocList1"
import TeamDocList2 from "./TeamDocList2"

export default {
  name: "TeamDoc2",
  components: { NavBar, TeamSideBar2,RightBar,TeamDocList1,TeamDocList2  },
  data() {
    return {
      headUrl: require("@/assets/head.jpg"),
      // team的id
      id: null,
      Docs: [
        {
          id: "1",
          title: "第111",
          isCollected: true,
          date: "2020/8/14 21:00",
        },
        {
          id: "2",
          title: "第二个hhhhh文档",
          isCollected: true,
          date: "2020/8/14 11:00",
        },
        {
          id: "3",
          title: "第三个文dashdkjlashdjkl档",
          isCollected: true,
          date: "2020/8/14 12:22",
        },
        {
          id: "4",
          title: "四ssssswwwwwwwwwwwwwwwss",
          isCollected: true,
          date: "2020/8/14 12:22",
        },
        {
          id: "5",
          title: "第五wwuwuwuwuwuwwwwwwww个文档",
          isCollected: true,
          date: "2020/8/14 12:00",
        },
        {
          id: "6",
          title: "第六",
          isCollected: true,
          date: "2020/8/14 12:00",
        },
      ],
      showMenu:false,
      showList:true,
    };
  },
  created() {
    //获取团队id
    this.id = this.$route.params.id;
  },
  methods:{
    toMenu:function () {
      this.showMenu = true;
      this.showList = false;
    },
    toList:function () {
      this.showList = true;
      this.showMenu = false;
    },
  }
};
</script>


<style>
  .h2color {
    color: #7093ff;
  }
  .rightBar {
    width: 5%;
    float: right;
    margin-right: 80px;
    margin-top: 60px;
  }

  .switch{
    width: 40px;
    float: right;
    margin-top:8px;
    margin-right: 30px;
  }
</style>
