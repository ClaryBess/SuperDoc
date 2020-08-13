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
        <mes-list :mess="NowMess"></mes-list>
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
        },
        {
          id: "2",
          content: "不许笑",
          isRead: false,
        },
        {
          id: "3",
          content: "wwwwwww",
          isRead: false,
        },
        {
          id: "4",
          content: "要加入我们嘛！",
          isRead: true,
        },
      ],
      NowMess: [],
      UnReadMess: []
    };
  },
  created: function() {
    this.NowMess=this.AllMess
    this.UnReadMess=this.AllMess.filter(this.checkRead)
  },
  methods: {
    checkRead(mes) {
      return mes.isRead == false;
    },
    handleUnReadMes() {
      // 切换未读消息
      this.NowMess=this.UnReadMess
    },
    handleAllMes() {
      //切换全部消息
      this.NowMess=this.AllMess
    }
  },
};
</script>

<style>
.h2color {
  color: #7093ff;
}
</style>
