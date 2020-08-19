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
        <team-side-bar2 currentindex="1">
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
            {{info}}
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
        info:'这里是团队简介。',
        headUrl: require("@/assets/head.jpg"),
        // team的id
        id: null,
        teamLeader: {
          profileUrl: require("@/assets/head.jpg"),
          userName: 'xxy'
        },
        teamMembers: [
          {
            profileUrl: require("@/assets/head.jpg"),
            userName: "xxy",
          },
          {
            profileUrl: require("@/assets/head.jpg"),
            userName: "ljm",
          },
          {
            profileUrl: require("@/assets/head.jpg"),
            userName: "wsyshhshhshh",
          },
          {
            profileUrl: require("@/assets/head.jpg"),
            userName: "zbn",
          },
          {
            profileUrl: require("@/assets/head.jpg"),
            userName: "lzy",
          },
          {
            profileUrl: require("@/assets/head.jpg"),
            userName: "wzz",
          },
        ],
      };
    },
    created() {
      //获取团队id   this.id = this.$route.params.id;
      this.fetchUser();
      sessionStorage.setItem('teamL', JSON.stringify(this.$route.params.id));
      this.fetchInfo();
      this.fetchLeader();
      this.fetchMember();
    },
    methods:{
      fetchUser() {
        this.userL = JSON.parse(sessionStorage.getItem("userL"));
      },
      fetchInfo(){
        var _this = this;
        axios.post("http://127.0.0.1:8081/team/getInfo/" + this.$route.params.id)
          .then(function (response) {
            var content = response.data;
            _this.info = content;
          })
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      },
      fetchLeader(){
        var _this = this;
        axios.post("http://127.0.0.1:8081/team/getUser/" + this.$route.params.id)
          .then(function (response) {
            var content = JSON.parse(JSON.stringify(response.data));
            console.log(JSON.stringify(response.data));
            _this.teamLeader.userName = content.userName;
            _this.teamLeader.profileUrl = content.profileUrl;
          })
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      },
      fetchMember(){
        var _this = this;
        axios.post("http://127.0.0.1:8081/team/getMember/" + this.$route.params.id)
          .then(function (response) {
            var memberL = response.data;
            _this.teamMembers = memberL;
            console.log("memberrrr");
            console.log(response)
          })
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      }
    }
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
