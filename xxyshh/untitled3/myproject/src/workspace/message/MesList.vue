<template>
  <div class="docs">
    <mes-list-item v-for="item in mess" :mes-item="item" :key="item.newsID" :userID="userID"></mes-list-item>
  </div>
</template>

<script>
import MesListItem from "./MesListItem";

export default {
  name: "MesList",
  components: {
    MesListItem,
  },
  props: {
    //消息数组
    mess: {
      type: Array,
      default() {
        return [];
      },
    },
    //当前用户id
    userID: {
      type: Number,
      default: 0,
    },
  },
};
</script>

<style scoped>
.docs {
  padding: 5px;
}
</style>
