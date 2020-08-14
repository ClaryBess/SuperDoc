<template>
  <div class="docs">
    <delete-list-item v-for="item in docs" :docs-item="item" :key="item.id">
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
      }
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
