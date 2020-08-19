<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
      <SideBar  currentindex='3'></SideBar>
      </el-aside>
      <el-main style="width: 80%">

        <el-button class="switch"  type="text" @click="toMenu">
          <i class="el-icon-menu"></i>
        </el-button>
        <el-button class="switch" style="margin-right: -5px" type="text" @click="toList">
          <i class="el-icon-s-unfold"></i>
        </el-button>

        <h2 class="h2color">自己创建的文件</h2>
        <!-- <doc-list :docs="createdDocs"></doc-list> -->
        <doc-list v-show="showList"
        :docs="Docs"
        :currentview=3
        :userID="userID"
        ></doc-list>
         <doc-list2 v-show="showMenu"
        :tems="Docs"
        :currentview=3
        :userID="userID"
        ></doc-list2>
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
import DocList from "./DocList";
import DocList2 from "./DocList2";
import RightBar from "./RightBar";
import axios from 'axios';

export default {
  name: "Created",
  components: {NavBar, SideBar,DocList,DocList2,RightBar },
  data() {
    return {
      headUrl: require("../assets/head.jpg"),
      Docs: [],
      userID:1,
      showMenu:false,
      showList:true,
      isNULL:true
    };
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
    fetchList() {
      this.userL = JSON.parse(sessionStorage.getItem("userL"));
      this.userID=this.userL.userID;
      axios
        .post("/created/getDocument", this.userID)
        .then(res=>{
          if(res.data == ""){
            this.isNULL=true;
          }
          else{
            this.isNULL=false
            var docL = res.data;
            var _this = this;
            _this.Docs=docL;
          }
        })
        .catch(err=> {
          console.log(err);
        });
    }
  },
  created() {
    this.fetchList();
  },

};
</script>

<style>
  .h2color {
    color: #3369e7;
  }
  .switch{
    width: 40px;
    float: right;
    margin-top:27px;
    margin-right: 30px;
  }


</style>
