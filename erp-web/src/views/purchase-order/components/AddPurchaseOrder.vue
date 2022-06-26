<template>
  <el-dialog v-model="visible" title="添加采购订单" center width="60%" :show-close="false">
    <div class="head-row">
      <el-select placeholder="供应商">
        <el-option :label="item" :value="item" v-for="item in supplierList" :key="item"/>
      </el-select>
      <el-button @click="addParams" type="primary">添加订单项</el-button>
    </div>

    <el-table :data="params" border stripe style="width: 100%" show-summary :summary-method="getSummaries">
      <el-table-column label="商品类别" align="center" #default="{ row }">
        <el-select v-model="row.goodsType" placeholder="商品类别">
          <el-option label="桌子" value="桌子"/>
          <el-option label="袜子" value="袜子"/>
        </el-select>
      </el-table-column>

      <el-table-column label="商品名称" align="center" #default="{ row }">
        <el-select v-model="row.goodsName" placeholder="商品名称">
          <el-option label="桌子" value="桌子"/>
          <el-option label="袜子" value="袜子"/>
        </el-select>
      </el-table-column>

      <el-table-column prop="num" label="采购数量" align="center" #default="{ row }">
        <el-input v-model="row.num" placeholder="采购数量"/>
      </el-table-column>

      <el-table-column prop="price" label="单价/元" align="center" #default="{ row }">
        <el-input v-model="row.price" placeholder="单价"/>
      </el-table-column>

      <el-table-column label="合计" align="center" width="120" #default="{ row }">
        {{ row.num * row.price }} 元
      </el-table-column>

      <el-table-column label="操作" width="90" align="center" #default="{ $index }">
        <el-button @click="removeRow($index)" link size="small" type="danger">删除</el-button>
      </el-table-column>
    </el-table>

    <template #footer>
      <el-button @click="closedDialog(formRef)">取消</el-button>
      <el-button @click="submit(formRef)" type="success">入库</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import type { FormInstance } from 'element-plus'
import { supplierList, fetchAllSupplier } from '@/views/goods-type/useFetchGoodsType'

import { visible, closedDialog, submit } from './usePurchaseOrder'
// 表单参数
import { params, addParams, getSummaries, removeRow } from './usePatams'

const formRef = ref<FormInstance>()
fetchAllSupplier()
</script>

<style lang="scss" scoped>
.head-row {
  display: flex;
  justify-content: space-between;
  margin-bottom: 15px;
}
</style>
