// 创建者的页面
<template>
  <el-container>
    <!-- 头部 -->
    <el-header>
      <div>
        <nav-bar :headSrc="headUrl">
        </nav-bar>
      </div>
    </el-header>
    <!-- 内容 -->
    <el-container>
      <!-- 左栏 -->
      <el-aside width="15%">
        <team-side-bar1>
        </team-side-bar1>
      </el-aside>
      <!-- 中间 -->
      <el-main class="main">
        <!-- 团队简介 -->
        <el-card class="team-box-card" shadow="always">
          <div slot="header" class="clearfix">
            <span >
              <strong>团队简介</strong>
            </span>
            <!-- 修改简介 -->
            <el-popover
              placement="bottom"
              width="490"
              trigger="click"
              :visible.sync="dialog1"
              class="pop"
            >
              <div class="demo-drawer__content" v-if="changeinfo">
                <el-form :model="formInfo" ref="formInfo">
                  <el-form-item label=" 请修改团队简介：" class="drawer-item">
                    <el-input
                      type="textarea"
                      :rows="4"
                      style="margin-top: 10px"
                      v-model="formInfo.info"
                      autocomplete="off"
                    ></el-input>
                  </el-form-item>
                </el-form>

                <div class="demo-drawer__footer">

                  <el-button
                    type="primary"
                    @click="handleClose"
                    :loading="loading"
                    style="margin-left: 20%"
                  >
                    {{ loading ? '提交中 ...' : '确 定' }}
                  </el-button>
                </div>

              </div>
              <el-button style="float: right; padding: 3px 0" type="text" slot="reference" @click="changeinfo=true">修改简介</el-button>
            </el-popover>
          </div>

          <div class="text item">
            我们是非常专业的团队。美羊羊走中路的话输出不够，线上游走也来不及赶快，还是选欧阳修好，但是比起欧阳娜娜又有些许不足，要不还是选欧阳靖吧至少经济能压上还可以为羊村发展尽尽力。
          </div>
        </el-card>
        <!-- 团队成员 -->
        <div style="width: 880px">
          <!-- Leader -->
          <el-card style="width: 440px; height: 180px" class="team-box-card" shadow="always">
            <div slot="header" class="clearfix">
              <span>
                <strong>创建者</strong>
              </span>
            </div>
            <div class="leader-item">
              <!-- <member-list :members="teamMembers.id=1"></member-list> -->
              <MemberListItem :memberItem="teamMembers[0]">
                <h2 slot="deleteIcon"></h2>
              </MemberListItem>
            </div>
          </el-card>
          <!-- Member -->
          <el-card class="team-box-card" shadow="always">
            <div slot="header" class="clearfix">

              <span>
                <strong>成员</strong>
              </span>
              <!-- 添加成员 -->
              <el-popover
                placement="top"
                width="500"
                trigger="click"
                :visible.sync="dialog2"
                class="pop"
              >
                <div class="demo-drawer__content">
                  <el-form :model="formmember">
                    <el-form-item label=" 请输入用户ID：" class="drawer-item-menber">
                      <el-input placeholder="请输入ID" v-model="formmember.input3" class="input-with-select">
                        <el-button
                          slot="append"
                          type="primary"
                          @click="submitFormMember('formmember')"
                          icon="el-icon-search"
                        ></el-button>
                      </el-input>
                    </el-form-item>
                  </el-form>
                </div>
                <el-button style="float: right; padding: 3px 0" type="text" slot="reference">
                  添加成员
                </el-button>
              </el-popover>

            </div>
            <div class="member-item">
              <!-- :member=传入的团队成员 -->
              <!-- <member-list :members="teamMembers"></member-list> -->
              <member-list :members="teamMembers"></member-list>
            </div>
          </el-card>
        </div>
      </el-main>
      <!-- 右栏 -->
      <right-bar>
      </right-bar>
    </el-container>
    <!-- 回到顶部 -->
    <el-backtop>
    </el-backtop>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import TeamSideBar1 from "./TeamSideBar1";
import DocList from "../DocList";
import MemberList from "./MemberList";
import RightBar from "../RightBar";
import MemberListItem from "./MemberListItem";
import axios from "axios";

