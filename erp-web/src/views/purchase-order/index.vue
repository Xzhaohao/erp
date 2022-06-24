<template>
  <div>
    <el-card class="head-action">
      <div class="head-action-left">
        <div class="form-warp">
          <div class="row">
            <div class="col">
              <span class="input-label">下单人：</span>
              <el-input v-model="params.creater" placeholder="下单人"/>
            </div>

            <div class="col p-lr20">
              <span class="input-label">状态：</span>
              <el-select v-model="params.orderState" placeholder="订单状态">
                <el-option label="未审核" value="1"/>
                <el-option label="审核未通过" value="2"/>
                <el-option label="审核通过" value="3"/>
              </el-select>
            </div>

            <div class="col">
              <span class="input-label">总量：</span>
              <el-input v-model="params.minTotal" placeholder="最小订单商品总数"/>
              <span class="divider">-</span>
              <el-input v-model="params.maxTotal" placeholder="最大订单商品总数"/>
            </div>
          </div>

          <div class="row">
            <div class="col" style="padding-right: 52px;">
              <span class="input-label" style="width: 175px;">下单时间：</span>
              <el-date-picker
                v-model="params.createTime"
                type="daterange"
                range-separator="-"
                start-placeholder="下单时间区间"
                end-placeholder="下单时间区间"
                value-format="YYYY-MM-DD"
              />
            </div>

            <div class="col">
              <span class="input-label" style="width: 135px;">总金额：</span>
              <el-input v-model="params.minOrderPrice" placeholder="最小订单商品总金额"/>
              <span class="divider">-</span>
              <el-input v-model="params.maxOrderPrice" placeholder="最大订单商品总金额"/>
            </div>
          </div>
        </div>

        <div class="query-btn">
          <el-button @click="fetchOrderList" type="primary">查询</el-button>
          <el-button @click="resetParams">清空</el-button>
        </div>
      </div>

      <el-button type="success" :icon="Plus">添加</el-button>
    </el-card>

    <el-card>
      <el-table :data="list" border stripe style="width: 100%" v-loading="loading">
        <el-table-column prop="orderNum" label="订单号" align="center"/>
        <el-table-column prop="supplierName" label="供应商" align="center"/>
        <el-table-column prop="creater" label="制单人" align="center"/>
        <el-table-column prop="createTime" label="制单时间" align="center"/>
        <el-table-column prop="total" label="商品总数" align="center"/>
        <el-table-column prop="orderPrice" label="订单总价" align="center"/>
        <el-table-column prop="orderState" label="订单状态" align="center"/>
        <el-table-column label="操作" width="140" align="center">
          <el-button link size="small" type="warning">详情</el-button>
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
  page,
  limit,
  list,
  total,
  loading,
  params,
  fetchOrderList,
  resetParams,
  handleCurrentChange,
  handleSizeChange
} from './useFetchOrder'

fetchOrderList()
</script>

<style scoped lang="scss">
@import "index";
</style>
