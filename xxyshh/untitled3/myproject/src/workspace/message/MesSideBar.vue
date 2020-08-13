<template>
  <div id="SideBar">
    <el-row class="tac" style="margin-left: 30px">
      <el-col>
        <h3>个人工作台</h3>
        <el-menu :default-active="currentindex" class="el-menu-vertical-demo">
          <el-menu-item index="1" @click="itemClick1">
            <span slot="title">未读消息</span>
          </el-menu-item>
          <el-menu-item index="2" @click="itemClick2">
            <span slot="title">全部消息</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "SideBar",
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
      console.log('未读消息')
    },
    itemClick2() {
      console.log('全部消息')
      // this.$router.push("favourite")
    }
  },
};
</script>
