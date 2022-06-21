<template>
  <el-dialog v-model="dialogVisible" :title="title" center width="60%">
    <el-form label-width="80px" :model="empForm" ref="empFormRef" :rules="empRules">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="empForm.name" placeholder="姓名"/>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="手机号" prop="mobile">
            <el-input v-model="empForm.mobile" placeholder="手机号"/>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :gutter="20" v-if="ac === 1">
        <el-col :span="12">
          <el-form-item label="密码" prop="password">
            <el-input type="password" show-password v-model="empForm.password" placeholder="密码"/>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="确认密码" prop="password2">
            <el-input type="password" show-password v-model="empForm.password2" placeholder="确认密码"/>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="电子邮箱" prop="email">
            <el-input v-model="empForm.email" placeholder="电子邮箱"/>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="地址" prop="address">
            <el-input v-model="empForm.address" placeholder="地址"/>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="性别" prop="gender">
            <el-select v-model="empForm.gender" placeholder="性别">
              <el-option label="男" value="1"/>
              <el-option label="女" value="2"/>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="部门" prop="depName">
            <el-select v-model="empForm.depName" placeholder="部门">
              <el-option :label="item" :value="item" v-for="item in deps" :key="item"/>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="出生日期" prop="birthday">
            <el-date-picker v-model="empForm.birthday" type="date" placeholder="出生日期"/>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="民族" prop="nation">
            <el-select v-model="empForm.nation" placeholder="民族">
              <el-option :label="item" :value="item" v-for="item in nation" :key="item"/>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>

    <template #footer>
      <el-button @click="closedDialog(empFormRef)">取消</el-button>
      <el-button @click="submit(empFormRef)" type="success">提交</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { title, ac, dialogVisible, empForm, deps, closedDialog } from './useDialog'
import { empRules } from './useDialogRules'
import { submit } from './useDialogSubmit'
import { nation } from '@/constant/nation'
import type { FormInstance } from 'element-plus'

const empFormRef = ref<FormInstance>()
</script>

<style scoped lang="scss">
.el-select, :deep(.el-input), :deep(.el-input__wrapper) {
  width: 100%;
}
</style>
