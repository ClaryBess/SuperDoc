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
        <delete-all style="float:right;margin-top:40px;margin-right=40px"></delete-all>
        <h2 class="h2color">回收站</h2>
        <!-- <doc-list :docs="recycleDocs"></doc-list> -->
        <doc-list :docs="Docs"></doc-list>
      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "../components/NavBar";
import SideBar from "./SideBar";
import DocList from "./DocList";
import RightBar from "./RightBar";
import DeleteAll from "./DeleteAll";

export default {
  name: "Recycle",
  components: {
    NavBar,
    SideBar,
    DocList,
    RightBar,
    DeleteAll,
  },
  data() {
    return {
      headUrl: require("../assets/head.jpg"),
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
          title: "sisisi",
        },
      ],
    };
  },
};
</script>
<style>
.h2color {
  color: #7093ff;
}
</style>
