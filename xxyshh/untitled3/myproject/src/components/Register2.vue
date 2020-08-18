<template>
  <el-container>
    <!-- 头部 -->
    <el-header>
      <NavBarOrigin>
      </NavBarOrigin>
    </el-header>
    <!-- 内容 -->
    <div id="color">
    <div class="main">
      <el-main>
        <el-card class="box-card">

          <!-- 标题 -->
          <div  class="title">
            <p>注册新账号</p>
          </div>
          <!-- 进度条 -->
          <div class="step">
            <el-progress :percentage="percentage" :color="customColorMethod"></el-progress><br/><br/>
            <el-steps  :active="1"  align-center>
              <el-step title="已完成"  description="注册账号"></el-step>
              <el-step title="进行中" description="填写信息"></el-step>
              <el-step title="未完成" description="注册成功"></el-step>
            </el-steps>
          </div>
          <!-- 注册表单 -->
          <div class = regform >
            <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
              <el-form-item label="头像" prop="profile">
                <el-upload
                  class="upload-demo"
                  action="https://jsonplaceholder.typicode.com/posts/"
                  multiple
                  limit="1"
                  list-type="picture-card"
                  :before-upload="beforeAvatarUpload"
                  :on-remove="handleRemove"
                  :on-exceed="handleExceed"
                  :file-list="ruleForm.fileList">
                  <el-button size="small" type="primary">点击上传</el-button>
                  <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                </el-upload>
              </el-form-item>

              <el-form-item label="性别" prop="sex">
                <el-radio-group v-model="ruleForm.sex">
                  <el-radio-button label="男"></el-radio-button>
                  <el-radio-button label="女"></el-radio-button>
                </el-radio-group>
              </el-form-item>

              <el-form-item label="生日" prop="birth">
                <el-date-picker
                  v-model="ruleForm.birth"
                  type="date"
                  placeholder="选择日期">
                </el-date-picker>
              </el-form-item>

              <el-form-item>
                <el-button class="btn"  type="primary" @click="submitForm('ruleForm')">
                  完成
                </el-button>
                <el-button class="btn"  @click="resetForm('ruleForm')">
                  重置
                </el-button>
              </el-form-item>
            </el-form>
          </div>

        </el-card>
      </el-main>
    </div>
    </div>
  </el-container>
</template>

<script>
  import NavBar from "./NavBar";
  import NavBarOrigin from "./NavBarOrigin";
  import axios from "axios";

  export default {
    name: "Register2",
    components: {
      NavBar,
      NavBarOrigin
    },
    data() {
      var checkBirth = (rule, value, callback) => {
        if (value == '') {
          return callback(new Error('生日不能为空'));
        } else {
            callback();
        }
      };
      var checkSex = (rule, value, callback) => {
        if (value != '男' && value != '女' ) {
          callback(new Error('请选择性别'));
        } else {
          callback();
        }
      };
      return {
        ruleForm: {
          sex: '男',
          birth: '',
          fileList: [
            {
              name: '默认头像.png',
              url: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'
            }
          ]
        },
        rules: {
          sex: [
            { validator: checkSex, trigger: 'blur' }
          ],
          birth: [
            { validator: checkBirth, trigger: 'blur' }
          ]
        },
        percentage: 50,
      };
    },
    methods: {
      customColorMethod(percentage) {
        if (percentage < 100) {
          return '#3369e7';
        } else {
          return '#409eff';
        }
      },
      fetchUser(){
        this.userL=JSON.parse(sessionStorage.getItem("userL"))
      },
      submitForm(formName) {
        var _this=this
        console.log(this.picture_url);

        axios.post("http://127.0.0.1:8081/user/register2",{
          userID:this.userL.userID,
          userName:this.userL.username,
          email:this.userL.email,
          password:this.userL.pass,
          birthday:this.ruleForm.birth,
          gender:this.ruleForm.sex,
          profileUrl:this.picture_url //图片地址
        }).then(function (response) {
          // console.log(response.data.status)
          if(response.data.status === 200){
            sessionStorage.setItem('userL', JSON.stringify(response.data.data))
            _this.$router.push('Register3')
          }
          else {
            _this.$message({
              message: '设置失败',
              type: 'error'
            })
          }
        })
          .catch(function (error) {
            console.log(error)
          })
      },

      resetForm(formName) {
        this.$refs[formName].resetFields();
      },

      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isPNG = file.type === 'image/png';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG && !isPNG) {
          this.$message.error('上传头像图片只能是 JPG/PNG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 1MB!');
        }
        return (isJPG||isPNG) && isLt2M;
      },

      handleRemove(file, fileList) {
        console.log(file, fileList);
      },

      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件`);
      }
    },
    created() {
      this.fetchUser()
    }
  }
</script>

<style scoped>
  #color{
    height: auto;
    background-color: #f1f8fa;
  }

  .main{
    width: 70%;
    margin: 2% auto;
  }

  .title{
    width: 100%;
  }

  .title p{
    float: left;
    font-size: 30px;
    color: #3369e7;
    font-weight: bold;
    margin-left: 50px;
  }

  .step{
    margin-top: 100px;
    margin-left: 5%;
    margin-right: 5%;
  }

  .regform{
    margin-top: 66px;
    margin-left: 24%;
    margin-right: 30%;
  }

  .btn{
    margin-left: 40px;
    margin-top: 30px
  }

</style>
