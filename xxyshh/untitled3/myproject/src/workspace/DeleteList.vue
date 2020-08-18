<template>
  <div class="docs">
    <delete-list-item v-for="item in docs" 
    :docs-item="item" 
    :key="item.docID"
    :userID="userID"
    >
    </delete-list-item>
  </div>
</template>

<script>
  import DeleteListItem from "./DeleteListItem";

  export default {
    name: "DeleteList",
    components: {
      DeleteListItem
    },
    props: {
      //文档数组
      docs: {
        type: Array,
        default() {
          return []
        }
      },
      //当前用户id
      userID: {
      type: Number,
      default: 0,
      },
    }
  }
</script>

<style scoped>
  .docs {
    /* display: flex; 
    flex-wrap: wrap; */
    padding: 5px;
  }
</style>
