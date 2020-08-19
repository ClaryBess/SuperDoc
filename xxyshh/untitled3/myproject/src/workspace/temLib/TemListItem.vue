<template>
  <div class="goods-item" @click="itemClick">
    <el-card class="box-card" shadow="always">
      <!-- <img :src="TemItem.img" alt=""> -->
      <img :src=TemItem.picUrl alt />
      <div class="goods-info">
        <p>{{TemItem.title}}</p>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: "TemListItem",
    data() {
      return {};
    },
    props: {
      TemItem: {
        type: Object,
        default() {
          return {};
        },
      },
    },
    methods: {
      //点击进入模板预览界面
      itemClick() {
        var teamL=JSON.parse(sessionStorage.getItem("teamL"));
        if(teamL === null){
          this.$router.push("/edit/" + this.TemItem.id);
        }
        else{
          this.$router.push("/editTeam/" + teamL + '/' + this.TemItem.id);
        }
      },
    },
  };
</script>

<style scoped>
  .goods-item {
    padding:25px;
    position: relative;
    width: 28%;
  }

  .goods-item img {
    width: 240px;
    border-radius: 20px;
    padding: 5px;
    margin-top: 8px;
  }

  .goods-info {
    font-size: 18px;
    position: relative;
    bottom: 7px;
    left: 0;
    right: 0;
    overflow: hidden;
    text-align: center;
  }

  .goods-info p {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    margin-bottom: 0px;
  }
</style>
