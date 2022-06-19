<template>
  <el-sub-menu v-if="route.children.length > 0" :index="route.path">
    <template #title>
      <menu-item :title="route.meta.title" />
    </template>
    <sidebar-item v-for="item in route.children" :key="item.path" :route="item" />
  </el-sub-menu>
  <el-menu-item v-else :index="route.path">
    <menu-item :title="route.meta.title" />
  </el-menu-item>
</template>

<script lang="ts" setup>
import { defineProps } from 'vue'
import MenuItem from './MenuItem'

defineProps({
  route: {
    type: Object,
    required: true
  }
})
</script>
