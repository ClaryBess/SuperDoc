// 创建者的页面
<template>
  <el-container>
    <el-header>
      <div>
        <nav-bar :headSrc="headUrl"></nav-bar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
        <team-side-bar1></team-side-bar1>
      </el-aside>
      <el-main style="width: 80%">
        <el-card class="team-box-card" shadow="always">
          <div slot="header" class="clearfix">
            <span style="font-size: 17px">
              <strong>团队简介</strong>
            </span>
            <el-popover
              placement="bottom"
              width="490"
              trigger="click"
              :before-close="handleClose"
              :visible.sync="dialog"
              style=" box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.9)"
            >
              <div class="demo-drawer__content">
                <el-form :model="form">
                  <el-form-item label=" 请修改团队简介：" class="drawer-item">
                    <el-input
                      type="textarea"
                      :rows="4"
                      style="margin-top: 10px"
                      v-model="form.name"
                      autocomplete="off"
                    ></el-input>
                  </el-form-item>
                </el-form>
                <div class="demo-drawer__footer">
                  <el-button @click="cancelForm" style="margin-right: 30px">取 消</el-button>
                  <el-button
                    type="primary"
                    @click="handleClose"
                    :loading="loading"
                  >{{ loading ? '提交中 ...' : '确 定' }}</el-button>
                </div>
              </div>
              <el-button style="float: right; padding: 3px 0" type="text" slot="reference">修改简介</el-button>
            </el-popover>
          </div>
          <div
            class="text item"
          >我们是非常专业的团队。美羊羊走中路的话输出不够，线上游走也来不及赶快，还是选欧阳修好，但是比起欧阳娜娜又有些许不足，要不还是选欧阳靖吧至少经济能压上还可以为羊村发展尽尽力</div>
        </el-card>
        <div style="width: 880px">
          <el-card style="width: 260px; height: 180px" class="team-box-card" shadow="always">
            <div slot="header" class="clearfix">
              <span style="font-size: 17px">
                <strong>创建者</strong>
              </span>
            </div>
            <div class="leader-item">
              <!-- :member=传入的团队成员 -->
              <!-- <member-list :members="teamMembers"></member-list> -->
              <member-list :members="teamMembers.id=1"></member-list>
              <h2>{{id}}</h2>
            </div>
          </el-card>
          <el-card class="team-box-card" shadow="always">
            <div slot="header" class="clearfix">
              <span style="font-size: 17px">
                <strong>成员</strong>
              </span>
              <el-popover
                placement="top"
                width="500"
                trigger="click"
                :before-close="handleClose"
                :visible.sync="dialog"
                style=" box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.9)"
              >
                <div class="demo-drawer__content">
                  <el-form :model="formmember">
                    <el-form-item label=" 请输入用户ID或者邮箱：" class="drawer-item-menber">
                      <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
                        <el-select v-model="select" slot="prepend" placeholder="请选择">
                          <el-option label="用户ID" value="1"></el-option>
                          <el-option label="用户邮箱" value="2"></el-option>
                        </el-select>
                        <el-button
                          slot="append"
                          type="primary"
                          @click="submitForm('formmember')"
                          icon="el-icon-search"
                        ></el-button>
                      </el-input>
                    </el-form-item>
                  </el-form>
                </div>
                <el-button style="float: right; padding: 3px 0" type="text" slot="reference">添加成员</el-button>
              </el-popover>
            </div>
            <div class="member-item">
              <!-- :member=传入的团队成员 -->
              <!-- <member-list :members="teamMembers"></member-list> -->
              <member-list :members="teamMembers"></member-list>
              <h2>{{id}}</h2>
            </div>
          </el-card>
        </div>
      </el-main>
      <right-bar></right-bar>
    </el-container>
    <el-backtop right="80"></el-backtop>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import TeamSideBar1 from "./TeamSideBar1";
import DocList from "../DocList";
import MemberList from "./MemberList";
import RightBar from "../RightBar";

export default {
  name: "TeamView1",
  components: { NavBar, TeamSideBar1, DocList, MemberList, RightBar },
  data() {
    return {
      select: "",
      dialog: false,
      loading: false,
      headUrl: require("@/assets/head.jpg"),
      // team的id
      id: null,
      Docs: [
        {
          id: "1",
          title: "第111",
        },
        {
          id: "2",
          title: "第二个hhhhh文档",
        },
        {
          id: "3",
          title: "第三个文dashdkjlashdjkl档",
        },
        {
          id: "4",
          title: "四少时诵诗书所所所所所所所所所所所所所所所",
        },
        {
          id: "5",
          title: "第五wwuwuwuwuwwwwwwwwwwwwww个文档",
        },
        {
          id: "6",
          title: "第六",
        },
      ],
      teamMembers: [
        {
          id: "1",
          name: "xxy",
        },
        {
          id: "2",
          name: "ljm",
        },
        {
          id: "3",
          name: "wsyshhshhshh",
        },
        {
          id: "4",
          name: "zbn",
        },
        {
          id: "5",
          name: "lzy",
        },
        {
          id: "6",
          name: "wzz",
        },
      ],
      form: {
        name: "",
      },

      input3: "",

      timer: null,
    };
  },
  created() {
    //获取团队id
    this.id = this.$route.params.id;
  },
  methods: {
    submitForm(formName) {
      if (this.loading) {
        return;
      }
      this.$confirm("确定要提交表单吗？")
        .then((_) => {
          this.loading = true;
          this.timer = setTimeout(() => {
            done();
            // 动画关闭需要一定的时间
            setTimeout(() => {
              this.loading = false;
            }, 400);
          }, 2000);
        })
        .catch((_) => {});
    },
    handleClose(done) {
      if (this.loading) {
        return;
      }
      this.$confirm("确定要提交表单吗？")
        .then((_) => {
          this.loading = true;
          this.timer = setTimeout(() => {
            done();
            // 动画关闭需要一定的时间
            setTimeout(() => {
              this.loading = false;
            }, 400);
          }, 2000);
        })
        .catch((_) => {});
    },
    cancelForm() {
      this.loading = false;
      this.dialog = false;
      clearTimeout(this.timer);
    },
  },
};
</script>

<style>
.text {
  font-size: 14px;
}
.item {
  margin: 15px 13px;
}
.leader-item {
  margin-left: 18px;
  margin-bottom: 1px;
}
.member-item {
  margin-left: 18px;
  margin-bottom: 1px;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}
.team-box-card {
  margin-top: 50px;
  margin-left: 50px;
  margin-bottom: 10px;
  width: 880px;
}
.demo-drawer__content {
  width: 85%;
  margin: auto;
}
.drawer-item {
  margin-bottom: 30px;
  margin-top: 10px;
  font-weight: bold;
}
.drawer-item-menber {
  margin-bottom: 50px;
  margin-top: 15px;
  font-weight: bold;
}
.demo-drawer__footer {
  margin-bottom: 20px;
  margin-left: 27%;
}
.el-select .el-input {
  width: 120px;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>
