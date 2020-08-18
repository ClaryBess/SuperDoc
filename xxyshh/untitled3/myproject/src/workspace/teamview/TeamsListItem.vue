<template>
 <div class="teams" >
      <div class="teams-item">
        <img class="teamsimg" src="@/assets/团队.svg" @click="itemClick">
        <div class="teams-info" @click="itemClick">
          <p>团队名称：{{teamsItem.title}}</p>
          <p>创建者：{{teamsItem.leader}} </p>
        </div>
      </div>
  </div>

</template>

<script>
export default {
  name: "TeamsListItem",
  data() {
    return{
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
      }
    }
};
</script>

<style>
  .teams {
    position: relative;
    padding: 10px;
  }
  .teams-item {
    display: flex;
    position: relative;
    border-radius: 20px;
    padding: 5px;
    background-color: #f4f7f8;
  }

  .teamsimg {
    width: 50px;
    padding: 10px;
  }
  .teams-info {
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
