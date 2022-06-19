<template>
  <div class='app-wrapper' :class='[$store.getters.sidebarOpened ? "openSidebar" : "hideSidebar"]'>
    <!-- 左侧菜单 -->
    <sidebar class='sidebar-container' style="background-color: #304156"/>

    <div class='main-container '>
      <div class='fixed-header'>
        <!-- 顶部 navbar -->
        <navbar/>
        <!-- tags -->
        <tags-view/>
      </div>

      <!-- 内容区 -->
      <app-main/>
    </div>
  </div>
</template>

<script lang="ts" setup>
import Navbar from './components/Navbar.vue'
import Sidebar from './components/sidebar/'
import AppMain from './components/AppMain.vue'
import TagsView from './components/tagsView/index.vue'
</script>

<style lang='scss' scoped>
@import '~@/styles/mixin.scss';
@import '~@/styles/variables.scss';

.app-wrapper {
  @include clearfix;
  position: relative;
  height: 100%;
  width: 100%;
}

.fixed-header {
  position: fixed;
  top: 0;
  right: 0;
  z-index: 1;
  width: calc(100% - #{$sideBarWidth});
  transition: width #{$sideBarDuration};
}

.hideSidebar .fixed-header {
  width: calc(100% - #{$hideSideBarWidth});
}
</style>
