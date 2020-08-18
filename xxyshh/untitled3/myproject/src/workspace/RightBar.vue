<template>
  <div class="rightBar">
    <el-button
      size="small"
      type="primary"
      style="margin-bottom: 18px;margin-left: 2px"
      @click="newDoc"
    >
      新建文档
      <i class="el-icon-edit el-icon--right"></i>
    </el-button>
    <el-button size="small" type="primary" @click="intoTemLib">
      模板库
      <i class="el-icon-link el-icon--right"></i>
    </el-button>
  </div>
</template>

<script>
export default {
  name: "RightBar",
  methods: {
    newDoc() {
      this.$router.push("/Edit");
    },
    intoTemLib() {
      this.$router.push("/temlib");
    },
  },
};
</script>

<style scoped>
.rightBar {
  width: 5%;
  float: right;
  margin-right: 80px;
  margin-top: 60px;
}
</style>
