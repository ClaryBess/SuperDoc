<template>
  <div id="TeamSideBar1" style="margin-left: 30px">
    <el-row class="tac">
      <el-col>
        <div style="font-size: 14px;margin-top: 25px;margin-bottom: 30px">
        <span style="font-size: 19px"><strong>团队界面</strong></span>
        <el-divider direction="vertical"></el-divider>
        <span>创建者</span>
        </div>
        <el-menu :default-active="currentindex" class="el-menu-vertical-demo">
          <el-menu-item index="1" @click="itemClick1">
            <span slot="title">团队信息</span>
          </el-menu-item>
          <el-menu-item index="2" @click="itemClick2">
            <span slot="title">团队文档</span>
          </el-menu-item>
          <el-menu-item index="3" @click="itemClick3">
            <span slot="title">解散团队</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "TeamSideBar1",
  inject: ["reload"],
  data() {
    return {
    };
  },
  props: {
    currentindex: {
      type: String,
      default: '1'
    }
  },
  methods: {
    itemClick1() {
      this.$router.push("/teamleader/" + this.$route.params.id)
      console.log("团队信息")
    },
    itemClick2() {
      this.$router.push("/teamleader/teamdoc/"  + this.$route.params.id)
      console.log("团队文档")
    },
    itemClick3() {
      const h = this.$createElement;
      this.$msgbox({
        title: "提示",
        message: h("p", null, [
          h("span", null, "确定解散团队吗"),
        ]),
        showCancelButton: true,
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        beforeClose: (action, instance, done) => {
          if (action === "confirm") {
            instance.confirmButtonLoading = true;
            instance.confirmButtonText = "执行中...";
            setTimeout(() => {
              this.userL = JSON.parse(sessionStorage.getItem("userL"));
              this.userID=this.userL.userID;
              var _this=this;
              console.log(this.$route.params.id);
              console.log(this.userID);
              axios
                .post("http://127.0.0.1:8081/team/delete/" + this.$route.params.id)
                .then(function (response) {
                  if(response.data.status === 200){
                    _this.$router.push('/team')
                  }
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
            message: "已成功解散",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作",
          });
        });
    },
  },
};
</script>
