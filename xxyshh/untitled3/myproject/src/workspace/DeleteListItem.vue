<template>
  <div class="docs">
    <div class="docs-item">
      <img class="docimg" src="../assets/文档.svg" @click="itemClick" />
      <div class="docs-info" @click="itemClick">
        <p>{{docsItem.title}}</p>
      </div>
      <img class="smallimg1" src="../assets/删除.svg" @click="deleteDoc" />
      <img class="smallimg2" src="@/assets/恢复.svg" alt @click="recoverDoc" />
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "DeleteListItem",
  inject: ["reload"],
  data() {
    return {};
  },
  props: {
    docsItem: {
      type: Object,
      default() {
        return {};
      },
    },
    //当前用户id
    userID: {
      type: Number,
      default: 0,
    },
  },
  methods: {
    itemClick() {
      let data = {
        DocID: this.docsItem.docID,
        UserID: this.userID,
      };
      axios
        .post("/browse/insertBrowse", data)
        .then((res) => {
          var docL = res.data;
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
      this.$router.push("/detail/" + this.docsItem.docID);
    },
    deleteDoc() {
      const h = this.$createElement;
      this.$msgbox({
        title: "提示",
        message: h("p", null, [
          h("span", null, "此操作将彻底删除该文件, 是否继续?"),
        ]),
        showCancelButton: true,
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        beforeClose: (action, instance, done) => {
          if (action === "confirm") {
            instance.confirmButtonLoading = true;
            instance.confirmButtonText = "执行中...";
            setTimeout(() => {
              let data = {
                DocID: this.docsItem.docID,
                UserID: this.userID,
              };
              axios
                .post("/recycle/delete", data)
                .then((res) => {
                  var docL = res.data;
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
    recoverDoc() {
      const h = this.$createElement;
      this.$msgbox({
        title: "提示",
        message: h("p", null, [
          h("span", null, "此操作将恢复该文件, 是否继续?"),
        ]),
        showCancelButton: true,
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        beforeClose: (action, instance, done) => {
          if (action === "confirm") {
            instance.confirmButtonLoading = true;
            instance.confirmButtonText = "执行中...";
            setTimeout(() => {
              let data = {
                DocID: this.docsItem.docID,
                UserID: this.userID,
              };
              axios
                .post("/recycle/recover", data)
                .then((res) => {
                  var docL = res.data;
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
            message: "已成功恢复",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消恢复",
          });
        });
    },
  },
};
</script>

<style>
.docs {
  position: relative;
  padding: 10px;
}
.docs-item {
  display: flex;
  position: relative;
  border-radius: 20px;
  padding: 5px;
  background-color: #f4f7f8;
}

.docimg {
  width: 50px;
  padding: 10px;
}

.smallimg1 {
  position: absolute;
  right: 30px;
  width: 30px;
  padding-top: 20px;
  padding-right: 10px;
}
.smallimg2 {
  position: absolute;
  right: 80px;
  width: 30px;
  padding-top: 20px;
  padding-right: 10px;
}

.docs-info {
  font-size: 16px;
  position: relative;
  padding-left: 0;
  padding-top: 10px;
  padding-bottom: 10px;
  padding-right: 20px;
  overflow: hidden;
  text-align: left;
}

.docs-info p {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-bottom: 3px;
}
</style>
