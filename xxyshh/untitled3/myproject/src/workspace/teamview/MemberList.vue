<template>
  <div class="docs">
    <member-list-item v-for="item in members" :member-item="item" :key="item.id">
    </member-list-item>
  </div>
</template>

<script>
  import MemberListItem from "./MemberListItem";

  export default {
    name: "MemberList",
    components: {
      MemberListItem
    },
    props: {
      //文档数组
      members: {
        type: Array,
        default() {
          return []
        }
      }
    }
  }
</script>

<style scoped>
  .docs {
    display: flex;
    flex-wrap: wrap;
    padding: 1px;
  }
</style>
