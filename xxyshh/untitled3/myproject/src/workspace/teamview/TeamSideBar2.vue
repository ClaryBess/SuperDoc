<template>
  <div id="TeamSideBar2" style="margin-left: 30px">
    <el-row class="tac">
      <el-col>
        <div style="font-size: 14px;margin-top: 25px;margin-bottom: 30px">
          <span style="font-size: 19px"><strong>团队界面</strong></span>
          <el-divider direction="vertical"></el-divider>
          <span>成员</span>
        </div>
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
