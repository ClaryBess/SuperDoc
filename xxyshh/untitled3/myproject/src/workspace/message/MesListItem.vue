<template>
 <div class="docs" >
      <div class="docs-item">
        <img class="docimg" src="@/assets/mes.svg" @click="itemClick">
        <div class="docs-info" @click="itemClick">
          <p>{{ mesItem.content }}</p>
        </div>
        <img class="img" src="@/assets/删除.svg" @click="deleteMes">
      </div>
  </div>

</template>

<script>
export default {
  name: "MesListItem",
  data() {
    return{
    }
  },
  props: {
      mesItem: {
        type: Object,
        default() {
          return {}
        }
      }
    },
  methods: {
      itemClick() {
        alert('这是一条消息')
        this.mesItem.isRead=true
      },
      deleteMes() {
        alert('删除消息')
      }
    }
};
</script>

<style>
  .docs {
    position: relative;
    padding: 10px;
  }
  .docs-item {
    display: flex;
    position: relative;
    border-radius: 20px;
    padding: 5px;
    background-color: #f4f7f8;
  }

  .docimg {
    width: 50px;
    padding: 10px;
  }

  .img {
    position:fixed;
    right: 200px;
    width: 30px;
    padding-top: 20px;
    padding-right: 10px;
  }

  .docs-info {
    font-size: 16px;
    position: relative;
    padding-left: 0px;
    padding-top: 10px;
    padding-top: 10px;
    padding-right: 20px;
    overflow: hidden;
    text-align: left;
  }

  .docs-info p {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    margin-bottom: 3px;
  }

</style>
