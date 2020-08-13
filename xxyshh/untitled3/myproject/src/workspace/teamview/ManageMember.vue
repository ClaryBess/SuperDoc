<template>
  <el-container>
    <el-header>
      <div>
        <NavBar :headSrc="headUrl"></NavBar>
      </div>
    </el-header>
    <el-container>
       <el-aside width="15%">
        <team-side-bar1 currentindex='1'></team-side-bar1>
      </el-aside>
      <el-main style="width: 80%">
        <h2 class="h2color">管理成员</h2>
        <!-- :member=传入的团队成员 -->
        <!-- <member-list :members="teamMembers"></member-list> -->
        <member-list :members="teamMembers"></member-list>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from "@/components/NavBar";
import TeamSideBar1 from "./TeamSideBar1";
import MemberList from "./MemberList";

export default {
  name: 'ManageMember',
  components: { NavBar,TeamSideBar1,MemberList },
  data() {
    return{
      teamMembers:[ 
        {
          id: "1",
          name: "xxy",
        },
        {
          id: "2",
          name: "ljm",
        },
        {
          id: "3",
          name: "wsy",
        }
      ]
    }
  }
}
</script>

<style>
.h2color {
  color: #7093ff;
}
</style>
