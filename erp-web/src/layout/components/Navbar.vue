<template>
  <div class="navbar">
    <!-- 左侧折叠菜单 -->
    <hamburger class="hamburger-container"/>
    <!-- 面包屑 -->
    <breadcrumb class="breadcrumb-container"/>

    <div class="right-menu">
      <!-- 头像 -->
      <el-dropdown class="avatar-container" trigger="click">
        <div class="avatar-wrapper">
          <el-avatar shape="square" :size="40" src="$store.getters.userInfo.avatar"/>
          <el-icon><Tools /></el-icon>
        </div>
        <template #dropdown>
          <el-dropdown-menu class="user-dropdown">
            <router-link to="/">
              <el-dropdown-item>首页</el-dropdown-item>
            </router-link>
            <el-dropdown-item divided @click='logout'>退出登陆</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { useStore } from 'vuex'
import Hamburger from './hamburger'
import Breadcrumb from './breadcrumb/index.vue'

// 退出登陆
const store = useStore()
const logout = () => store.dispatch('user/logout', 1)
</script>

<style lang='scss' scoped>
@import "Navbar";
</style>
