<template>
  <el-container >

    <el-header>
      <div  v-if="hasLogin">
        <NavBar :headSrc="headUrl">
        </NavBar>
      </div>
      <div v-else>
        <NavBarOrigin>
        </NavBarOrigin>
      </div>
      <vue-particles style="z-index: -1"
                  color="#9ddcff"
                  :particleOpacity="0.7"
                  :particlesNumber="80"
                  shapeType="circle"
                  :particleSize="4"
                  linesColor="#dedede"
                  :linesWidth="1"
                  :lineLinked="true"
                  :lineOpacity="0.4"
                  :linesDistance="150"
                  :moveSpeed="3"
                  :hoverEffect="true"
                  hoverMode="grab"
                  :clickEffect="true"
                  clickMode="push">
      </vue-particles>

    </el-header>

    <el-main>

      <div class="text"  style="z-index: 999; height: 500px" >
         <img  src="../assets/main.jpg" style="height:560px "  width="1000px" alt="">
      </div>
      <div style="margin-top: 120px">
        <el-carousel :interval="2900" type="card" height="550px" >
          <el-carousel-item label="1" :key="item">
            <img  src="../assets/pic1.jpg" width="800px" height="500px" alt="">
          </el-carousel-item>
          <el-carousel-item label="2" :key="item">
            <img  src="../assets/pic2.jpg" width="800px" height="500px" alt="">
          </el-carousel-item>
          <el-carousel-item label="3" :key="item">
            <img  src="../assets/pic3.jpg" width="800px" height="500px" alt="">
          </el-carousel-item>
          <el-carousel-item label="4" :key="item">
            <img  src="../assets/pic4.jpg" width="800px" height="500px" alt="">
          </el-carousel-item>
          <el-carousel-item label="5" :key="item">
            <img  src="../assets/pic5.jpg" width="800px" height="500px" alt="">
          </el-carousel-item>
          <el-carousel-item label="6" :key="item">
            <img src="../assets/pic6.jpg" width="800px" height="500px" alt="">
          </el-carousel-item>
        </el-carousel>
      </div>
    </el-main>

    <el-footer class="foot">
      <div style="margin-left:40%; color: #ffffff;line-height:35px;font-family: 'Hiragino Sans GB' ">
        ©2020 AiliGay小组<br/>
        &nbsp;   &nbsp;    &nbsp;   &nbsp;    小组成员<br/>
        &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;   小一<br/>
        &nbsp;   &nbsp;    &nbsp;   &nbsp;   &nbsp;   &nbsp;    小二<br/>
        &nbsp;   &nbsp;    &nbsp;   &nbsp;   &nbsp;   &nbsp;   小三<br/>
        &nbsp;   &nbsp;    &nbsp;   &nbsp;   &nbsp;   &nbsp;   小四<br/>
        &nbsp;   &nbsp;    &nbsp;   &nbsp;   &nbsp;   &nbsp;    小五<br/>
        &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;    小六<br/>
      </div>
    </el-footer>
    <div class="background" >
      <img :src="imgSrc" width="100%" height="100%" alt="" />
    </div>
    <el-backtop ><div style="color: #154a74">UP</div></el-backtop>
  </el-container>
</template>

<script>
  import NavBar from "./NavBar";
  import NavBarOrigin from "./NavBarOrigin";
  export default {
    name: "Welcome",
    components: {NavBar, NavBarOrigin},
    data(){
      return{
        headUrl: require('../assets/head.jpg'),
        hasLogin: false,
        imgSrc:require('../assets/bg2.jpg'),
        activeName: '1'
      }
    },
    methods: {
      handleChange(val) {
        console.log(val);
      }
    },
  }
</script>

<style scoped  >
  .foot{
    margin-top: 3%;
    padding: 3% 15% 22% 15%;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.7);
    z-index: 0;
  }
  .textfont{
    color: #2376ba;
    margin-left: 50px;
    margin-top: 20px;
  }
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
  .text{
    width:80%;
    margin-left: 50px;
    margin-top: 30px;
    padding-top: 5%;
    padding-bottom: 5%;
    padding-left: 10%;
    padding-right: 5%;
    box-shadow: 0 2px 12px 0 rgba(112, 112, 112, 0.2);
  }
  .background{
    width:100%;
    margin-top: 60px;
    height:1260px;  /**宽高100%是为了图片铺满屏幕 */
    z-index:-1;
    position: absolute;
    background-repeat: repeat-y;
    opacity: 0.6;
  }
  .el-carousel__item{
    height: 500px;
    box-shadow: 0 0px 8px 0 rgba(112, 112, 112, 0.6)
  }


</style>
