<template>
  <div class="docs">
    <member-list-item2 v-for="item in members" :member-item="item" :key="item.id">
    </member-list-item2>
  </div>
</template>

<script>
  import MemberListItem2 from "./MemberListItem2";

  export default {
    name: "MemberList2",
    components: {
      MemberListItem2
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
