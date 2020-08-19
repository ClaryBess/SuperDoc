<template>
  <div class="goods-item" @click="itemClick">
    <el-card class="box-card" shadow="always">
      <div style="float: right">
        <el-dropdown>
          <span class="el-dropdown-link">
            <i class="el-icon-setting el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
              <el-button type="text" @click="back">恢复</el-button>
            </el-dropdown-item>
            <el-dropdown-item divided>
              <el-button type="text" @click="dlt">删除</el-button>
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
      <!-- <img :src="TemItem.img" alt=""> -->
      <img class="mainImg" src="../assets/文档.svg" />

      <div class="goods-info">
        <p>{{MenuItem.title}}</p>
      </div>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "MenuListItem",
  inject: ["reload"],
  data() {
    return {};
  },
  props: {
    MenuItem: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  methods: {
    itemClick() {
      let data = {
        DocID: this.MenuItem.docID,
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
      this.$router.push("/detail/" + this.MenuItem.docID);
    },
    back() {
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
                DocID: this.MenuItem.docID,
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
    dlt() {
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
                DocID: this.MenuItem.docID,
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
  },
};
</script>

<style scoped>
.el-dropdown-link {
  cursor: pointer;
  color: #3778ff;
}
.el-icon-arrow-down {
  font-size: 8px;
}
.goods-item {
  margin-top: 20px;
  margin-right: 38px;
  position: relative;
  width: 220px;
  height: 180px;
  margin-bottom: 10px;
}

.mainImg {
  width: 70px;
  border-radius: 20px;
  margin-left: 30%;
  margin-top: 8px;
}

.goods-info {
  font-size: 13px;
  position: relative;
  margin-top: 5px;
  left: 0;
  right: 0;
  overflow: hidden;
  text-align: center;
}

.goods-info p {
  font-size: 18px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-bottom: 2px;
  padding-bottom: -10px;
}
</style>
