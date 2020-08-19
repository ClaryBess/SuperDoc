<template>
  <el-container>
    <!-- 头部 -->
    <el-header>
      <NavBar></NavBar>
    </el-header>
    <!-- 主体 -->
    <div class="main">
      <el-main>
        <div class="info">
          <el-form
            :model="ruleForm"
            status-icon
            :rules="rules"
            ref="ruleForm"
            label-width="100px"
            class="demo-ruleForm"
          >
            <el-card class="box-card">
              <!-- 卡片头部 -->
              <div slot="header" class="clearfix">
                <p>
                  <strong>个人空间</strong>
                  <el-button class="btn" type="text" @click="itemClick">返回个人空间</el-button>
                  <el-button class="btn" type="text" @click="resetForm('ruleForm')">重置</el-button>
                  <el-button
                    class="btn"
                    style="margin-right: -11px"
                    type="text"
                    @click="submitForm('ruleForm')"
                  >保存修改</el-button>
                </p>
              </div>
              <!-- 卡片内容 -->
              <div class="card-main">
                <el-form-item label="头像" prop="fileList[0]">
                  <el-upload
                    class="upload-demo"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    multiple
                    limit="1"
                    list-type="picture-card"
                    :file-list="ruleForm.fileList"
                    :before-upload="beforeAvatarUpload"
                    :on-remove="handleRemove"
                    :on-exceed="handleExceed"
                  >
                    <el-button size="small" type="primary">点击上传</el-button>
                    <div slot="tip" class="el-upload__tip">只能上传 jpg/png 文件，且不超过 1MB</div>
                  </el-upload>
                </el-form-item>

                <el-form-item label="密码" prop="pass">
                  <el-input
                    placeholder="长度需大于5位，且包含数字、大、小写、符号中的至少2种"
                    style="width: 400px"
                    type="password"
                    v-model="ruleForm.pass"
                    autocomplete="off"
                  ></el-input>
                </el-form-item>

                <el-form-item label="确认密码" prop="checkPass">
                  <el-input
                    placeholder="请再次输入密码"
                    style="width: 400px"
                    type="password"
                    v-model="ruleForm.checkPass"
                    autocomplete="off"
                  ></el-input>
                </el-form-item>

                <el-form-item label="性别" prop="sex">
                  <el-radio-group v-model="ruleForm.sex">
                    <el-radio-button label="男"></el-radio-button>
                    <el-radio-button label="女"></el-radio-button>
                  </el-radio-group>
                </el-form-item>

                <el-form-item label="生日" prop="birth">
                  <el-date-picker v-model="ruleForm.birth" type="date" placeholder="选择日期"></el-date-picker>
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
import axios from "axios";

export default {
  name: "HomepageEdit",
  components: { NavBar },
  data() {
    var regUpper = /[A-Z]/;
    var regLower = /[a-z]/;
    var regNum = /[0-9]/;
    var regTeShu = new RegExp(
      "[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？+-]"
    );
    var complex = 0;
    var checkBirth = (rule, value, callback) => {
      if (value == "") {
        return callback(new Error("生日不能为空"));
      } else {
        callback();
      }
    };
    var checkSex = (rule, value, callback) => {
      if (value != "男" && value != "女") {
        callback(new Error("请选择性别"));
      } else {
        callback();
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
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
          callback(
            new Error(
              "长度需大于5位，且包含数字、字母大、小写、符号中的至少2种"
            )
          );
        } else if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        } else {
          callback();
        }
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        profile: "",
        pass: "",
        checkPass: "",
        sex: "男",
        birth: "",
        fileList: [
          {
            name: "默认头像.png",
            url:
              "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png",
          },
        ],
      },
      rules: {
        pass: [{ validator: validatePass, trigger: "blur" }],
        checkPass: [{ validator: validatePass2, trigger: "blur" }],
        sex: [{ validator: checkSex, trigger: "blur" }],
        birth: [{ validator: checkBirth, trigger: "blur" }],
      },
    };
  },
  methods: {
    itemClick() {
      this.$router.push("homepage");
    },

    fetchUser() {
      this.userL = JSON.parse(sessionStorage.getItem("userL"));
    },
    submitForm(formName) {
      var _this = this;
      console.log(this.picture_url);

      axios
        .post("http://127.0.0.1:8081/user/edit", {
          userID: this.userL.userID,
          userName: this.ruleForm.username,
          email: this.ruleForm.email,
          password: this.ruleForm.pass,
          birthday: this.ruleForm.birth,
          gender: this.ruleForm.sex,
          profileUrl: this.picture_url, //图片地址
        })
        .then(function (response) {
          // console.log(response.data.status)
          if (response.data.status === 200) {
            sessionStorage.setItem("userL", JSON.stringify(response.data.data));
            _this.$router.push("Homepage");
          } else {
            _this.$message({
              message: "修改失败",
              type: "error",
            });
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    beforeAvatarUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isPNG = file.type === "image/png";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG && !isPNG) {
        this.$message.error("上传头像图片只能是 JPG/PNG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 1MB!");
      }
      return (isJPG || isPNG) && isLt2M;
    },

    handleRemove(file, fileList) {
      console.log(file, fileList);
    },

    handleExceed(files, fileList) {
      this.$message.warning(`只能选择一个头像`);
    },
  },
  created() {
    this.fetchUser();
  },
};
</script>

<style scoped>
p {
  margin-top: 5px;
  margin-left: 66px;
  height: 14px;
  font-size: 29px;
  color: #333333;
}

.main {
  width: 100%;
  margin: 0 auto;
  background-color: #f1f8fa;
}

.info {
  margin-top: 3%;
  margin-left: 78px;
}

.demo-ruleForm {
  margin-left: 14%;
  margin-bottom: 40px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}

.box-card {
  margin-top: 40px;
  width: 900px;
  height: auto;
  padding-bottom: 30px;
  padding-left: 15px;
}

.card-main {
  margin-left: 20%;
  margin-top: 5%;
}

.btn {
  float: right;
  font-size: 16px;
  margin-right: -7px;
  padding: 15px;
}
</style>
