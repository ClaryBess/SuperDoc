<template>
  <el-container>
    <!-- 头部 -->
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <!-- 内容 -->
    <el-container>
      <!-- 左栏 -->
      <el-aside width="15%">
        <SideBar currentindex="4"></SideBar>
      </el-aside>
      <!-- 中间 -->
      <el-main style="width: 80%">
        <!-- 创建团队 -->
        <el-button class="newteam" type="text" @click="dialogFormVisible = true">
          创建团队
        </el-button>
          <!-- 创建表单 -->
          <el-dialog title="创建团队" :visible.sync="dialogFormVisible" >
            <el-form :model="form" status-icon :rules="rules" ref="form" class="form" >
              <el-form-item class="item" label="团队名称："  prop="name" :label-width="formLabelWidth">
                <el-input placeholder="请输入2-10个字符" v-model="form.name" ></el-input>
              </el-form-item>

              <el-form-item class="item" label=" 团队简介：" :label-width="formLabelWidth">
                <el-input
                  type="textarea"
                  :rows="9"
                  class="teaminfo"
                  v-model="form.info"
                  autocomplete="off"
                ></el-input>
              </el-form-item>
            </el-form>

            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false" class="btn">
                取 消
              </el-button>
              <el-button type="primary" @click="submitForm('form')">
                确 定
              </el-button>
            </div>
          </el-dialog>
        <!-- 团队列表 -->
        <h2 class="h2color">加入的团队</h2>
        <!-- <teams-list :teams="joinedteams"></teams-list> -->
        <teams-list :teams="teams"></teams-list>
        <div style="margin-left: 41%; margin-top: 8%" v-show="this.isNULL">
          <div><img src="../../assets/空.png" style=" width: 110px"></div>
        </div>
      </el-main>
      <!-- 右栏 -->
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import SideBar from "../SideBar";
import TeamsList from "./TeamsList";
import RightBar from "../RightBar";
import axios from 'axios';

export default {
  name: "Team",
  components: {
    NavBar,
    SideBar,
    TeamsList,
    RightBar
  },
  data() {
    var checkName = (rule, value, callback) => {
      if (value == '') {
        return callback(new Error('用户名不能为空'));
      }else if(value.length>10){
        callback(new Error('用户名过长'));
      }else if (value.length<3) {
          callback(new Error('用户名过短'));
      }else {
          callback();
      }
    };
    return {
      headUrl: require("@/assets/head.jpg"),
      teams: [],
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        name: '',
        info: '',
      },
      rules: {
        name: [
          { validator: checkName, trigger: 'blur' }
        ]
      },
      formLabelWidth: '120px',
      isNULL: true,
    };
  },
  created() {
    this.fetchList();
    sessionStorage.setItem('teamL', null);
  },
  methods:{
    submitForm(formName) {
      this.dialogFormVisible = false;
      this.$refs[formName].validate((valid) => {
        if (valid) {
          var _this=this
          var userL=JSON.parse(sessionStorage.getItem("userL"))
          axios.post("/team/addTeam",{
            userID: userL.userID,
            teamName: this.form.name,
            teamInfo: this.form.info,
            memberNumber: 1,
            privilege: 1111
          })
            .then(function (response) {
              if(response.data.status === 200){
                _this.$message({
                  message: '新建团队成功',
                  type: 'success'
                });
                var team = JSON.parse(JSON.stringify(response.data.data));
                console.log(JSON.stringify(response.data.data));
                _this.$router.push('/teamleader/' + team.teamID);
              }
              else {
                _this.$message({
                  message: '创建失败',
                  type: 'error'
                })
              }
            })
            .catch(function (error) {
              console.log(error)
            })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },

    fetchList() {
      var userL = JSON.parse(sessionStorage.getItem("userL"));
      var _this = this;
      // 加入的团队列表
      axios.post("/team/inTeams", userL.userID)
        .then((res) => {
          if (res.data == "") {
            _this.isNULL = true;
          }
          else {
            _this.isNULL = false;
          }
          var teamList = res.data;
          _this.teams = teamList;
          console.log(_this.teams);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  }
};
</script>

<style scoped>
  .newteam{
    /* width: 120px;
    float: right;
    margin-top:27px; */
    position: absolute;
    right:17%;
    height: 15%;
  }

  .form{
    margin-left: 3%;
    margin-right: 5%;
  }

  .teaminfo{
    margin-top: 10px;
  }

  .el-select .el-input {
    width: 120px;
  }

  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }

  .formslct{
    width: 120px;
  }

  .item {
    font-weight: bold;
    padding-bottom: 30px;
  }

  .dialog-footer{
    margin-right: 50px;
    margin-bottom: 30px;
    margin-top: -20px;
  }

  .btn{
    margin-right: 20px;
  }

  .h2color {
    color: #3369e7;
  }
</style>
