<template>
  <el-container>
    <el-header>
      <NavBarOrigin>
      </NavBarOrigin>
    </el-header>
    <div class="main">
      <el-main>
        <div  class="title">
          <p>注册新账号</p>
        </div>
        <div class="step">
          <el-progress :percentage="percentage" :color="customColorMethod"></el-progress><br/><br/>
          <el-steps  :active="2"  align-center>
            <el-step title="已完成"  description="注册账号"></el-step>
            <el-step title="已完成" description="填写信息"></el-step>
            <el-step title="进行中" description="注册成功"></el-step>
          </el-steps>
        </div>
        <div class="regform">
          <img src="../assets/ok.png" alt="">
          <h3> 注册成功</h3>
          <el-row >
            <router-link to="/Homepage" class="write">
              <el-button round>跳转个人主页</el-button>
            </router-link>
          </el-row>
        </div>
      </el-main>
    </div>
  </el-container>
</template>

<script>
  import NavBar from "./NavBar";
  import NavBarOrigin from "./NavBarOrigin";

  export default {
    name: "Register3",
    components: {NavBar, NavBarOrigin},
    data() {
      return {
        percentage: 100,
      };
    },
    methods: {
      customColorMethod(percentage) {
        if (percentage < 100) {
          return '#909399';
        } else {
          return '#409eff';
        }
      }
    }
  }
</script>

<style scoped>
  .main{
    width: 70%;
    margin: 0 auto;
  }
  .title{
    width: 100%;
  }
  .title p{
    float: left;
    font-size: 30px;
    color: #333333;
  }
  h3{
    font-size: 30px;
    margin-left: 2%;
    color: #409eff;
  }
  .step{
    margin-top: 100px;
    margin-left: 5%;
    margin-right: 5%;
  }
  .regform{
    margin-top: 70px;
    margin-left: 43%;
    margin-right: 30%;
  }
</style>
