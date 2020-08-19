<template>
  <div class="docs">
    <div class="docs-item">
      <img class="docimg" src="../assets/文档.svg" @click="itemClick" />
      <div class="docs-info" @click="itemClick">
        <p>{{this.docsItem.title}}</p>
      </div>
      <div class="docs-time" @click="itemClick">
        <p>{{this.docsItem.dateTime}}</p>
      </div>
      <slot name="deleteIcon">
        <img class="smallimg1" src="../assets/删除.svg" @click="open" />
      </slot>
      <!-- <slot name="collectedIcon">
        <img class="smallimg2" :src="collectedurl" alt @click="collectDoc" />
      </slot>-->
    </div>
  </div>
</template>

<script>
// import img1 from "../assets/收藏.svg";
// import img2 from "../assets/收藏 (1).svg";
import axios from "axios";

export default {
  name: "DocListItem",
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
    //当前团队id
    teamID: {
      type: Number,
      default: 0,
    },
  },
  // computed: {
  //   collectedurl: function () {
  //     if (this.docsItem.isCollected == false) {
  //       return img1;
  //     } else {
  //       return img2;
  //     }
  //   },
  // },
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
    // collectDoc() {
    //   this.docsItem.isCollected = !this.docsItem.isCollected;
    // },

    deleteDoc() {
      if (this.currentview == 1) {
        let data = {
          DocID: this.docsItem.docID,
          UserID: this.userID,
        };
        axios
          .post("/browse/deleteBrowse", data)
          .then((res) => {
            console.log(res)
          })
          .catch((err) => {
            console.log(err);
          });
      } else if (this.currentview == 2) {
        let data = {
          DocID: this.docsItem.docID,
          UserID: this.userID,
        };
        axios
          .post("/collect/deleteCollect", data)
          .then((res) => {
            console.log(res)
          })
          .catch((err) => {
            console.log(err);
          });
      } else if (this.currentview == 3) {
        let data = {
          DocID: this.docsItem.docID,
          UserID: this.userID,
        };
        axios
          .post("/created/deleteDocument", data)
          .then((res) => {
            console.log(res)
          })
          .catch((err) => {
            console.log(err);
          });
      } else if (this.currentview == 4) {
        //创建者团队文档
        console.log(this.teamID);
        console.log(this.docsItem.docID)
        axios
          .post("/team/deleteDoc/"+this.teamID, this.docsItem.docID)
          .then((res) => {
            console.log(res.data)
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
              this.deleteDoc();
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
/* .smallimg2 {
  position: absolute;
  right: 80px;
  width: 30px;
  padding-top: 20px;
  padding-right: 10px;
} */

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
.docs-time {
  font-size: 12px;
  position: absolute;
  right: 120px;
  padding-left: 0;
  padding-top: 10px;
  padding-bottom: 10px;
  padding-right: 20px;
  overflow: hidden;
  text-align: left;
}
</style>
