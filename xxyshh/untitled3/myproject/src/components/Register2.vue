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
          <el-steps  :active="1"  align-center>
            <el-step title="已完成"  description="注册账号"></el-step>
            <el-step title="进行中" description="填写信息"></el-step>
            <el-step title="未完成" description="注册成功"></el-step>
          </el-steps>
        </div>
        <div class = regform >
          <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
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
              <el-button type="primary" @click="submitForm('ruleForm')">完成</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
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
    name: "Register2",
    components: {NavBar, NavBarOrigin},
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
      return {
        ruleForm: {
          radio1: '男',
          birth: '',
          fileList: []
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
    margin-top: 66px;
    margin-left: 30%;
    margin-right: 30%;
  }
</style>
