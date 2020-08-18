<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
        <mes-side-bar @unReadMes="handleUnReadMes" @allMes="handleAllMes"></mes-side-bar>
      </el-aside>
      <el-main style="width: 80%">
        <h2 class="h2color">消息界面</h2>
        <!-- 获取的消息列表 -->
        <mes-list :mess="NowMess" :userID="userID"></mes-list>
        <div v-show="this.isNULL" class="wu">
          <h1>您还没有收到的消息呢~~~</h1>
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
      AllMess: [
        {
          id: "1",
          content: "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
          isRead: true,
          type: "invitation",
          date: "2020/1/1 01:11",
        },
        {
          id: "2",
          content: "不许笑",
          isRead: false,
          type: "invitation",
          date: "2020/1/1 11:11",
        },
        {
          id: "3",
          content: "wwwwwww",
          isRead: false,
          type: "common",
          date: "2020/1/1 21:22",
        },
        {
          id: "4",
          content: "要加入我们嘛！",
          isRead: true,
          type: "invitation",
          date: "2020/1/1 01:11",
        },
      ],
      NowMess: [],
      UnReadMess: [],
      userID: 1,
      isNULL:false
    };
  },
  methods: {
    checkRead(mes) {
      return mes.isRead == false;
    },
    handleUnReadMes() {
      // 切换未读消息
      this.NowMess = this.UnReadMess;
    },
    handleAllMes() {
      //切换全部消息
      this.NowMess = this.AllMess;
    },
    fetchList() {
      this.userL = JSON.parse(sessionStorage.getItem("userL"));
      this.userID = this.userL.userID;
      axios
        //  获取消息
        .post("http://127.0.0.1:8081/browse/getBrowse", this.userID)
        .then((res) => {
          console.log(res);
          if (res.data == "") {
            this.isNULL = true;
          } else {
            this.isNULL = false;
            this.AllMess = res.data;
            console.log(this.AllMess);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created: function () {
    this.fetchList();
    this.NowMess = this.AllMess;
    this.UnReadMess = this.AllMess.filter(this.checkRead);
  },
};
</script>

<style>
.h2color {
  color: #3369e7;
}
.wu {
  position: absolute;
  left:250px;
  height: 250px;
}
</style>
