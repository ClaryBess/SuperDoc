<template>
  <div class="docs">
    <doc-list-item2
      v-for="item in tems"
      :tem-item="item"
      :key="item.docID"
      :currentview="currentview"
      :userID="userID"
      :teamID="teamID"
    >
      <p slot="dropdown"></p>
    </doc-list-item2>
  </div>
</template>

<script>
import DocListItem2 from "../DocListItem2";

export default {
  name: "TeamDocList2",
  components: {
    DocListItem2,
  },
  props: {
    //从外部获取的模板数组
    tems: {
      type: Array,
      default() {
        return [];
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
};
</script>

<style scoped>
.docs {
  display: flex;
  flex-wrap: wrap;
  padding: 10px;
}
</style>
