<template>
  <div class="docs">
    <div class="docs-item">
      <!-- 展示图片为成员头像 -->
      <!-- <img class="docimg" :src="memberItem.url" @click="itemClick"> -->
      <img class="docimg" :src='memberItem.profileUrl' @click="itemClick" />
      <div class="docs-info" @click="itemClick">
        <p>{{memberItem.userName}}</p>
      </div>
      <slot name="deleteIcon">
        <img class="smallimg1" src="@/assets/删除.svg" @click="deleteMem" />
      </slot>

    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "MemberListItem",
  inject:['reload'],
  data() {
    return {};
  },
  props: {
    memberItem: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  methods: {
    itemClick() {
      // 点击成员进入成员个人页面
      this.$router.push("/homepage");
    },
    deleteMem() {
      var _this=this;
      axios.post("http://127.0.0.1:8081/team/quit/" + this.$route.params.id, this.memberItem.userName)
        .then(function (response) {
          _this.$message({
            message: '已删除成员',
            type: 'success'
          });
          _this.reload();
        })
        .catch(function (error) { // 请求失败处理
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
.docs {
  position: relative;
  padding: 5px;
}
.docs-item {
  width: 320px;
  display: flex;
  position: relative;
  border-radius: 20px;
  margin-right: 60px;
  margin-bottom: 22px;
  padding: 1px;
  background-color: #f4f7f8;
}

.docimg {
  width: 50px;
  padding: 10px;
  border-radius: 25px;
}

.smallimg1 {
  position: absolute;
  right: 10px;
  width: 30px;
  padding-top: 20px;
  padding-right: 10px;
}
.smallimg2 {
  position: absolute;
  right: 50px;
  width: 30px;
  padding-top: 20px;
  padding-right: 10px;
}

.docs-info {
  font-size: 16px;
  position: relative;
  padding-left: 8px;
  padding-top: 10px;
  padding-bottom: 12px;
  padding-right: 11px;
  overflow: hidden;
  text-align: center;
}

.docs-info p {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-bottom: 3px;
}
</style>
