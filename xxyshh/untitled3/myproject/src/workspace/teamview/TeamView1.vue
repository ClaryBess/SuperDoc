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
        <h2>团队界面1</h2>
        <h2>团队创建者</h2>
        <h2>团队成员</h2>
        <h2>团队信息</h2>

        <h2 class="h2color">管理成员</h2>
        <!-- :member=传入的团队成员 -->
        <!-- <member-list :members="teamMembers"></member-list> -->
        <member-list :members="teamMembers"></member-list>
        <h2>{{id}}</h2>
      </el-main>
      <div class="rightBar">
        <el-button size="small"type="primary" style="margin-bottom: 18px;margin-left: 4px">新建文档<i class="el-icon-edit el-icon--right"></i></el-button>
        <el-button size="small" type="primary" style="margin-bottom: 18px">模板库<i class="el-icon-link el-icon--right"></i></el-button>
        <el-button size="small" type="primary" style="margin-bottom: 18px;margin-left: 4px" @click="open">解散团队<i class="el-icon-link el-icon--right"></i></el-button>
      </div>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import TeamSideBar1 from "./TeamSideBar1";
import DocList from "../DocList";
import MemberList from "./MemberList";
export default {
  name: "TeamView1",
  components: { NavBar, TeamSideBar1, DocList,MemberList  },
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
          title: "四",
        },
        {
          id: "5",
          title: "第五wwuwuwuwu个文档",
        },
        {
          id: "6",
          title: "第六",
        },
      ],
      teamMembers:[
        {
          id: "1",
          name: "xxy",
        },
        {
          id: "2",
          name: "ljm",
        },
        {
          id: "3",
          name: "wsy",
        }
      ]
    };
  },
  created() {
    //获取团队id
    this.id = this.$route.params.id;
  },
  methods:{
    open() {
      this.$confirm('确定解散该团队吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '解散成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消操作'
        });
      });
    },
  }
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
