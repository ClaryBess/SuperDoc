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
              <el-input placeholder="请输入密码" type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input placeholder="请再次输入密码" type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="用户名" prop="username">
              <el-input placeholder="请输入2-10个字符" v-model="ruleForm.username"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button style="margin-left: 30px; margin-top: 30px" type="primary" @click="submitForm('ruleForm')">
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
              this.post("/register",this.submitForm()).then(retDate => {
                if (retDate.ok) {
                  this.store.dispatch('setUser', retDate)
                  // 注册成功跳转到首页
                  this.$message.success(retDate.message)
                  this.$router.push('NavBar')
                } else {
                  this.showMessage(retDate.message)
                }
              })
            }else {
              console.log('error submit!!');
              return false;
            }
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
    margin-left: 25%;
    margin-right: 30%;
  }

</style>
