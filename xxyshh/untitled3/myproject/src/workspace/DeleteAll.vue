<template>
  <el-button type="text" @click="open">全部删除</el-button>
</template>

<script>
  export default {
    name: 'DeleteAll',
    methods: {
      open() {
        this.$confirm('此操作将永久删除回收站中全部文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      }
    }
  }
</script>

<style>
</style>
