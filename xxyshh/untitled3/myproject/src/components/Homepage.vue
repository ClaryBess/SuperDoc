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
            <el-card class="box-card" >
              <div slot="header" class="clearfix">
                <p style="margin-top:5px; margin-left: 66px; height: 14px; font-size: 29px; color: #333333">
                  <strong>个人空间</strong>
                  <el-button style="float: right; font-size: 17px; padding: 15px" type="text" @click="submitForm('ruleForm')">
                    <i class="el-icon-edit-outline"></i> 修改信息</el-button>
                </p>
              </div>
              <div style="margin-left: 20%; margin-top: 5%">
                <el-form-item label="头像" prop="profile">
                  <el-avatar style="margin-left: 5px" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                </el-form-item>
                <el-form-item  label="用户名" prop="username">
                  <span style="color: #66b1ff; font-size: 17px">酒醉的蝴蝶</span>
                </el-form-item>
                <el-form-item label="邮箱" prop="email">
                  <span style="color: #66b1ff; font-size: 17px">12345678@qq.com</span>
                </el-form-item>
                <el-form-item label="性别" prop="sex">
                  <span style="color: #66b1ff; font-size: 17px">男</span>
                </el-form-item>
                <el-form-item label="生日" prop="birth">
                  <span style="color: #66b1ff; font-size: 17px">1999-09-09</span>
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
    name: "Homepage",
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
            this.$router.push('HomepageEdit')
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
