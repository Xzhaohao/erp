<template>
  <el-dialog :model-value="modelValue" title="分配角色" @close="closed">
    <el-checkbox-group v-model="currentRoles">
      <el-checkbox v-for="item in roleList" :key="item.id" :label="item.roleName"/>
    </el-checkbox-group>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="closed">取消</el-button>
        <el-button type="primary" @click="onConfirm">确认</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { defineEmits, defineProps, PropType, ref, watch } from 'vue'
import { fetchRoleListApi } from '@/api/auth'

const props = defineProps({
  modelValue: {
    type: Boolean as PropType<boolean>,
    required: true
  },
  role: {
    type: Array as PropType<Array<object>>,
    required: true
  }
})

const emits = defineEmits(['update:modelValue'])

const closed = () => {
  emits('update:modelValue', false)
}

// 用户当前角色
const currentRoles: any = ref([])
watch(
  () => props.role,
  val => {
    if (val) {
      currentRoles.value = val.map((item: any) => item.roleName)
    }
  }
)

// 获取所有角色
const roleList: any = ref([])
const getRoleList = async () => {
  roleList.value = await fetchRoleListApi()
}
getRoleList()

const onConfirm = async () => {
  // await updateRoleApi()
  closed()
}
</script>
