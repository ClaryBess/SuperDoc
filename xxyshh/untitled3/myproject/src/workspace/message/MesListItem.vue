<template>
  <div class="mes">
    <div class="mes-item">
      <img class="mesimg" src="@/assets/mes.svg" @click="itemClick" />
      <div class="mes-info" @click="itemClick">
        <p>{{ mesItem.content }}</p>
      </div>
      <img class="messmallimg" src="@/assets/删除.svg" @click="deleteMes" />
    </div>
  </div>
</template>

<script>
export default {
  name: "MesListItem",
  data() {
    return {};
  },
  props: {
    mesItem: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  methods: {
    itemClick() {
      // 将是否已读设置为已读
      this.mesItem.isRead = true;
      if(this.mesItem.type == 'invitation')
      this.$confirm("是否要加入此团队?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "拒绝",
        type: "warning",
      })
        .then(() => {
          this.$message({
            type: "success",
            message: "已成功加入此团队!",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已拒绝加入此团队",
          });
        });
    },
    deleteMes() {
      alert("删除消息");
    },
  },
};
</script>

<style>
.mes {
  position: relative;
  padding: 10px;
}
.mes-item {
  display: flex;
  position: relative;
  border-radius: 20px;
  padding: 5px;
  background-color: #f4f7f8;
}

.mesimg {
  width: 50px;
  padding: 10px;
}

.messmallimg {
  position: absolute;
  right: 30px;
  width: 30px;
  padding-top: 20px;
  padding-right: 10px;
}

.mes-info {
  font-size: 16px;
  position: relative;
  padding-left: 0px;
  padding-top: 10px;
  padding-top: 10px;
  padding-right: 20px;
  overflow: hidden;
  text-align: left;
}

.mes-info p {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-bottom: 3px;
}
</style>
