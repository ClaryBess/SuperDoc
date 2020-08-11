<template>
  <el-container>
    <el-header>
      <NavBar>
      </NavBar>
    </el-header>
    <div class="main">
      <el-main>
        <div class="info">
          <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <p style="margin-top:5px; margin-left: 66px; height: 14px; font-size: 29px; color: #333333">个人空间
                  <el-button style="float: right; font-size: 16px; padding: 15px"  type="text" @click="resetForm('ruleForm')">重置</el-button>
                  <el-button style="float: right; font-size: 16px;padding: 15px"  type="text" @click="submitForm('ruleForm')">保存修改</el-button>
                </p>
              </div>
              <div style="margin-left: 20%; margin-top: 5%">
                <el-form-item label="头像" prop="profile">
                  <el-upload
                    class="upload-demo"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :on-preview="handlePreview"
                    :on-remove="handleRemove"
                    :before-remove="beforeRemove"
                    multiple
                    :limit="1"
                    :on-exceed="handleExceed"
                    :file-list="fileList"
                    list-type="picture">
                    <el-button size="small" type="primary">点击上传</el-button>
                    <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                  </el-upload>
                </el-form-item>
                <el-form-item label="密码" prop="pass" >
                  <el-input placeholder="请输入密码" style="width: 200px" type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="checkPass">
                  <el-input placeholder="请再次输入密码" style="width: 200px" type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
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
              </div>
            </el-card>
          </el-form>
        </div>
      </el-main>
    </div>
  </el-container>
</template>

<script>
  import NavBar from "./NavBar";

  export default {
    name: "HomepageEdit",
    components: {NavBar},
    data() {
      var checkBirth = (rule, value, callback) => {
        if (value == '') {
          return callback(new Error('生日不能为空'));
        } else {
          callback();
        }
      };
      var checkSex = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请选择性别'));
        } else {
          callback();
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
          radio1: '男',
          birth: '',
          fileList: []
        },
        rules: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
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
          return '#909399';
        } else {
          return '#409eff';
        }
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$router.push('Register3')
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件`);
      },
      handlePreview(file) {
        console.log(file);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      }
    }
  }
</script>

<style scoped>
  .main{
    width: 100%;
    margin: 0 auto;
    background-color: #f1f8fa;
  }
  .info{
    margin-top: 3%;
    margin-left: 78px;
  }
  .demo-ruleForm {
    margin-left: 17%;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
  .box-card {
    margin-top: 40px;
    margin-left: 1%;
    width: 800px;
    height: 600px;
  }
</style>
