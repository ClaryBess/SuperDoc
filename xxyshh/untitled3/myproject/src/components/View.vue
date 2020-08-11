<template>
    <el-container>
      <el-header>
        <NavBar></NavBar>
      </el-header>
      <el-main>
        <el-page-header @back="goBack" content="我是文档标题"></el-page-header>
        <div class="main-part">
          <div class="doc">
            <el-card :body-style="{padding:'50px'}">
              <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
              <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
              <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
              <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>

            </el-card>
          </div>
          <div class="right-col">
            <el-card shadow="hover" class="up-card">
              <el-row>
                <div style="float: left"><i class="iconfont iconCustomermanagement"></i>团队：</div>
                <div style="color: #409EFF;float: left">Aligay</div>
              </el-row>
              <el-row>
                <div style="float: left"><i class="iconfont iconpin"></i>作者：</div>
                <div style="color: #409EFF;float: left">xxyshh</div>
              </el-row>
              <el-row><div style="float: left"><i class="iconfont iconcomments"></i>评论数：</div>
                <div style="color: #409EFF;float: left">2</div>
              </el-row>
              <el-row><div style="float: left"><i class="iconfont iconfavorites"></i>收藏数：</div>
                <div style="color: #409EFF;float: left">10</div>
              </el-row>
            </el-card>
            <el-card shadow="hover" style="margin-top: 20px" header="编辑记录">
              <el-timeline reverse="true">
                <el-timeline-item
                  v-for="(activity, index) in activities"
                  :key="index"
                  :timestamp="activity.timestamp"
                  color="#409EFF">
                  {{activity.content}}
                </el-timeline-item>
              </el-timeline>
            </el-card>
          </div>
        </div>
      </el-main>
    </el-container>
</template>

<script>
    import NavBar from "./NavBar";

    export default {
        name: "View",
      components: {NavBar},
      data(){
          return{
            activities: [{
              content: 'wsy',
              timestamp: '2020-04-15'
            }, {
              content: '王奶糖',
              timestamp: '2020-04-13'
            }, {
              content: '王咪咪',
              timestamp: '2020-04-11'
            }]
          }
      },
      methods: {
        goBack() {
          console.log('go back');
        }
      }
    }
</script>

<style scoped>
  .main-part{
    width: 90%;
    margin-left: 5%;
    margin-top: 20px;
  }
  .doc{
    float: left;
    width: 70%;
  }
  .right-col{
    float: right;
    width: 25%;
  }
  .up-card{
    line-height: 200%;
    color: #333333;
  }
</style>
