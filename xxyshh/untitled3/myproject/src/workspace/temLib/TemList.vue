<template>
  <div class="docs">
    <tem-list-item v-for="item in tems" :tem-item="item" :key="item.id">
    </tem-list-item>
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
