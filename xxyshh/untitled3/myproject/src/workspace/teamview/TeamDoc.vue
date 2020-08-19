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
        <team-side-bar1 currentindex="2"></team-side-bar1>
      </el-aside>
      <el-main style="width: 80%">
        <el-button class="switch" type="text" @click="toMenu">
          <i class="el-icon-menu"></i>
        </el-button>
        <el-button class="switch" style="margin-right: -5px" type="text" @click="toList">
          <i class="el-icon-s-unfold"></i>
        </el-button>
        <!-- <doc-list :docs="teamDocs"></doc-list> -->
        <doc-list
          v-show="showList"
          :docs="Docs"
          :currentview=4
          :userID="userID"
          :teamID="id"
          style="margin-top: 50px; margin-left: 25px"
        ></doc-list>
        <doc-list2
          v-show="showMenu"
          :tems="Docs"
          :currentview=4
          :userID="userID"
          :teamID="id"
          style="width: 100%;"
        ></doc-list2>
        <div style="margin-left: 41%; margin-top: 8%" v-show="this.isNULL">
          <div>
            <img src="@/assets/空.png" style=" width: 110px" />
          </div>
        </div>
      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import TeamSideBar1 from "./TeamSideBar1";
import DocList from "../DocList";
import RightBar from "../RightBar";
import DocList2 from "../DocList2";
import axios from 'axios';

export default {
  name: "TeamDoc",
  components: { NavBar, TeamSideBar1, DocList, RightBar, DocList2 },
  data() {
    return {
      headUrl: require("@/assets/head.jpg"),
      // team的id
      id: 1,
      Docs: [],
      showMenu: false,
      showList: true,
      userID: 1,
      isNULL: true,
    };
  },
  methods: {
    toMenu: function () {
      this.showMenu = true;
      this.showList = false;
    },
    toList: function () {
      this.showList = true;
      this.showMenu = false;
    },
    fetchUser() {
      this.userL = JSON.parse(sessionStorage.getItem("userL"));
      this.userID = this.userL.userID;
    },
    fetchList() {
      axios
        .post("/team/getDoc/" + this.id)
        .then((res) => {
          console.log(res);
          if (res.data == "") {
            this.isNULL = true;
          } else {
            this.isNULL = false;
            this.Docs = res.data;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created() {
    //获取团队id
    this.id = parseInt(this.$route.params.id);
    this.fetchUser();
    this.fetchList();
  },
};
</script>

<style scoped>
.h2color {
  color: #3369e7;
}
.rightBar {
  width: 5%;
  float: right;
  margin-right: 80px;
  margin-top: 60px;
}

.switch {
  width: 40px;
  float: right;
  margin-top: 8px;
  margin-right: 30px;
}
</style>
