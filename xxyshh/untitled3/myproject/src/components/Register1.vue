<template>
  <el-container>
    <el-header>
      <NavBarOrigin>
      </NavBarOrigin>
    </el-header>
    <div class="main">
      <el-main>
        <div  class="title">
          <p>注册新账号</p>
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
              <el-input v-model="ruleForm.email"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass">
              <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="用户名" prop="username">
              <el-input v-model="ruleForm.username"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')">
                  完成
                </el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>

        </div>
      </el-main>
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
            if (this.ruleForm.checkPass !== '') {
              this.$refs.ruleForm.validateField('checkPass');
            }
            callback();
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
      methods: {
        customColorMethod(percentage) {
          if (percentage < 100) {
            return '#909399';
          } else {
            return '#409eff';
          }
        },
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
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      }
    }
</script>

<style scoped>
  .main{
    width: 70%;
    margin: 0 auto;
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
    margin-left: 25%;
    margin-right: 30%;
  }
</style>
