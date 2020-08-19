<template>
 <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px">
      <TemSideBar></TemSideBar>
      </el-aside>
      <el-main>
        <h2>模板库</h2>
        <tem-list :tems='temsList'></tem-list>
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
          title: '1111',
          picUrl: require("@/assets/预览图1.png")
        },
        {
          id: '2',
          title: '第二张图片',
          picUrl: require("@/assets/预览图1.png")
        },
        {
          id: '3',
          title: '3333',
          picUrl: require("@/assets/预览图1.png")
        },
        {
          id: '4',
          title: 'sisisisi',
          picUrl: require("@/assets/预览图1.png")
        },
        {
          id: '5',
          title: 'eeee',
          picUrl: require("@/assets/预览图1.png")
        },
      ]
    };
  },
}
</script>

<style scoped>
.h2color {
  color: #7093ff;
}
</style>
