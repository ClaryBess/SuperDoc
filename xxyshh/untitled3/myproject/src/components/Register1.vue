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
          <el-steps  :active="0" finish-status="success" align-center>
            <el-step title="进行中" description="注册账号"></el-step>
            <el-step title="未完成" description="填写信息"></el-step>
            <el-step title="未完成" description="注册成功"></el-step>
          </el-steps>
        </div>
      </el-main>
    </div>
  </el-container>
</template>

<script>
    import NavBar from "./NavBar";
    import NavBarOrigin from "./NavBarOrigin";

    export default {
        name: "Register1",
      components: {NavBar, NavBarOrigin},
      data(){
          return{
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
  .step{
    margin-top: 100px;
    margin-left: 5%;
    margin-right: 5%;
  }
</style>
