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
    </el-header>

    <div style="margin-top: 20px">
      <el-carousel :interval="2900" type="card" height="600px" >
        <el-carousel-item label="1" :key="item">
          <img style="margin-top: 7%;" src="../assets/pic1.jpg" width="800px" height="500px" alt="">
        </el-carousel-item>
        <el-carousel-item label="2" :key="item">
          <img style="margin-top: 7%;" src="../assets/pic2.jpg" width="800px" height="500px" alt="">
        </el-carousel-item>
        <el-carousel-item label="3" :key="item">
          <img style="margin-top: 7%;" src="../assets/pic3.jpg" width="800px" height="500px" alt="">
        </el-carousel-item>
        <el-carousel-item label="4" :key="item">
          <img style="margin-top: 7%;" src="../assets/pic4.jpg" width="800px" height="500px" alt="">
        </el-carousel-item>
        <el-carousel-item label="5" :key="item">
          <img style="margin-top: 7%;" src="../assets/pic5.jpg" width="800px" height="500px" alt="">
        </el-carousel-item>
        <el-carousel-item label="6" :key="item">
          <img style="margin-top: 7%;" src="../assets/pic6.jpg" width="800px" height="500px" alt="">
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="text" >
      <el-collapse v-model="activeName" @change="handleChange"  >
        <el-collapse-item title=" 在线编辑 Online" name="1"  >
          <div class="textfont">多人在线协作编辑文档，告别通过邮件、IM 软件多次传输文件的繁复</div>
          <div class="textfont">毫秒级实时多端同步，随时随地开展工作，满足多场景办公使用需求</div>
          <div class="textfont">文档编辑历史自动保存，可随时追溯查看，还可一键还原到任一历史版本</div>
        </el-collapse-item>
        <el-collapse-item title=" 历史记录 History" name="2" >
          <div class="textfont">随机记录文档的增删改记录，妈妈再也不担心我误操作了😊</div>
          <div class="textfont">全过程可留痕，全流程可追溯，保障团队文档安全</div>
        </el-collapse-item>
        <el-collapse-item title=" 高效办公 Efficiency" name="3" >
          <div class="textfont">颠覆传统办公模式，开启企业高效办公时代</div>
          <div class="textfont">灵活多样的部署方式，满足各规模企业的定制化需求</div>
          <div class="textfont">即写即存、轻松查找、便捷共享，更高效的内部知识库</div>
        </el-collapse-item>
        <el-collapse-item title=" 团队协作 Cooperation" name="4" >
          <div class="textfont">可针对全员，设置导出、复制、分享的权限</div>
          <div class="textfont">创建者对团队进行调整的能力，例如管理成员、解散团队、设置文档权限</div>
          <div class="textfont">非创建者有对应的加入、退出团队等功能</div>
        </el-collapse-item>
      </el-collapse>
    </div>
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
        activeNames: ['1']
      }
    },
    methods: {
      handleChange(val) {
        console.log(val);
      }
    }
  }
</script>

<style scoped>
  .foot{
    margin-top: 15%;
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
    width: 65%;
    margin-left: 8%;
    margin-top: 5%;
    padding-top: 5%;
    padding-bottom: 5%;
    padding-left: 10%;
    padding-right: 10%;
    box-shadow: 0 2px 12px 0 rgba(112, 112, 112, 0.6)
  }
  .background{
    width:100%;
    margin-top: 60px;
    height:1640px;  /**宽高100%是为了图片铺满屏幕 */
    z-index:-1;
    position: absolute;
    background-repeat: repeat-y;
    opacity: 0.6;
  }
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

</style>
