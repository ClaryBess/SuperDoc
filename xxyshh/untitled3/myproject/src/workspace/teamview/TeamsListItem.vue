<template>
 <div class="docs" >
      <div class="docs-item">
        <img class="docimg" src="@/assets/团队.svg" @click="itemClick">
        <div class="docs-info" @click="itemClick">
          <p>团队名称：{{teamsItem.title}}</p>
          <p>创建者：</p>
        </div>
        <img class="img" src="@/assets/删除.svg">
        <img class="img" :src="collectedurl" alt="" @click="collectDoc">
      </div>
  </div>

</template>

<script>
import img1 from "@/assets/收藏.svg";
import img2 from '@/assets/收藏 (1).svg';

export default {
  name: "TeamsListItem",
  data() {
    return{
      collectedurl: img1
    }
  },
  props: {
      teamsItem: {
        type: Object,
        default() {
          return {}
        }
      }
    },
  methods: {
      itemClick() {
        this.$router.push('/team/' + this.teamsItem.id)
      },
      collectDoc() {
        if(this.collectedurl == img1){
          this.collectedurl = img2
        }
        else if(this.collectedurl == img2){
          this.collectedurl = img1
        }
      }
    }
};
</script>

<style>
  .docs {
    position: relative;
    padding: 5px;
  }
  .docs-item {
    display: flex;
    position: relative;
    border-radius: 20px;
    background-color: #f4f7f8;
  }

  .docimg {
    width: 50px;
    padding: 10px;
  }

  .img {
    width: 20px;
    padding-right: 10px;
  }

  .docs-info {
    font-size: 16px;
    position: relative;
    padding-left: 0;
    padding-top: 4px;
    padding-bottom: 4px;
    padding-right: 20px;
    overflow: hidden;
    text-align: left;
  }

</style>
