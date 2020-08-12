<template>
    <el-container>
      <el-header>
        <NavBar></NavBar>
      </el-header>
      <el-main>
        <el-page-header @back="goBack" content="我是文档标题"></el-page-header>
        <div class="main-part">
          <div class="doc">
            <el-card :body-style="{padding:'0px'}">
              <div style="padding: 50px">
                <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
                <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
                <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
                <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
                <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
                <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
                <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
                <p>熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给熊老八喜欢吃奥利给</p>
              </div>
            </el-card>
            <el-card style="margin-top: 20px" shadow="hover">
              123
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
            <el-card shadow="hover" style="margin-top: 20px; margin-bottom: 20px">
              <div slot="header">
                编辑记录
                <i class="iconfont iconsuggest"@click="EditDoc" style="float: right;color:#409EFF ">编辑文档</i>
              </div>
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
            <el-card shadow="hover" id="fixedCard" :class="{'isFixed':fixed}">
              <p style="font-size: 13px;">喜欢本文？点击
                <span style="color: #409EFF; margin-right: 2px">复制链接</span>分享给好友：</p>
              <el-input v-model="short_url" size="small" style="width: 50%;"></el-input>
              <el-button v-if="short_url" class="copy" size="small" @click="CopyUrl" type="primary" plain>复制链接</el-button>
              <div >
                <div style="font-size: 13px;margin-top: 30px; margin-bottom: 10px">您也可以：
                  <el-button type="primary" size="mini" icon="el-icon-star-off" round="true">收藏本文</el-button>
                </div>
              </div>

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
            }],
            offsetTop:0,
            offsetWidth:0,
            colWidth:0,
            fixed:false,
            short_url: 'www.wsynb.com'
          }
      },
      mounted(){

        //对整个页面滚轮进行监听，每发生一次滚轮事件，执行一次方法
        window.addEventListener('scroll',this.initHeight);

        //对浏览器窗口大小触发事件进行监听
        window.onresize = () =>{
          //宽度借用,赋值
          this.colWidth = document.getElementById("colWidth").offsetWidth;
          this.offsetWidth = this.colWidth-15;
          document.getElementById("fixedCard").style.width = this.offsetWidth+'px'
        }

        // DOM异步更新 对未来更新后的视图进行操作 在更新后执行
        this.$nextTick(()=>{
          //获取到达页面顶端的值
          var height = document.getElementById("fixedCard")
          this.offsetTop = height.offsetTop+60;
          //获取宽度
          this.offsetWidth = height.offsetWidth;
          console.log(1)
        })
      },
      destroyed(){
        //移除监听
        window.removeEventListener('scroll',this.initHeight);
      },
      methods: {
        goBack() {
          console.log('go back');
        },
        EditDoc() {
          this.$router.push("change");
        },
        initHeight(){
          //兼容性，获取页面滚动距离
          var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
          //判断滚动距离是否大于元素到顶端距离
          this.fixed = scrollTop>this.offsetTop?true:false;
          //宽度赋值
          document.getElementById("fixedCard").style.width = this.offsetWidth+'px'
        },
        CopyUrl(data){
          var oInput = document.createElement("input");
          oInput.value = this.$data.short_url;
          document.body.appendChild(oInput);
          oInput.select(); // 选择对象
          document.execCommand("Copy"); // 执行浏览器复制命令
          oInput.className = "oInput";
          oInput.style.display = "none";
          this.$message({
            message:"复制成功!",
            type:'success'
          })
        },
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
  .edit-bottom{
    color: #409EFF;
    font-size: 10px;
  }
  .isFixed{
    position: fixed;
    top: 0;
  }
</style>
