<template>
  <div id="SideBar">
    <el-row class="tac">
      <el-col>
        <h3>个人工作台</h3>
        <el-menu :default-active="currentindex" class="el-menu-vertical-demo">
          <el-menu-item index="1" @click="itemClick1">
            <span slot="title">最近浏览的文档</span>
          </el-menu-item>
          <el-menu-item index="2" @click="itemClick2">
            <span slot="title">收藏的文档</span>
          </el-menu-item>
          <el-menu-item index="3" @click="itemClick3">
            <span slot="title">自己创建的文档</span>
          </el-menu-item>
          <el-menu-item index="4" @click="itemClick4">
            <span slot="title">加入的团队</span>
          </el-menu-item>
          <el-menu-item index="5" @click="itemClick5">
            <span slot="title">回收站</span>
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
      this.$router.push("recently")
    },
    itemClick2() {
      this.$router.push("favourite")
    },
    itemClick3() {
      this.$router.push("created")
    },
    itemClick4() {
      this.$router.push("team")
    },
    itemClick5() {
      this.$router.push("recycle")
    },
  },
};
</script>