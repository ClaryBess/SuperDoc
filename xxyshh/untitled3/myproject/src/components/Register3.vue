<template>
  <el-container>
    <!-- 头部 -->
    <el-header>
      <NavBarOrigin>
      </NavBarOrigin>
    </el-header>
    <!-- 内容 -->
    <div id="color">
    <div class="main">
      <el-card class="box-card">

        <el-main>
          <!-- 标题 -->
          <div  class="title">
            <p>注册新账号</p>
          </div>
          <!-- 进度条 -->
          <div class="step">
            <el-progress :percentage="percentage" :color="customColorMethod"></el-progress><br/><br/>
            <el-steps  :active="3"  align-center>
              <el-step title="已完成"  description="注册账号"></el-step>
              <el-step title="已完成" description="填写信息"></el-step>
              <el-step title="进行中" description="注册成功"></el-step>
            </el-steps>
          </div>
          <!-- 内容 -->
          <div class="regform">
            <img src="../assets/ok.png" alt="">
            <h3> 注册成功</h3>
            <el-row >
              <router-link to="/Homepage" class="write">
                <el-button class="btn" round>
                  跳转个人主页
                </el-button>
              </router-link>
            </el-row>
          </div>
        </el-main>

      </el-card>
    </div>
    </div>
  </el-container>
</template>

<script>
  import NavBar from "./NavBar";
  import NavBarOrigin from "./NavBarOrigin";

  export default {
    name: "Register3",
    components: {
      NavBar,
      NavBarOrigin
    },
    data() {
      return {
        customColor: '#409eff',
        percentage: 100,
      };
    },
    methods: {
      customColorMethod(percentage) {
        if (percentage < 100) {
          return '#909399';
        } else {
          return '#3369e7';
        }
      }
    }
  }
</script>

<style scoped>
  #color{
    height: auto;
    background-color: #f1f8fa;
  }

  .main{
    width: 70%;
    margin: 2% auto;
  }

  .title{
    width: 100%;
  }

  .title p{
    float: left;
    font-size: 30px;
    color: #3369e7;
    font-weight: bold;
    margin-left: 50px;
  }

  h3{
    font-size: 30px;
    margin-top: -10px;
    margin-left: 10%;
    color:#3369e7;
  }

  .step{
    margin-top: 100px;
    margin-left: 5%;
    margin-right: 5%;
  }

  .regform{
    margin-top: 70px;
    margin-left: 42%;
    margin-right: 30%;
  }

  .btn{
    margin-left: 16px;
    margin-top: 10px;
    margin-bottom: 10px;
  }

</style>
