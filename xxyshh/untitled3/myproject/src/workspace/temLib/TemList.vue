<template>
  <div class="docs">
    <doc-list-item v-for="item in tems" :tems-item="item" :key="item.id">
    </doc-list-item>
  </div>
</template>

<script>
  import TemListItem from "./TemListItem";

  export default {
    name: "TemList",
    components: {
      TemListItem
    },
    props: {
      //从外部获取的模板数组
      tems: {
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
    padding: 10px;
  }
</style>
