<template>
  <div id="TeamSideBar2">
    <el-row class="tac">
      <el-col>
        <h3>创建者</h3>
        <el-menu :default-active="currentindex" class="el-menu-vertical-demo">
          <el-menu-item index="1" @click="itemClick1">
            <span slot="title">加入团队</span>
          </el-menu-item>
          <el-menu-item index="2" @click="itemClick2">
            <span slot="title">退出团队</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "TeamSideBar2",
  data() {
    return {
    };
  },
  props: {
    currentindex: {
      type: String,
      default: '1'
    }
  },
  methods: {
    itemClick1() {
      console.log("加入团队")
    },
    itemClick2() {
      console.log("退出团队")
    }
  },
};
</script>