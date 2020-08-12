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
        <el-card class="box-card" shadow="always">
          <div slot="header" class="clearfix">
            <span style="font-size: 17px">
              <strong>团队简介</strong>
            </span>
          </div>
          <div
            class="text item"
          >我们是非常专业的团队。美羊羊走中路的话输出不够，线上游走也来不及赶快，还是选欧阳修好，但是比起欧阳娜娜又有些许不足，要不还是选欧阳靖吧至少经济能压上还可以为羊村发展尽尽力</div>
        </el-card>
        <div style="width: 880px">
          <el-card style="width: 260px; height: 180px" class="box-card" shadow="always">
            <div slot="header" class="clearfix">
              <span style="font-size: 17px">
                <strong>创建者</strong>
              </span>
            </div>
            <div class="leader-item">
              <!-- :member=传入的团队成员 -->
              <!-- <member-list :members="teamMembers"></member-list> -->
              <member-list :members="teamMembers.id=1"></member-list>
              <h2>{{id}}</h2>
            </div>
          </el-card>
          <el-card class="box-card" shadow="always">
            <div slot="header" class="clearfix">
              <span style="font-size: 17px">
                <strong>成员</strong>
              </span>
            </div>
            <div class="member-item">
              <!-- :member=传入的团队成员 -->
              <!-- <member-list :members="teamMembers"></member-list> -->
              <member-list :members="teamMembers"></member-list>
              <h2>{{id}}</h2>
            </div>
          </el-card>
        </div>
      </el-main>
      <div class="rightBar">
        <el-button size="small" type="primary" style="margin-bottom: 18px;margin-left: 4px">
          新建文档
          <i class="el-icon-edit el-icon--right"></i>
        </el-button>
        <el-button size="small" type="primary" style="margin-bottom: 18px">
          模板库
          <i class="el-icon-link el-icon--right"></i>
        </el-button>
        <el-button
          size="small"
          type="primary"
          style="margin-bottom: 18px;margin-left: 4px"
          @click="open"
        >
          解散团队
          <i class="el-icon-link el-icon--right"></i>
        </el-button>
      </div>
    </el-container>

    <el-backtop right="80"></el-backtop>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import TeamSideBar1 from "./TeamSideBar1";
import DocList from "../DocList";
import MemberList from "./MemberList";
export default {
  name: "TeamView1",
  components: { NavBar, TeamSideBar1, DocList, MemberList },
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
      teamMembers: [
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
          name: "wsyshhshhshh",
        },
        {
          id: "4",
          name: "zbn",
        },
        {
          id: "5",
          name: "lzy",
        },
        {
          id: "6",
          name: "wzz",
        },
      ],
    };
  },
  created() {
    //获取团队id
    this.id = this.$route.params.id;
  },
  methods: {
    open() {
      this.$confirm("确定解散该团队吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$message({
            type: "success",
            message: "解散成功!",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作",
          });
        });
    },
  },
};
</script>

<style>
.text {
  font-size: 14px;
}
.item {
  margin: 15px 13px;
}
.leader-item {
  margin-left: 18px;
  margin-bottom: 1px;
}
.member-item {
  margin-left: 18px;
  margin-bottom: 1px;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}
.rightBar {
  width: 5%;
  float: right;
  margin-right: 80px;
  margin-top: 60px;
}
</style>
