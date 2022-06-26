<template>
  <el-dialog v-model="addDepDialog" title="添加部门" width="40%" center :show-close="false">

    <el-form label-width="100px" :model="depForm" ref="depFormRef" :rules="depRules">
      <el-form-item label="部门名称" prop="name">
        <el-input v-model="depForm.name" placeholder="部门名称"/>
      </el-form-item>

      <el-form-item label="部门手机号" prop="tele">
        <el-input v-model="depForm.tele" placeholder="部门手机号"/>
      </el-form-item>

      <el-form-item label="部门邮箱" prop="email">
        <el-input v-model="depForm.email" placeholder="部门邮箱"/>
      </el-form-item>

      <el-form-item label="部门描述" prop="description">
        <el-input v-model="depForm.description" placeholder="部门描述"/>
      </el-form-item>
    </el-form>

    <template #footer>
      <el-button @click="closedDialog(depFormRef)">取消</el-button>
      <el-button @click="submit(depFormRef)" type="primary">添加</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { addDepDialog, depForm, closedDialog, submit } from './useAddDep'
import { depRules } from './useDepRules'
import type { FormInstance } from 'element-plus'

const depFormRef = ref<FormInstance>()
</script>
