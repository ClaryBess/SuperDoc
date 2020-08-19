<template>
 <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-main>
        <el-page-header @back="goBack" content="模板库"></el-page-header>
        <div class="tips-container">
          <div class="tips">
            <p>在“模板库”中，您可以在下方选择需要的模板，快速创建文档</p>
            <p>当然，您也可以返回后直接选择“新建文档”来建立空白文档</p>
          </div>
        </div>
        <div class="body">
          <tem-list :tems='temsList'></tem-list>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import TemSideBar from "./TemSideBar";
import TemList from "./TemList";

export default {
  name: 'TemLib',
  components: { NavBar,TemSideBar,TemList },
  data() {
    return {
      headUrl: require("@/assets/head.jpg"),
      temsList: [
        {
          id: '1',
          title: '员工手册',
          picUrl: require("@/assets/员工手册.png")
        },
        {
          id: '2',
          title: '劳动合同',
          picUrl: require("@/assets/员工合同.png")
        },
        {
          id: '3',
          title: '房屋租赁合同',
          picUrl: require("@/assets/房屋出租合同.png")
        },
        {
          id: '4',
          title: '个人年终总结',
          picUrl: require("@/assets/个人年终总结.png")
        },
        {
          id: '5',
          title: '推荐信',
          picUrl: require("@/assets/推荐信.png")
        },
      ]
    };
  },
  methods: {
    goBack() {
      this.$router.go(-1)
    },
  }
}
</script>

<style scoped>
.h2color {
  color: #7093ff;
}
  .body{
    width: 90%;
    margin-left: 6%;
  }
.tips{
  border-radius: 5px;
  background: RGB(236,248,255);
  padding: 20px;
  margin-bottom: 20px;
  border: 5px solid RGB(236,248,255);
  border-left-color: RGB(80, 191, 255);
}
  .tips-container{
    width: 82%;
    margin-left: 9%;
    margin-top: 40px;
  }
  .tips p{
    margin: 5px;
  }
</style>
