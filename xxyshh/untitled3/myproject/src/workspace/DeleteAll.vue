<template>
  <el-button type="text" @click="open">全部删除</el-button>
</template>

<script>
import axios from "axios";

export default {
  name: "DeleteAll",
  inject: ["reload"],
  props: {
    //当前用户id
    userID: {
      type: Number,
      default: 0,
    },
  },
  methods: {
    open() {
      const h = this.$createElement;
      this.$msgbox({
        title: "提示",
        message: h("p", null, [
          h("span", null, "此操作将永久删除回收站中全部文件, 是否继续?"),
        ]),
        showCancelButton: true,
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        beforeClose: (action, instance, done) => {
          if (action === "confirm") {
            instance.confirmButtonLoading = true;
            instance.confirmButtonText = "执行中...";
            setTimeout(() => {
              axios
                .post("http://127.0.0.1:8081/recycle/deleteAll", this.userID)
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
            message: "已成功删除",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
  },
};
</script>

<style>
</style>
