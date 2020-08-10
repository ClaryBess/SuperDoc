<template>
    <el-container>
      <el-header>
        <div  v-if="hasLogin">
          <NavBar :headSrc="headUrl">
          </NavBar>
        </div>
        <div v-else>
          <NavBarOrigin>
          </NavBarOrigin>
        </div>
      </el-header>
      <div class="main">
        <el-main>
          <div class="main-left">
            <el-carousel indicator-position="outside">
              <el-carousel-item v-for="item in 4" :key="item">
                <h3>{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>
          <div class="main-right">
            <img src="../assets/index-right.png" width=350 alt="">
          </div>
        </el-main>
      </div>
    </el-container>
</template>

<script>
    import NavBar from "./NavBar";
    import NavBarOrigin from "./NavBarOrigin";
    export default {
      name: "Home",
      components: {NavBar, NavBarOrigin},
      data(){
        return{
          headUrl: require('../assets/head.jpg'),
          hasLogin: false
        }
      }
    }
</script>

<style scoped>
  .userhead {
    width: 40px;
    height: 40px;
    border: 1px solid #ddd;
    border-radius: 50%;
  }
  .main{
    width: 100%;
    margin-top: 20px;
  }
  .main-left{
  float: left;
  width: 60%;
  margin-left: 7%;
}
  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
    z-index: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
    z-index: -1;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
    z-index: -1;
  }

  .main-right{
    float: left;
    margin-left: 3%;
    width: 25%;
  }
</style>
