<template>
  <div>
    <router-view v-if="IsRouterAlive"></router-view>
  </div>
</template>

<script>
export default {
  name: "App",
  provide() {
    return {
      reload: this.reload,
    };
  },
  data() {
    return {
      style: "",
      IsRouterAlive: true,
    };
  },
  methods: {
    reload() {
      this.IsRouterAlive = false;
      this.$nextTick(function () {
        this.IsRouterAlive = true;
      });
    },
    quitload() {
      this.IsRouterAlive = false;
      this.$nextTick(function () {
        this.IsRouterAlive = true;
      });
    },
  },
};
</script>

<style>
</style>
