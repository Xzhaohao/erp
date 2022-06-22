<template>
  <div>
    <el-card class="head-action">
      <div class="head-action-left">
        <div>
          <span>类别名称：</span>
          <el-input v-model="params.name" placeholder="类别名称"/>
        </div>

        <div>
          <span>供应商：</span>
          <el-select v-model="params.supplierName" placeholder="供应商">
            <el-option :label="item" :value="item" v-for="item in supplierList" :key="item"/>
          </el-select>
        </div>

        <div>
          <el-button @click="fetchGoodsTypeList" type="primary">查询</el-button>
          <el-button @click="resetParams">清空</el-button>
        </div>
      </div>

      <el-button @click="showDialog(1)" type="success" :icon="Plus">添加</el-button>
    </el-card>

    <el-card>
      <el-table :data="list" border stripe style="width: 100%" v-loading="loading">
        <el-table-column type="index" width="60" label="#" align="center"/>
        <el-table-column prop="supplierName" label="供应商" align="center"/>
        <el-table-column prop="name" label="类别名称" align="center"/>
        <el-table-column prop="delFlagText" label="状态" align="center" width="100">
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" align="center"/>
        <el-table-column label="操作" width="140" align="center" #default="{ row }">
          <el-button @click="showDialog(2, row)" link size="small" type="warning">修改</el-button>
          <el-button @click="deleteGoodsType(row)" link size="small" type="danger">删除</el-button>
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

    <!-- 添加/修改商品类别 对话框 -->
    <add-update-dialog />
  </div>
</template>

<script setup lang="ts">
import { Plus } from '@element-plus/icons-vue'
import Pagination from '@/components/Pagination/index.vue'
import AddUpdateDialog from './components/AddUpdateGoodsType.vue'

import {
  list,
  page,
  limit,
  total,
  loading,
  params,
  supplierList,
  fetchGoodsTypeList,
  resetParams,
  handleCurrentChange,
  handleSizeChange
} from './useFetchGoodsType'

import { showDialog } from './components/useAddUpdate'

import { deleteGoodsType } from './components/useDeleteGoodsType'

fetchGoodsTypeList()
</script>

<style scoped lang="scss">
@import "@/styles/head-action.scss";
</style>
