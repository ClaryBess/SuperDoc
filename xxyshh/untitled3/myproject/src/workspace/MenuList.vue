<template>
  <div class="docs">
    <menu-list-item v-for="item in menus" 
    :menu-item="item" 
    :key="item.id"
    :currentview="currentview"
    :userID="userID"
    >
    </menu-list-item>
  </div>
</template>

<script>
  import MenuListItem from "./MenuListItem";

  export default {
    name: "MenuList",
    components: {
      MenuListItem
    },
    props: {
      //文档数组
      menus: {
        type: Array,
        default() {
          return []
        }
      },
      //当前界面
      currentview: {
        type: Number,
        default:0
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
    display: flex;
    flex-wrap: wrap;
    padding: 10px;
  }
</style>
