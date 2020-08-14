<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
      <el-aside width="15%">
        <SideBar currentindex="4"></SideBar>
      </el-aside>
      <el-main style="width: 80%">
        <div class="newteam"><el-button type="text" @click="dialogFormVisible = true">创建团队</el-button></div>
        <el-dialog title="创建团队" :visible.sync="dialogFormVisible" >
          <el-form :model="form" :rules="rules" ref="form" class="form" >

            <el-form-item class="item" label="团队名称："  prop="name" :label-width="formLabelWidth">
              <el-input placeholder="请输入2-10个字符" v-model="form.name" ></el-input>
            </el-form-item>

            <el-form-item class="item" label=" 团队简介：":label-width="formLabelWidth">
              <el-input
                type="textarea"
                :rows="4"
                style="margin-top: 10px"
                v-model="form.info"
                autocomplete="off"
              ></el-input>
            </el-form-item>

            <el-form-item class="item" label=" 添加成员：" :label-width="formLabelWidth">
              <el-input placeholder="请输入内容" v-model="form.select" class="input-with-select">
                <el-select style="width: 120px"  v-model="form.select"  slot="prepend" placeholder="请选择">
                  <el-option label="用户ID" value="xxxxxx"></el-option>
                  <el-option label="用户邮箱" value="xx@xx.xx"></el-option>
                </el-select>
              </el-input>
            </el-form-item>

          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false" style="margin-right: 20px">取 消</el-button>
            <el-button type="primary" @click="submitForm('form')">确 定</el-button>
          </div>
        </el-dialog>
        <h2 class="h2color">加入的团队</h2>
        <!-- <teams-list :teams="joinedteams"></teams-list> -->
        <teams-list :teams="teams"></teams-list>
      </el-main>
      <right-bar></right-bar>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import SideBar from "../SideBar";
import TeamsList from "./TeamsList";
import RightBar from "../RightBar";
export default {
  name: "Team",
  components: { NavBar, SideBar, TeamsList,RightBar },
  data() {
    var checkName = (rule, value, callback) => {
      if (value == '') {
        return callback(new Error('用户名不能为空'));
      }else if(value.length>10){
        callback(new Error('用户名过长'));
      } else {
        if (value.length<3) {
          callback(new Error('用户名过短'));
        } else {
          callback();
        }
      }
    };
    return {
      headUrl: require("@/assets/head.jpg"),
      teams: [
        {
          id: '1',
          title: '湍湍湍湍'
        },
        {
          id: '2',
          title: 'mmmmm'
        },
      ],
      dialogTableVisible: false,
      dialogFormVisible: false,

      form: {
        name: '',
        info: '',
        input3:'',
        select: "",
      },
      rules: {
        name: [
          { validator: checkName, trigger: 'blur' }
        ]
      },
      formLabelWidth: '120px'
    };
  },
  methods:{
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$router.push('Register2')
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    submitForm(formName) {
      dialogFormVisible = false;
      if (this.loading) {
        return;
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$confirm("确定提交吗？")
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
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
  },

};
</script>

<style>
  .h2color {
    color: #7093ff;
  }
  .newteam{
    width: 120px;
    float: right;
    margin-top:27px;
  }
  .form{
    margin-left: 3%;
    margin-right: 5%;
  }
  .el-select .el-input {
    width: 120px;
  }
  .input-with-select .el-input-group__prepend {
    background-color: #fff;
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
</style>
