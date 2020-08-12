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
              <div>
                <el-form>
                  <el-row>
                    <el-col span="2"><img :src="headSrc" class="commentHead"> </el-col>
                    <el-col span="22">
                      <el-form-item>
                        <el-input
                          type="textarea"
                          :autosize="{ minRows: 3}"
                          placeholder="请输入内容"
                          v-model="comment" class="te"  @click.native="show3 = true">
                        </el-input>
                      </el-form-item></el-col>
                  </el-row>
                  <el-collapse-transition>
                    <div v-show="show3">
                      <el-row>
                        <el-col span="24">
                          <el-button type="primary" style="float: right" size="small" icon="el-icon-edit" round>提交</el-button>
                        </el-col>
                      </el-row>
                    </div>
                  </el-collapse-transition>
                </el-form>
              </div>
            </el-card>
            <el-card style="margin-top: 20px" shadow="hover">
              <div style="font-size: 20px; margin-bottom: 40px; margin-left: 7px">
                <el-row>
                  <el-col span="1"><div class="tips"><p></p></div></el-col>
                  <el-col span="23" style="margin-top: 5px">评论</el-col>
                </el-row>
              </div>
              <el-row></el-row>
              <ul style="list-style: none;margin: 0; padding: 0;"">
                <li>
                  <div style="width: 100%;float: left">
                    <span style="width: 8.3%; float: left">
                      <img :src="headSrc" class="commentHead">
                    </span>
                    <span style="float: left" class="commentName">
                      YuanCZ
                    </span>
                  </div>
                  <p class="commentText">你用两个脑子思考？</p>

                  <div style="width: 100%" class="commentTime">
                    <div style="margin-left: 8.3%">
                      <p>我是时间</p>
                    </div>
                  </div>
                  <el-divider></el-divider>
                </li>
                <li>
                  <div style="width: 100%;float: left">
                    <span style="width: 8.3%; float: left">
                      <img :src="headSrc" class="commentHead">
                    </span>
                    <span style="float: left" class="commentName">
                      YuanCZ
                    </span>
                  </div>
                  <p class="commentText">你用两个脑子思考？</p>
                  <div style="width: 100%" class="commentTime">
                    <div style="margin-left: 8.3%">
                      <p>我是时间</p>
                    </div>
                  </div>
                  <el-divider></el-divider>
                </li>
              </ul>
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
              <div style="text-align: center">
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
            show3: false,
            comment: '',
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
            short_url: 'www.wsynb.com',
            headSrc: require("../assets/head.jpg")
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
          this.$router.push("/change");
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

<style>
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
  .commentHead {
    width: 40px;
    height: 40px;
    border: 1px solid #ddd;
    border-radius: 50%;
  }
  .te .el-textarea__inner{
    font-size: 16px;
    color: #333333!important;
    font-family: "Microsoft YaHei", "微软雅黑", Arial, sans-serif!important;
    line-height: 200%;
    background-color: #FAFAFA;
  }
  .tips{
    border-radius: 5px;
    padding: 5px;
    border: 3px solid white;
    border-left-color: RGB(80, 191, 255);
  }
  .commentTime{
    font-size: 14px;
    color: #969696;
    margin-top: 10px;
  }
  .commentName{
    float: left;
    margin-top: 10px;
    color: #409EFF;
  }
  .commentText{
    margin-left: 8.3%;
  }

</style>
