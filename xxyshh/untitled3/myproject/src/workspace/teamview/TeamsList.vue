<template>
  <div class="docs">
    <teams-list-item v-for="item in teams" :teams-item="item" :key="item.id">
    </teams-list-item>
  </div>
</template>

<script>
  import TeamsListItem from "./TeamsListItem";

  export default {
    name: "TeamsList",
    components: {
      TeamsListItem
    },
    props: {
      //团队数组
      teams: {
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