export default {
  name: "TeamView1",
  components: {
    NavBar,
    TeamSideBar1,
    DocList,
    MemberList,
    RightBar,
    MemberListItem
  },
  inject: ["reload"],
  data() {
    return {
      select: "",
      dialog1: false,
      dialog2: false,
      changeinfo: false,
      loading: false,
      headUrl: require("@/assets/head.jpg"),
      // team的id
      id: null,
      teamMembers: [
        {
          id: "1",
          name: "xxy",
        },
        {
          id: "2",
          name: "ljm",
        },
        {
          id: "3",
          name: "wsyshhshhshh",
        },
        {
          id: "4",
          name: "zbn",
        },
        {
          id: "5",
          name: "lzy",
        },
        {
          id: "6",
          name: "wzz",
        },
      ],
      formInfo: {
        info: "",
      },
      formmember: {
        input3:'',
      },
      timer: null,
    };
  },
  created() {
    //获取团队id
    this.id = this.$route.params.id;
    this.fetchUser();
    sessionStorage.setItem('teamL', JSON.stringify(this.$route.params.id));
  },
  methods: {
    fetchUser() {
      this.userL = JSON.parse(sessionStorage.getItem("userL"));
    },

    submitFormMember(formName) {
      const h = this.$createElement;
      this.$msgbox({
        title: "提示",
        message: h("p", null, [
          h("span", null, "确定修改团队简介吗?"),
        ]),
        showCancelButton: true,
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        beforeClose: (action, instance, done) => {
          if (action === "confirm") {
            instance.confirmButtonLoading = true;
            instance.confirmButtonText = "执行中...";
            setTimeout(() => {
              var _this = this;
              var userL=JSON.parse(sessionStorage.getItem("userL"))
              console.log(this.$route.params.id);
              axios
                .post("http://127.0.0.1:8081/#", {
                  userId: userL.userID,
                  teamId: this.$route.params.id,
                  memberId: _this.formmember.input3
                })
                .then((res) => {
                  console.log(res);
                })
                .catch((err) => {
                  console.log(err);
                });
              done();
              setTimeout(() => {
                instance.confirmButtonLoading = false;
                this.reload();
              }, 300);
            }, 1000);
          } else {
            done();
          }
        },
      })
        .then((action) => {
          this.$message({
            type: "info",
            message: "已发送邀请",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作",
          });
        });
    },

    handleClose() {
      const h = this.$createElement;
      this.$msgbox({
        title: "提示",
        message: h("p", null, [
          h("span", null, "确定修改团队简介吗?"),
        ]),
        showCancelButton: true,
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        beforeClose: (action, instance, done) => {
          if (action === "confirm") {
            instance.confirmButtonLoading = true;
            instance.confirmButtonText = "执行中...";
            setTimeout(() => {
              var _this = this;
              var userL=JSON.parse(sessionStorage.getItem("userL"))
              console.log(this.$route.params.id);
              axios
                .post("http://127.0.0.1:8081/#", {
                  userId: userL.userID,
                  teamId: this.$route.params.id,
                  teamInfo: _this.formInfo.info
              })
                .then((res) => {
                  console.log(res);
                })
                .catch((err) => {
                  console.log(err);
                });
              done();
              setTimeout(() => {
                instance.confirmButtonLoading = false;
                this.reload();
              }, 300);
            }, 1000);
          } else {
            done();
          }
        },
      })
        .then((action) => {
          this.$message({
            type: "info",
            message: "已成功修改",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作",
          });
        });
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
};
</script>

<style scoped>
  span{
    font-size: 17px;
  }

  .main{
    width: 80%;
  }

  .pop{
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.9);
  }

  .text {
    font-size: 14px;
  }

  .item {
    margin: 15px 13px;
  }

  .leader-item {
    margin-left: 18px;
    margin-bottom: 1px;
  }

  .member-item {
    margin-left: 18px;
    margin-bottom: 1px;
  }

  .clearfix:before,

  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both;
  }

  .team-box-card {
    margin-top: 50px;
    margin-left: 50px;
    margin-bottom: 10px;
    width: 880px;
  }

  .demo-drawer__content {
    width: 85%;
    margin: auto;
  }

  .drawer-item {
    margin-bottom: 30px;
    margin-top: 10px;
    font-weight: bold;
  }

  .drawer-item-menber {
    margin-bottom: 50px;
    margin-top: 15px;
    font-weight: bold;
  }

  .demo-drawer__footer {
    margin-bottom: 20px;
    margin-left: 27%;
  }

  .el-select .el-input {
    width: 120px;
  }

  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }

</style>
