<template>
  <div>
    <el-card class="head-action">
      <div class="head-action-left">
        <div>
          <el-input v-model="params.name" placeholder="姓名"/>
        </div>

        <div>
          <el-input v-model="params.mobile" placeholder="手机号"/>
        </div>

        <div>
          <el-select v-model="params.gender" placeholder="性别">
            <el-option label="男" value="1"/>
            <el-option label="女" value="2"/>
          </el-select>
        </div>

        <div>
          <el-select v-model="params.depName" placeholder="部门">
            <el-option :label="item" :value="item" v-for="item in deps" :key="item"/>
          </el-select>
        </div>

        <div>
          <el-button @click="fetchEmpList" type="primary">查询</el-button>
          <el-button @click="resetParams">清空</el-button>
        </div>
      </div>

      <div>
        <el-button type="primary">导入</el-button>
        <el-button type="info">导出</el-button>
        <el-button @click="showDialog(1)" type="success" :icon="Plus">新增</el-button>
        <el-button type="danger" disabled :icon="Delete">批量删除</el-button>
      </div>
    </el-card>

    <el-card>
      <el-table :data="list" border stripe style="width: 100%" v-loading="loading">
        <el-table-column type="selection" width="55" align="center"/>
        <el-table-column prop="name" label="姓名" align="center"/>
        <el-table-column prop="genderText" label="性别" align="center" width="70"/>
        <el-table-column prop="nation" label="民族" align="center" width="70"/>
        <el-table-column prop="mobile" label="手机号" align="center"/>
        <el-table-column prop="email" label="邮箱" align="center"/>
        <el-table-column prop="address" label="地址" align="center"/>
        <el-table-column prop="birthday" label="生日" align="center" width="120"/>
        <el-table-column prop="stateText" label="状态" align="center" width="80"/>
        <el-table-column prop="depName" label="部门" align="center" width="100"/>
        <el-table-column label="操作" width="170" align="center" #default="{ row }">
          <el-button @click="showDialog(2, row)" link size="small" type="warning">修改</el-button>
          <el-button @click="onShowRole(row)" link size="small" type="success">分配角色</el-button>
          <el-button @click="deleteEmp(row)" link size="small" type="danger">删除</el-button>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
      <Pagination
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        :page="page"
        :limit="limit"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </el-card>

    <!-- 添加/修改员工信息 对话框 -->
    <add-update />
    <!-- 分配角色 对话框 -->
    <roles-dialog v-model='roleDialogVisible' :role='selectUserRole'/>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { Plus, Delete } from '@element-plus/icons-vue'
import Pagination from '@/components/Pagination/index.vue'
import AddUpdate from './AddUpdate.vue'
import RolesDialog from './Roles.vue'

// 获取数据
import {
  list,
  page,
  limit,
  total,
  loading,
  params,
  fetchEmpList,
  resetParams,
  handleSizeChange,
  handleCurrentChange
} from './useFetchEmpList'

// 添加/修改员工
import { fetchAllDep, showDialog, deps } from './useDialog'
// 删除员工
import { deleteEmp } from './useDeleteEmp'

fetchEmpList()
fetchAllDep()

// 分配角色
const selectUserRole = ref([])
const roleDialogVisible = ref(false)
const onShowRole = (row: any) => {
  roleDialogVisible.value = true
  selectUserRole.value = row.roles
}
</script>

<style scoped lang="scss">
@import "@/styles/head-action.scss";
</style>
