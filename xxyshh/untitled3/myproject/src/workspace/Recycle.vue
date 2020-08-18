<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
        <SideBar currentindex="5"></SideBar>
      </el-aside>
      <el-main style="width: 80%">
        <el-button class="switch" type="text" @click="toMenu">
          <i class="el-icon-menu"></i>
        </el-button>
        <el-button class="switch" style="margin-right: -5px" type="text" @click="toList">
          <i class="el-icon-s-unfold"></i>
        </el-button>
        <delete-all class="switch" :userID="userID"></delete-all>

        <h2 class="h2color">回收站</h2>
        <!-- <doc-list :docs="recycleDocs"></doc-list> -->
        <delete-list v-show="showList" :docs="Docs" :userID="userID"></delete-list>
        <menu-list v-show="showMenu" :menus="Docs" :userID="userID" style="width: 100%"></menu-list>

        <div style="margin-left: 41%; margin-top: 8%" v-show="this.isNULL">
          <div><img src="../assets/空.png" style=" width: 110px"></div>

        </div>

      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "../components/NavBar";
import SideBar from "./SideBar";
import DeleteList from "./DeleteList";
import RightBar from "./RightBar";
import DeleteAll from "./DeleteAll";
import MenuList from "./MenuList";
import axios from "axios";

export default {
  name: "Recycle",
  components: {
    NavBar,
    SideBar,
    DeleteList,
    RightBar,
    DeleteAll,
    MenuList,
  },
  data() {
    return {
      headUrl: require("../assets/head.jpg"),
      Docs: [],
      userID: 1,
      showMenu: false,
      showList: true,
      isNULL: false,
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

    fetchList() {
      this.userL = JSON.parse(sessionStorage.getItem("userL"));
      console.log(this.userL);
      this.userID=this.userL.userID;
      axios
        .post("http://127.0.0.1:8081/recycle/getRecycle", this.userID)
        .then((res) => {
          console.log(res);
          if (res.data == "") {
            this.isNULL = true;
          } else {
            this.isNULL = false;
            var docL = res.data;
            var _this = this;
            _this.Docs = docL;
            console.log(_this.Docs);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created() {
    this.fetchList();
  },
};
</script>
<style scoped>
.h2color {
  color: #3369e7;
}
.switch {
  width: 40px;
  float: right;
  margin-top: 35px;
  margin-right: 40px;
}

</style>
