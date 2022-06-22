<template>
  <div>
    <el-card class="head-action">
      <div class="head-action-left">
        <div class="form-warp">
          <el-row :gutter="20">
            <el-col :span="6">
              <el-input v-model="params.name" placeholder="商品名称"/>
            </el-col>

            <el-col :span="6">
              <el-select v-model="params.supplierName" placeholder="供应商">
                <el-option :label="item" :value="item" v-for="item in supplierList" :key="item"/>
              </el-select>
            </el-col>

            <el-col :span="6">
              <el-input v-model="params.producer" placeholder="生产厂家"/>
            </el-col>

            <el-col :span="6">
              <el-input v-model="params.unit" placeholder="单位"/>
            </el-col>
          </el-row>

          <div class="price-row">
            <div>
              <span class="price-label">进货价格：</span>
              <el-input v-model="params.minInPrice" placeholder="¥ 0.00"/>
              <span class="price-divider">-</span>
              <el-input v-model="params.maxInPrice" placeholder="¥ 9000.00"/>
            </div>

            <div style="margin-left: 15px">
              <span class="price-label">销售价格：</span>
              <el-input v-model="params.minOutPrice" placeholder="¥ 0.00"/>
              <span class="price-divider">-</span>
              <el-input v-model="params.maxOutPrice" placeholder="¥ 9000.00"/>
            </div>
          </div>
        </div>

        <div class="query-btn">
          <el-button @click="fetchGoodsList" type="primary">查询</el-button>
          <el-button @click="resetParams">清空</el-button>
        </div>
      </div>

      <el-button type="success" :icon="Plus">添加</el-button>
    </el-card>

    <el-card>
      <el-table :data="list" border stripe style="width: 100%" v-loading="loading">
        <el-table-column label="供应商" align="center" #default="{ row }">
          {{ row['goodsType'].supplierName }}
        </el-table-column>
        <el-table-column prop="name" label="商品名" align="center"/>
        <el-table-column prop="producer" label="生产厂家" align="center"/>
        <el-table-column prop="origin" label="产地" align="center" width="120"/>
        <el-table-column prop="unit" label="单位" align="center" width="60"/>
        <el-table-column prop="inPrice" label="进货价" align="center" width="120"/>
        <el-table-column prop="outPrice" label="销售价" align="center" width="130"/>
        <el-table-column prop="delFlagText" label="状态" align="center" width="90"/>
        <el-table-column label="操作" width="140" align="center">
          <el-button link size="small" type="warning">修改</el-button>
          <el-button link size="small" type="danger">删除</el-button>
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
  </div>
</template>

<script setup lang="ts">
import { Plus } from '@element-plus/icons-vue'
import Pagination from '@/components/Pagination/index.vue'

import {
  list,
  page,
  limit,
  total,
  loading,
  params,
  fetchGoodsList,
  handleCurrentChange,
  handleSizeChange,
  resetParams
} from './useFetchGoods'

// 供应商列表
import { supplierList } from '@/views/goods-type/useFetchGoodsType'

fetchGoodsList()
</script>

<style scoped lang="scss">
@import "index";
</style>
