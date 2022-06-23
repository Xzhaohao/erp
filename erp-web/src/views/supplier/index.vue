<template>
  <div>
    <el-card class="head-action">
      <div class="head-action-left">
        <div>
          <el-input v-model="params.name" placeholder="供应商"/>
        </div>

        <div>
          <el-input v-model="params.contact" placeholder="联系人"/>
        </div>

        <div>
          <el-input v-model="params.mobile" placeholder="联系电话"/>
        </div>

        <div>
          <el-select v-model="params.needs" placeholder="提货方式">
            <el-option label="送货" value="1"/>
            <el-option label="自提" value="2"/>
          </el-select>
        </div>

        <div>
          <el-button @click="fetchSupplier" type="primary">查询</el-button>
          <el-button @click="resetParams">清空</el-button>
        </div>
      </div>

      <el-button @click="showDialog(1)" type="success" :icon="Plus">添加</el-button>
    </el-card>

    <el-card>
      <el-table :data="list" border stripe style="width: 100%" v-loading="loading">
        <el-table-column type="index" width="60" label="#" align="center"/>
        <el-table-column prop="name" label="供应商" align="center"/>
        <el-table-column prop="address" label="地址" align="center"/>
        <el-table-column prop="contact" label="联系人" align="center" width="140"/>
        <el-table-column prop="mobile" label="联系电话" align="center" width="160"/>
        <el-table-column prop="needsText" label="送货方式" align="center" width="100"/>
        <el-table-column label="操作" width="150" align="center" #default="{ row }">
          <el-button @click="showDialog(2, row)" link size="small" type="warning">修改</el-button>
          <el-button @click="deleteSupplier(row)" link size="small" type="danger">删除</el-button>
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

    <supplier-dialog/>
  </div>
</template>

<script setup lang="ts">
import { Plus } from '@element-plus/icons-vue'
import Pagination from '@/components/Pagination/index.vue'
import SupplierDialog from './components/SupplierDialog.vue'

import {
  list,
  page,
  limit,
  total,
  loading,
  params,
  fetchSupplier,
  resetParams,
  handleSizeChange,
  handleCurrentChange
} from './useFetchSupplier'

// 添加/修改供应商
import { showDialog } from './components/useAUSupplier'
// 删除供应商
import { deleteSupplier } from './components/useDeleteSupplier'

fetchSupplier()
</script>

<style scoped lang="scss">
@import "@/styles/head-action.scss";
</style>
