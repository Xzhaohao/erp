<template>
  <el-breadcrumb class="breadcrumb" separator="/">
    <transition-group name="breadcrumb">
      <el-breadcrumb-item v-for="(item, index) in breadcrumbData" :key="item.path">
      <span class="no-redirect" v-if="index === breadcrumbData.length - 1">
        {{ item.meta.title }}
      </span>
        <span class="redirect" v-else @click="onLinkClick(item)">
          {{ item.meta.title }}
        </span>
      </el-breadcrumb-item>
    </transition-group>
  </el-breadcrumb>
</template>

<script lang="ts" setup>
import { watch, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'

// 生成数组数据
const breadcrumbData: any = ref([])
const getBreadcrumbData = () => {
  breadcrumbData.value = route.matched.filter(item => item.meta && item.meta.title)
}

// 监听路由变化
const route = useRoute()
watch(route, () => getBreadcrumbData(), {
  immediate: true
})

const router = useRouter()
const onLinkClick = (item: any) => {
  router.push(item.path)
}
</script>

<style lang="scss" scoped>
.breadcrumb {
  display: inline-block;
  font-size: 14px;
  line-height: 50px;
  margin-left: 8px;

  :deep(.no-redirect) {
    color: #97a8be;
    cursor: text;
  }

  .redirect {
    color: #666;
    font-weight: 600;
    cursor: pointer;
  }

  .redirect:hover {
    color: #263445;
  }
}
</style>
