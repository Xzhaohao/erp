<template>
  <el-card>
    <el-table :data="allRoles" border style="width: 100%">
      <el-table-column type="index" label="序号" width="60" align="center"/>
      <el-table-column prop="roleName" label="角色名称" align="center"/>
      <el-table-column prop="description" label="描述" align="center"/>
      <el-table-column prop="roleCode" label="角色编码" align="center"/>
      <el-table-column prop="createTime" label="创建时间" align="center"/>
      <el-table-column label="状态" width="120" align="center" #default="{ row }">
        <tag-status :title="row['delFlagText']" :status="Number(row['delFlag'])" />
      </el-table-column>
      <el-table-column label="操作" width="200" align="center">
        <el-button type="primary">分配权限</el-button>
      </el-table-column>
    </el-table>
  </el-card>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { fetchRoleListApi } from '@/api/auth'
import TagStatus from '@/components/tag-status/'

const allRoles: any = ref([])
const getRoleList = async () => {
  allRoles.value = await fetchRoleListApi()
}

getRoleList()
</script>

<style lang="scss" scoped>
</style>
