<template>
 <div class="docs" >
      <div class="docs-item">
        <!-- 文档预览图 -->
        <img class="docimg" :src="TemItem.url" @click="itemClick">
        <div class="docs-info" @click="itemClick">
          <p>{{TemItem.title}}</p>
        </div>
        <img class="img" :src="collectedurl" alt="" @click="collectTem">
      </div>
  </div>
</template>

<script>
import img1 from "@/assets/收藏.svg";
import img2 from "@/assets/收藏 (1).svg";

export default {
  name: "TemListItem",
  data() {
    return{
      collectedurl: img1
    }
  },
  props: {
      TemItem: {
        type: Object,
        default() {
          return {}
        }
      }
    },
  methods: {
      //点击进入模板预览界面
      itemClick() {
        this.$router.push('/detail/' + this.docsItem.id)
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
    padding: 1px;
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
    padding-top: 10px;
    padding-top: 10px;
    padding-right: 20px;
    overflow: hidden;
    text-align: center;
  }

  .docs-info p {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    margin-bottom: 3px;
  }
