<template>
  <div>
    <el-card class="head-action">
      <div class="head-action-left">
        <div>
          <span>部门名称：</span>
          <el-input v-model="params.depName" placeholder="部门名称"/>
        </div>

        <div>
          <span>电话：</span>
          <el-input v-model="params.tele" placeholder="电话"/>
        </div>

        <div>
          <el-button @click="fetchDepList" type="primary">查询</el-button>
          <el-button @click="resetParams">清空</el-button>
        </div>
      </div>

      <el-button @click="addDepDialog = true" type="success" :icon="Plus">添加</el-button>
    </el-card>

    <el-card>
      <el-table :data="list" border stripe style="width: 100%" v-loading="loading">
        <el-table-column type="index" label="序号" width="60" align="center"/>
        <el-table-column prop="name" label="部门名称" align="center" width="140"/>
        <el-table-column prop="tele" label="电话" align="center" width="150"/>
        <el-table-column prop="email" label="邮箱" align="center" width="170"/>
        <el-table-column label="状态" align="center" #default="{ row }" width="100">
          <tag-status :title="row['statusText']" :status="Number(row['status'])"/>
        </el-table-column>
        <el-table-column prop="description" label="描述" align="center"/>
        <el-table-column label="操作" width="140" align="center" #default="{ row }">
          <el-button @click="initForm(row)" link size="small" type="primary">修改</el-button>
          <el-button @click="deleteDep(row)" link size="small" type="primary">删除</el-button>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
      <Pagination
        v-if="total > 0"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        :page="page"
        :limit="limit"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </el-card>

    <!-- 添加部门对话框 -->
    <add-dialog/>
    <!-- 修改部门对话框 -->
    <update-dialog/>
  </div>
</template>

<script setup lang="ts">
import Pagination from '@/components/Pagination/index.vue'
import TagStatus from '@/components/tag-status/'
import { Plus } from '@element-plus/icons-vue'
import AddDialog from './components/AddDialog.vue'
import UpdateDialog from './components/UpdateDialog.vue'
// 获取数据
import {
  list,
  page,
  limit,
  total,
  loading,
  params,
  fetchDepList,
  resetParams,
  handleSizeChange,
  handleCurrentChange
} from './useFetchDepList'

// 删除部门
import { deleteDep } from './useDeleteDep'
// 添加部门对话框
import { addDepDialog } from './components/useAddDep'
// 修改部门
import { initForm } from './components/useUpdateDep'

fetchDepList()
</script>

<style scoped lang="scss">
@import "@/styles/head-action.scss";
</style>
