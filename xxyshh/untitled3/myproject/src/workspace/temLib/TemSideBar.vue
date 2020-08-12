<template>
  <div>
    <div id="TemSideBar">
      <el-row class="tac" style="margin-left: 30px">
        <el-col>
          <h3>模板库</h3>
          <el-menu :default-active="currentindex" class="el-menu-vertical-demo">
            <el-menu-item index="1" @click="itemClick1">
              <span slot="title">第一类</span>
            </el-menu-item>
            <el-menu-item index="2" @click="itemClick2">
              <span slot="title">第二类</span>
            </el-menu-item>
            <el-menu-item index="3" @click="itemClick3">
              <span slot="title">第三类</span>
            </el-menu-item>
            <el-menu-item index="4" @click="itemClick4">
              <span slot="title">第四类</span>
            </el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
export default {
  name: "TemSideBar",
  data() {
    return {
      tabPosition: "left",
    };
  },
  props: {
    currentindex: {
      type: String,
      default: 1,
    },
  },
  methods: {
    itemClick1() {
      this.$router.push("type1");
    },
    itemClick2() {
      this.$router.push("type2");
    },
    itemClick3() {
      this.$router.push("type3");
    },
    itemClick4() {
      this.$router.push("type4");
    },
  },
};
</script>