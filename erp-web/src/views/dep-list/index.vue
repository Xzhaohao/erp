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

      <el-button type="success" :icon="Plus">添加</el-button>
    </el-card>

    <el-card>
      <el-table :data="list" border stripe style="width: 100%" v-loading="loading">
        <el-table-column type="index" label="序号" width="60" align="center"/>
        <el-table-column prop="name" label="部门名称" align="center"/>
        <el-table-column prop="tele" label="电话" align="center"/>
        <el-table-column label="状态" align="center" #default="{ row }" width="100">
          <tag-status :title="row['statusText']" :status="Number(row['status'])" />
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" align="center"/>
        <el-table-column label="操作" width="140" align="center" #default="{ row }">
          <el-button link size="small" type="primary">修改</el-button>
          <el-button @click="deleteDep(row)" link size="small" type="primary">删除</el-button>
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
  </div>
</template>

<script setup lang="ts">
import Pagination from '@/components/Pagination/index.vue'
import TagStatus from '@/components/tag-status/'
import { Plus } from '@element-plus/icons-vue'
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

// 删除想过
import { deleteDep } from './useDeleteDep'

fetchDepList()
</script>

<style scoped lang="scss">
@import "@/styles/head-action.scss";
</style>
