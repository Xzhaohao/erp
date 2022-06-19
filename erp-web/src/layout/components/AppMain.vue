<template>
  <div class='app-main'>
    <!-- 带有切换动画，并且具备组件缓存的router-view -->
    <router-view v-slot="{ Component, route }">
      <transition name="fade-transform" mode="out-in">
        <keep-alive>
          <component :is="Component" :key="route.path" />
        </keep-alive>
      </transition>
    </router-view>
  </div>
</template>

<script setup>
import { watch } from 'vue'
import { useRoute } from 'vue-router'
import { useStore } from 'vuex'
import { isTags } from '@/utils/tags'

const route = useRoute()
const store = useStore()

const getTitle = (route) => {
  let title = ''
  if (!route.meta) {
    // 处理无 meta 的路由
    const pathArr = route.path.split('/')
    title = pathArr[pathArr.length - 1]
  } else {
    title = route.meta.title
  }
  return title
}

// 监听路由变化
watch(route, (to, from) => {
  if (!isTags(to.path)) return
  const { fullPath, meta, name, params, path, query } = to
  store.commit('app/addTagsViewList', {
    fullPath,
    meta,
    name,
    params,
    path,
    query,
    title: getTitle(to)
  })
},
{
  // 进入组件就触发
  immediate: true
})
</script>

<style lang='scss' scoped>
.app-main {
  min-height: calc(100vh - 50px - 43px);
  width: 100%;
  position: absolute;
  overflow: hidden;
  padding: 104px 20px 20px;
  box-sizing: border-box;
}
</style>
