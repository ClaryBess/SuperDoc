<template>
  <div class="docs">
    <mes-list-item v-for="item in mess" :mes-item="item" :key="item.id">
    </mes-list-item>
  </div>
</template>

<script>
  import MesListItem from "./MesListItem";

  export default {
    name: "MesList",
    components: {
      MesListItem
    },
    props: {
      //文档数组
      mess: {
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
