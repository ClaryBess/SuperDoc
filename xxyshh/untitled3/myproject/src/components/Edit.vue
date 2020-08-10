<template>
  <div>
    <el-container>
      <el-header>
        <NavBar :headSrc="headUrl" style="z-index: 9999"></NavBar>
      </el-header>
      <el-main>
        <el-card class="main-body">
          <div class="card">
            <el-row>
              <p class="top-title">创建文档</p>
            </el-row>
            <div class="tips">
              <p>你可以使用“模板”功能来快速创建文档</p>
            </div>
            <div style="margin-top: 40px;">
              <el-form :model="docForm" label-width="80px">
                <el-row>
                  <el-form-item label="文档标题">
                    <el-input v-model="docForm.title"></el-input>
                  </el-form-item>
                </el-row>
                <el-form-item label="文档权限">
                  <el-checkbox-group v-model="docForm.privilege">
                    <el-checkbox label="可查看" name="type"></el-checkbox>
                    <el-checkbox label="可评论" name="type"></el-checkbox>
                    <el-checkbox label="可编辑" name="type"></el-checkbox>
                    <el-checkbox label="可分享" name="type"></el-checkbox>
                  </el-checkbox-group>
                </el-form-item>
                <div class="editor">
                  <vue-ueditor-wrap v-model="docForm.doc" :config="ueConfig"></vue-ueditor-wrap>
                </div>

                <el-form-item class="button-row">
                  <el-button type="primary" @click="onSubmit" >提交</el-button>
                  <el-button style="margin-left: 40px">取消</el-button>
                </el-form-item>
              </el-form>
            </div>
          </div>
        </el-card>
      </el-main>
    </el-container>
    <el-backtop right="80"></el-backtop>
  </div>
</template>

<script>
  import UEditor from "./UEditor";
  import NavBar from "./NavBar";
  import VueUeditorWrap from "vue-ueditor-wrap";
  export default {
    name: "Edit",
    components: {UEditor, NavBar, VueUeditorWrap},
    data(){
      return{
        headUrl: require('../assets/head.jpg'),
        docForm:{
          title: "",
          doc: "",
          privilege: []
        },
        ueConfig:{
          toolbars: [
            [
              'source', // 源代码
              // 'anchor', // 锚点
              'undo', // 撤销
              'redo', // 重做
              'bold', // 加粗
              'indent', // 首行缩进
              // 'snapscreen', //截图
              'italic', // 斜体
              'underline', // 下划线
              'strikethrough', // 删除线
              'subscript', // 下标
              'fontborder', // 字符边框
              'superscript', // 上标
              'formatmatch', // 格式刷
              'blockquote', // 引用
              'pasteplain', // 纯文本粘贴模式
              'selectall', // 全选
              // 'print', // 打印
              'preview', // 预览
              'horizontal', // 分隔线
              'removeformat', // 清除格式
              // 'time', // 时间
              // 'date', // 日期
              // 'unlink', // 取消链接
              'insertrow', // 前插入行
              'insertcol', // 前插入列
              'mergeright', // 右合并单元格
              'mergedown', // 下合并单元格
              'deleterow', // 删除行
              'deletecol', // 删除列
              'splittorows', // 拆分成行
              'splittocols', // 拆分成列
              'splittocells', // 完全拆分单元格
              'deletecaption', // 删除表格标题
              'inserttitle', // 插入标题
              'mergecells', // 合并多个单元格
              'deletetable', // 删除表格
              'cleardoc', // 清空文档
              'insertparagraphbeforetable', // "表格前插入行"
              'insertcode', //代码语言
              'fontfamily', // 字体
              'fontsize', // 字号
              // 'paragraph', // 段落格式
              'simpleupload', // 单图上传
              'insertimage', // 多图上传
              'edittable', // 表格属性
              'edittd', // 单元格属性
              // 'link', // 超链接
              // 'emotion', // 表情
              // 'spechars', // 特殊字符
              // 'searchreplace', // 查询替换
              // 'map', // Baidu地图
              // 'gmap', // Google地图
              // 'insertvideo', // 视频
              // 'help', // 帮助
              'justifyleft', // 居左对齐
              'justifyright', // 居右对齐
              'justifycenter', // 居中对齐
              'justifyjustify', // 两端对齐
              'forecolor', // 字体颜色
              'backcolor', // 背景色
              'insertorderedlist', // 有序列表
              'insertunorderedlist', // 无序列表
              // 'fullscreen', // 全屏
              'directionalityltr', // 从左向右输入
              'directionalityrtl', // 从右向左输入
              'rowspacingtop', // 段前距
              'rowspacingbottom', // 段后距
              // 'pagebreak', // 分页
              // 'insertframe', // 插入Iframe
              'imagenone', // 默认
              'imageleft', // 左浮动
              'imageright', // 右浮动
              // 'attachment', //附件
              'imagecenter', // 居中
              // 'wordimage', //图片转存
              'lineheight', // 行间距
              // 'edittip ', // 编辑提示
              // 'customstyle', // 自定义标题
              'autotypeset', // 自动排版
              // 'webapp', // 百度应用
              'touppercase', // 字母大写
              'tolowercase', // 字母小写
              // 'background', // 背景
              'template', // 模板
              // 'scrawl', // 涂鸦
              // 'music', // 音乐
              'inserttable'// 插入表格
              // 'drafts', // 从草稿箱加载
              // 'charts', // 图表
            ]
          ],
          // 初始容器高度
          initialFrameHeight: 400,
          // 初始容器宽度
          initialFrameWidth: "100%",
          // 上传文件接口
          enableAutoSave: true,
          autoHeightEnabled:false
        }
      }
    }
  }
</script>

<style scoped>
  .main-body{
    width: 90%;
    margin-left: 5%;
  }
  .top-title{
    float: left;
    font-size: 30px;
    color: #333333;
  }
  .button-row{
    text-align: center;
    margin-top: 30px;
    width: 100%;
  }
  .tips{
    border-radius: 5px;
    background: RGB(236,248,255);
    padding: 12px;
    margin-bottom: 20px;
    border: 5px solid RGB(236,248,255);
    border-left-color: RGB(80, 191, 255);
  }
  .editor{
    text-align: center;
  }
  .card{
    width: 90%;
    margin-left: 5%;
  }
</style>
