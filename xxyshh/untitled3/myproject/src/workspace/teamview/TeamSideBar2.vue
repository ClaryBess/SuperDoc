<template>
  <div id="TeamSideBar2" style="margin-left: 30px">
    <el-row class="tac">
      <el-col>
        <div style="font-size: 14px;margin-top: 25px;margin-bottom: 30px">
          <span style="font-size: 19px"><strong>团队界面</strong></span>
          <el-divider direction="vertical"></el-divider>
          <span>成员</span>
        </div>
        <el-menu :default-active="currentindex" class="el-menu-vertical-demo">
          <el-menu-item index="1" @click="itemClick1">
            <span slot="title">团队信息</span>
          </el-menu-item>
          <el-menu-item index="2" @click="itemClick2">
            <span slot="title">团队文档</span>
          </el-menu-item>
          <el-menu-item index="4" @click="itemClick4">
            <span slot="title">退出团队</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "TeamSideBar2",
  data() {
    return {
    };
  },
  props: {
    currentindex: {
      type: String,
      default: '1'
    }
  },
  methods: {
    itemClick1() {
      this.$router.push("2")
      console.log("团队信息")
    },
    itemClick2() {
      this.$router.push("teamdoc2")
      console.log("团队文档")
    },
    itemClick4() {
      this.$confirm("确定退出该团队吗?", "提示", {
      confirmButtonText: "确定",
      cancelButtonText: "取消",
      type: "warning",
    })
      .then(() => {
        this.$message({
          type: "success",
          message: "已提交申请!",
        });
      })
      .catch(() => {
        this.$message({
          type: "info",
          message: "已取消操作",
        });
      });
    }
  },
};
</script>
