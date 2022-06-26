<template>
  <el-dialog v-model="dialogVisible" :title="title" center width="40%" :show-close="false">
    <el-form label-width="100px" :model="supplierForm" ref="supplierFormRef" :rules="supplierRules">
      <el-form-item label="供应商" prop="name">
        <el-input v-model="supplierForm.name" placeholder="供应商公司名称"/>
      </el-form-item>

      <el-form-item label="地址" prop="address">
        <el-input v-model="supplierForm.address" placeholder="供应商公司地址"/>
      </el-form-item>

      <el-form-item label="联系人" prop="contact">
        <el-input v-model="supplierForm.contact" placeholder="联系人"/>
      </el-form-item>

      <el-form-item label="联系方式" prop="mobile">
        <el-input v-model="supplierForm.mobile" placeholder="联系方式"/>
      </el-form-item>

      <el-form-item label="是否送货" prop="needs">
        <el-select v-model="supplierForm.needs" placeholder="是否送货">
          <el-option label="送货" value="1"/>
          <el-option label="自提" value="2"/>
        </el-select>
      </el-form-item>
    </el-form>

    <template #footer>
      <el-button @click="closedDialog(supplierFormRef)">取消</el-button>
      <el-button @click="submit(supplierFormRef)" type="success">提交</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import type { FormInstance } from 'element-plus'
import { title, dialogVisible, supplierForm, closedDialog } from './useAUSupplier'
import { supplierRules } from './useSupplierRules'
import { submit } from './useSupplierSubmit'

const supplierFormRef = ref<FormInstance>()
</script>

<style scoped lang="scss">
.el-select {
  width: 100%;
}
</style>
