<template>
  <div class="goods-item" @click="itemClick">
    <el-card class="box-card" shadow="always">
      <div style="float: right">
        <el-dropdown>
          <span class="el-dropdown-link">
            <i class="el-icon-setting el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <!-- <el-dropdown-item ><el-button type="text" @click="fav">收藏</el-button></el-dropdown-item> -->
            <el-dropdown-item>
              <el-button type="text" @click="open">删除</el-button>
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
      <!-- <img :src="TemItem.img" alt=""> -->
      <img class="mainImg" src="../assets/文档.svg" />

      <div class="goods-info">
        <p>{{TemItem.title}}</p>
      </div>
      <div class="goods-info">{{TemItem.dateTime}}</div>
    </el-card>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "DocListItem2",
  inject: ["reload"],
  data() {
    return {};
  },
  props: {
    TemItem: {
      type: Object,
      default() {
        return {};
      },
    },
    //当前界面
    currentview: {
      type: Number,
      default: 0,
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
        DocID: this.TemItem.docID,
        UserID: this.userID,
      };
      axios
        .post("http://127.0.0.1:8081/browse/insertBrowse", data)
        .then((res) => {
          var docL = res.data;
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
      this.$router.push("/detail/" + this.TemItem.docID);
    },
    // fav() {
    //   this.$confirm('此操作将收藏该文件, 是否继续?', '提示', {
    //     confirmButtonText: '确定',
    //     cancelButtonText: '取消',
    //     type: 'info'
    //   }).then(() => {
    //     this.$message({
    //       type: 'success',
    //       message: '收藏成功!'
    //     });
    //   }).catch(() => {
    //     this.$message({
    //       type: 'info',
    //       message: '已取消收藏'
    //     });
    //   });
    // },
    dlt() {
      if (this.currentview == 1) {
        let data = {
          DocID: this.TemItem.docID,
          UserID: this.userID,
        };
        axios
          .post("http://127.0.0.1:8081/browse/deleteBrowse", data)
          .then((res) => {
            var docL = res.data;
            console.log(res);
          })
          .catch((err) => {
            console.log(err);
          });
      } else if (this.currentview == 2) {
        let data = {
          DocID: this.TemItem.docID,
          UserID: this.userID,
        };
        axios
          .post("http://127.0.0.1:8081/collect/deleteCollect", data)
          .then((res) => {
            var docL = res.data;
            console.log(res);
          })
          .catch((err) => {
            console.log(err);
          });
      } else if (this.currentview == 3) {
        let data = {
          DocID: this.TemItem.docID,
          UserID: this.userID,
        };
        console.log(data);
        axios
          .post("http://127.0.0.1:8081/created/deleteDocument", data)
          .then((res) => {
            var docL = res.data;
            console.log(res);
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },
    open() {
      const h = this.$createElement;
      this.$msgbox({
        title: "提示",
        message: h("p", null, [
          h("span", null, "此操作将删除该文件, 是否继续?"),
        ]),
        showCancelButton: true,
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        beforeClose: (action, instance, done) => {
          if (action === "confirm") {
            instance.confirmButtonLoading = true;
            instance.confirmButtonText = "执行中...";
            setTimeout(() => {
              this.dlt();
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
  margin-right: 20px;
  position: relative;
  width: 220px;
  height: 220px;
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
}
</style>
