<template>
  <div id="TeamSideBar1">
    <el-row class="tac">
      <el-col>
        <h3>创建者</h3>
        <el-menu :default-active="currentindex" class="el-menu-vertical-demo">
          <el-menu-item index="1" @click="itemClick1">
            <span slot="title">管理成员</span>
          </el-menu-item>
          <el-menu-item index="2" @click="itemClick2">
            <span slot="title">解散团队</span>
          </el-menu-item>
          <el-menu-item index="3" @click="itemClick3">
            <span slot="title">设置文档权限</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "TeamSideBar1",
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
      console.log("管理成员")
    },
    itemClick2() {
      console.log("解散团队")
    },
    itemClick3() {
      console.log("设置文档权限")
    },
  },
};
</script>