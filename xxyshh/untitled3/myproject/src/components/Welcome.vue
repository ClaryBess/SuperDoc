<template>
  <el-container >
    <!-- 头部 -->
    <el-header >
      <!-- 导航栏 -->
      <div  v-if="hasLogin">
        <NavBar :headSrc="headUrl">
        </NavBar>
      </div>
      <div v-else>
        <NavBarOrigin>
        </NavBarOrigin>
      </div>
      <!-- 点点点 -->
      <vue-particles style="z-index: -1"
                  color="#002080"
                  :particleOpacity="0.3"
                  :particlesNumber="80"
                  shapeType="polygon"
                  :particleSize="3"
                  linesColor="#dedede"
                  :linesWidth="2"
                  :lineLinked="true"
                  :lineOpacity="0.4"
                  :linesDistance="150"
                  :moveSpeed="2"
                  :hoverEffect="true"
                  hoverMode="grab"
                  :clickEffect="true"
                  clickMode="push">
      </vue-particles>
    </el-header>
    <!-- 内容 -->
    <el-main>
      <!-- 大图片 -->
      <div class="img2" >
         <img class="bgimg" width="80%" src="../assets/main.jpg"  alt="">
      </div>
      <!-- 走马灯 -->
      <div class="carousel">
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
    <!-- 尾部 -->
    <el-footer class="foot">
      <div class="footInfo">
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
    <!-- 背景 -->
    <div class="background" >
      <img :src="imgSrc" width="100%" height="100%" alt="" />
    </div>
    <!-- 回到顶部 -->
    <el-backtop ></el-backtop>
  </el-container>
</template>

<script>
  import NavBar from "./NavBar";
  import NavBarOrigin from "./NavBarOrigin";

  export default {
    name: "Welcome",
    components: {
      NavBar,
      NavBarOrigin
    },
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

  .cover {
    z-index: 999;
    height: 600px;
    width:80%;
    margin-left: 10%;
    margin-top: 30px;
    position: relative;
    overflow: hidden;
    position:relative;
  }

  .cover:after{
    position:absolute;
    content:'';
    width:100%;
    height:100%;
    top:0;
    left:0;
    box-shadow:0 0 30px 10px rgba(255,255,255,.7) inset;
  }

  .el-carousel__item{
    height: 500px;
    box-shadow: 0 0px 8px 0 rgba(112, 112, 112, 0.6)
  }

  .img2 {
    z-index: 999;
    height: 500px;
    width:80%;
    margin-left: 20%;
    position: relative;
  }

  .bgimg{
    display: block;
  }

  .carousel{
    margin-top: 120px;
  }

  .foot{
    margin-top: 3%;
    padding: 3% 15% 22% 15%;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.7);
    z-index: 0;
  }

  .footInfo{
    margin-left:40%;
    color: #ffffff;
    line-height:35px;
    font-family: 'Hiragino Sans GB';
  }

  .background{
    width:100%;
    margin-top: 60px;
    height:1100px;  /**宽高100%是为了图片铺满屏幕 */
    z-index:-1;
    position: absolute;
    background-repeat: repeat-y;
    opacity: 0.6;
  }
</style>
