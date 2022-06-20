<template>
  <div>
    <el-card class="head-action">
      <div class="head-action-left">
        <div>
          <el-input placeholder="姓名"/>
        </div>

        <div>
          <el-input placeholder="手机号"/>
        </div>

        <div>
          <el-select placeholder="性别">
            <el-option label="男" value="1"/>
            <el-option label="女" value="2"/>
          </el-select>
        </div>

        <div>
          <el-select placeholder="部门">
            <el-option label="销售部" value="1"/>
            <el-option label="财务部" value="2"/>
            <el-option label="技术部" value="3"/>
          </el-select>
        </div>

        <div>
          <el-button type="primary">查询</el-button>
          <el-button>清空</el-button>
        </div>
      </div>

      <div>
        <el-button type="primary">导入</el-button>
        <el-button type="info">导出</el-button>
        <el-button type="success" :icon="Plus">新增</el-button>
        <el-button type="danger" disabled :icon="Delete">批量删除</el-button>
      </div>
    </el-card>

    <el-card>
      <el-table :data="list" border stripe style="width: 100%">
        <el-table-column type="selection" width="55" align="center"/>
        <el-table-column prop="name" label="姓名" align="center"/>
        <el-table-column prop="gender" label="性别" align="center"/>
        <el-table-column prop="mobile" label="手机号" align="center"/>
        <el-table-column prop="email" label="邮箱" align="center"/>
        <el-table-column prop="address" label="地址" align="center"/>
        <el-table-column prop="birthday" label="生日" align="center"/>
        <el-table-column prop="depName" label="部门" align="center"/>
        <el-table-column label="操作" width="120" align="center">
          <el-button link size="small" type="primary">修改</el-button>
          <el-button link size="small" type="primary">删除</el-button>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
      <Pagination
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        :page="page"
        :limit="limit"
      />
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { Plus, Delete } from '@element-plus/icons-vue'
import Pagination from '@/components/Pagination/index.vue'

// 获取数据
import { list, page, limit, total, fetchEmpList } from './useFetchEmpList'

fetchEmpList()
</script>

<style scoped lang="scss">
@import "@/styles/head-action.scss";
</style>
