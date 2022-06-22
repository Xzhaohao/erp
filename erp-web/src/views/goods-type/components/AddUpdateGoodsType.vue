<template>
  <el-dialog v-model="dialogVisible" :title="title" center width="45%">
    <el-form label-width="120px" :model="goodsTypeForm" ref="goodsTypeFormRef" :rules="goodsTypeRules">
      <el-form-item label="供应商" prop="supplierName">
        <el-select v-model="goodsTypeForm.supplierName" placeholder="供应商">
          <el-option :label="item" :value="item" v-for="item in supplierList" :key="item"/>
        </el-select>
      </el-form-item>

      <el-form-item label="商品类别名称" prop="name">
        <el-input v-model="goodsTypeForm.name" placeholder="商品类别名称"/>
      </el-form-item>
    </el-form>

    <template #footer>
      <el-button @click="closedDialog(goodsTypeFormRef)">取消</el-button>
      <el-button @click="submit(goodsTypeFormRef)" type="success">提交</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { title, dialogVisible, goodsTypeForm, closedDialog } from './useAddUpdate'
import { supplierList } from '../useFetchGoodsType'
import { goodsTypeRules } from './useAddUpdateRules'
import { submit } from './useAddUpdateSubmit'
import type { FormInstance } from 'element-plus'

const goodsTypeFormRef = ref<FormInstance>()
</script>

<style scoped lang="scss">
.el-select {
  width: 100%;
}
</style>
