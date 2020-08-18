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
      if(this.$route.name === 'teamview1' || this.$route.name === 'teamview2'){
        this.$router.push("/editTeam/" + this.$route.params.id + '/0');
      }
      else if(this.$route.name === 'teamdoc' || this.$route.name === 'teamdoc2'){
        this.$router.push("/editTeam/" + this.$route.params.id + '/0');
      }
      else{
        this.$router.push("/edit/0");
      }
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
