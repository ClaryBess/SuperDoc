<template>
  <div class="docs">
    <div class="docs-item">
      <img class="docimg" src="../assets/文档.svg" @click="itemClick" />
      <div class="docs-info" @click="itemClick">
        <p>{{docsItem.title}}</p>
      </div>
      <img class="smallimg1" src="../assets/删除.svg" @click="deleteDoc" />
      <img class="smallimg2" :src="collectedurl" alt @click="collectDoc" />
    </div>
  </div>
</template>

<script>
import img1 from "../assets/收藏.svg";
import img2 from "../assets/收藏 (1).svg";

export default {
  name: "DocListItem",
  data() {
    return {
    };
  },
  props: {
    docsItem: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  computed: {
    collectedurl: function() {
      if(this.docsItem.isCollected == false) {
        return img1
      }
      else{
        return img2
      }
    }
  },
  methods: {
    itemClick() {
      this.$router.push("/detail/" + this.docsItem.id);
    },
    collectDoc() {
      this.docsItem.isCollected = !this.docsItem.isCollected;
    },
    deleteDoc() {
      alert("删除文件");
    },
  },
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

.smallimg1 {
  position: absolute;
  right: 30px;
  width: 30px;
  padding-top: 20px;
  padding-right: 10px;
}
.smallimg2 {
  position: absolute;
  right: 80px;
  width: 30px;
  padding-top: 20px;
  padding-right: 10px;
}

.docs-info {
  font-size: 16px;
  position: relative;
  padding-left: 0;
  padding-top: 10px;
  padding-bottom: 10px;
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
