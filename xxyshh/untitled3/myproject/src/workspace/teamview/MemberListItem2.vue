<template>
  <div class="docs">
    <div class="docs-item" @click="itemClick" >
      <!-- 展示图片为成员头像 -->
      <!-- <img class="docimg" :src="memberItem.url" @click="itemClick"> -->
      <img class="docimg" src="@/assets/head.jpg" />
      <div class="docs-info">
        <p>{{memberItem.name}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MemberListItem2",
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
      alert("删除成员");
    },
    manageAuth() {
      alert("管理成员权限");
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

.docs-info {
  font-size: 16px;
  position: relative;
  padding-left: 8px;
  padding-top: 10px;
  padding-top: 10px;
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
