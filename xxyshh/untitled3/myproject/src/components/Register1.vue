<template>
  <el-container>
    <el-header>
      <NavBarOrigin>
      </NavBarOrigin>
    </el-header>
    <div id="color">
    <div class="main">
      <el-main>
        <el-card class="box-card">
        <div  class="title">
          <p style="margin-left: 50px">注册新账号</p>
        </div>
        <div class="step">
          <el-progress :percentage="percentage" :color="customColorMethod"></el-progress><br/><br/>
          <el-steps  :active="0" finish-status="success" align-center>
            <el-step title="进行中"  description="注册账号"></el-step>
            <el-step title="未完成" description="填写信息"></el-step>
            <el-step title="未完成" description="注册成功"></el-step>
          </el-steps>
        </div>
        <div class = regform >
          <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item
              prop="email"
              label="邮箱"
              :rules="[
      { message: '请输入邮箱地址', trigger: 'blur' },
      { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
    ]"
            >
              <el-input placeholder="请输入邮箱" v-model="ruleForm.email"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass">
              <el-input placeholder="长度需大于5位，且包含数字、大、小写、符号中的至少2种" type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input placeholder="请再次输入密码" type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="用户名" prop="username">
              <el-input placeholder="请输入2-10个字符" v-model="ruleForm.username"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button style="margin-left: 60px; margin-top: 30px" type="primary" @click="submitForm('ruleForm')">
                  完成
                </el-button>
              <el-button style="margin-left: 60px; margin-top: 30px"  @click="resetForm('ruleForm')">重置</el-button>
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

    export default {
      name: "Register1",
      components: {NavBar, NavBarOrigin},
      data() {
        var regUpper = /[A-Z]/;
        var regLower = /[a-z]/;
        var regNum = /[0-9]/;
        var regTeShu =new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？+-]");
        var complex = 0;
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
        var validatePass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入密码'));
          } else {
            if (regLower.test(value)) {
              ++complex;
            }
            if (regUpper.test(value)) {
              ++complex;
            }
            if (regNum.test(value)) {
              ++complex;
            }
            if (regTeShu.test(value)) {
              ++complex;
            }
            if (complex < 2 || value.length < 6) {
              callback(new Error('长度需大于5位，且包含数字、字母大、小写、符号中的至少2种'));
            } else if (this.ruleForm.checkPass !== '') {
              this.$refs.ruleForm.validateField('checkPass');
            }else {
              callback();
            }
          }
        };
        var validatePass2 = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'));
          } else if (value !== this.ruleForm.pass) {
            callback(new Error('两次输入密码不一致!'));
          } else {
            callback();
          }
        };
        return {
          ruleForm: {
            pass: '',
            checkPass: '',
            username: '',
            email: ''
          },
          rules: {
            pass: [
              { validator: validatePass, trigger: 'blur' }
            ],
            checkPass: [
              { validator: validatePass2, trigger: 'blur' }
            ],
            username: [
              { validator: checkName, trigger: 'blur' }
            ]
          },
          percentage: 0,
        };
      },
      methods:{
        customColorMethod(percentage) {
          if (percentage < 100) {
            return '#909399';
          } else {
            return '#409eff';
          }
        },
        submitForm(formName) {
          var _this=this
          this.axios.post("/user/register",{
            Password:this.ruleForm.pass,
            Username:this.ruleForm.username,
            Email:this.ruleForm.email
          })
            .then(function (response) {
              // console.log(response.data.status)
              if(response.data.status === 200){
                //alert("恭喜你，注册成功")
                //   _this.$message({
                //   message: '恭喜你，注册成功',
                //   type: 'success'
                // })
                sessionStorage.setItem('userL', JSON.stringify(response.data.data))
                _this.$router.push('Register2')
              }
              else if(response.data.status==500){
                _this.$message({
                  message: '该邮箱已注册，请更换一个',
                  type: 'error'
                })
              }
              else {
                _this.$message({
                  message: '该用户名已存在，请更换一个',
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
        }
      }
    }
</script>
<style scoped>
  #color{
    height: 800px;
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
    color: #333333;
  }
  .step{
    margin-top: 100px;
    margin-left: 5%;
    margin-right: 5%;
  }
  .regform{
    margin-top: 44px;
    margin-left: 22%;
    margin-right: 30%;
    width: 510px;
  }

</style>
