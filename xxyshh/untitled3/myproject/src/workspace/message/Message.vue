<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
        <!-- <mes-side-bar @unReadMes="handleUnReadMes" @allMes="handleAllMes"></mes-side-bar> -->
        <mes-side-bar currentindex="1"></mes-side-bar>
      </el-aside>
      <el-main style="width: 80%">
        <h2 class="h2color">全部消息</h2>
        <!-- 获取的消息列表 -->
        <mes-list :mess="NowMess" :userID="userID"></mes-list>
        <div style="margin-left: 41%; margin-top: 8%" v-show="this.isNULL">
          <div><img src="../../assets/空.png" style=" width: 110px"></div>

        </div>
      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import RightBar from "../RightBar";
import MesSideBar from "./MesSideBar";
import MesList from "./MesList";
import axios from 'axios';

export default {
  name: "Message",
  components: { NavBar, RightBar, MesSideBar, MesList },
  data() {
    return {
      headUrl: require("@/assets/head.jpg"),
      // 全部消息
      // AllMess: [],
      NowMess: [],
      // UnReadMess: [],
      userID: 1,
      isNULL: true,
    };
  },
  methods: {
    // checkRead(mes) {
    //   return mes.isRead == 0;
    // },
    fetchList() {
      this.userL = JSON.parse(sessionStorage.getItem("userL"));
      this.userID = this.userL.userID;
      axios
        //  获取消息
        .post("/news/getNews", this.userID)
        .then((res) => {
          console.log(this.data);
          if (res.data == "") {
            this.isNULL = true;
          } else {
            this.isNULL = false;
            this.NowMess = res.data;
            console.log(this.NowMess);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created: function () {
    this.fetchList();
  },
};
</script>

<style>
.h2color {
  color: #3369e7;
}
.wu {
  position: absolute;
  left: 250px;
  height: 250px;
}
</style>
