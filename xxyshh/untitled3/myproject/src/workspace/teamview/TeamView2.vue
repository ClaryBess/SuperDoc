// 成员的页面
<template>
  <el-container>
    <!-- 头部 -->
    <el-header>
      <div>
        <nav-bar :headSrc="headUrl">
        </nav-bar>
      </div>
    </el-header>
    <el-container>
      <!-- 左栏 -->
      <el-aside width="15%">
        <team-side-bar2>
        </team-side-bar2>
      </el-aside>
      <!-- 内容 -->
      <el-main style="width: 80%">
        <!-- 团队简介 -->
        <el-card class="box-card" shadow="always">
          <div slot="header" class="clearfix">
            <span style="font-size: 17px">
              <strong>团队简介</strong>
            </span>
          </div>
          <div class="text item">
            我们是非常专业的团队。美羊羊走中路的话输出不够，线上游走也来不及赶快，还是选欧阳修好，但是比起欧阳娜娜又有些许不足，要不还是选欧阳靖吧至少经济能压上还可以为羊村发展尽尽力.
          </div>
        </el-card>
        <!-- 团队成员 -->
        <div style="width: 880px">
          <el-card style="width: 440px; height: 180px" class="box-card" shadow="always">
            <div slot="header" class="clearfix">
              <span style="font-size: 17px">
                <strong>创建者</strong>
              </span>
            </div>

            <div class="leader-item">
              <!-- :member=传入的团队成员 -->
              <!-- <member-list :members="teamMembers"></member-list> -->
              <MemberListItem2 :memberItem="teamMembers[0]"><h2 slot="deleteIcon"></h2></MemberListItem2>
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
              <member-list2 :members="teamMembers"></member-list2>
            </div>
          </el-card>
        </div>
      </el-main>
      <!-- 右栏 -->
      <right-bar></right-bar>
    </el-container>
    <!-- 回到顶部 -->
    <el-backtop></el-backtop>
  </el-container>
</template>

<script>
  import NavBar from "@/components/NavBar";
  import TeamSideBar2 from "./TeamSideBar2";
  import DocList from "../DocList";
  import MemberList2 from "./MemberList2";
  import RightBar from "../RightBar";
  import MemberListItem2 from "./MemberListItem2";

  export default {
    name: "TeamView2",
    components: {
      NavBar,
      TeamSideBar2,
      DocList,
      MemberList2,
      RightBar,
      MemberListItem2
    },
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
            title: "四少时诵诗书所所所所所所所所所所所所所所所",
          },
          {
            id: "5",
            title: "第五wwuwuwuwuwwwwwwwwwwwwww个文档",
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
      sessionStorage.setItem('teamL', JSON.stringify(this.$route.params.id));
    },
  };
</script>

<style scoped>
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

  .box-card {
    margin-top: 50px;
    margin-left: 50px;
    margin-bottom: 10px;
    width: 880px;
  }

</style>
