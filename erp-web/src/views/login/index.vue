<template>
  <div class="login-container">
    <el-form class="login-form" ref="loginFormRef" :model="loginForm" :rules="loginRules">
      <div class="title-container">
        <h3 class="title">登陆</h3>
      </div>

      <!--用户名-->
      <el-form-item prop="mobile">
        <span class="svg-container">
          <el-icon><User/></el-icon>
        </span>

        <el-input
          v-model="loginForm.mobile"
          autocomplete="off" placeholder="手机号"
          name="username" type="text"
        />
      </el-form-item>

      <!--密码-->
      <el-tooltip v-model:visible="capsTooltip" manual content="大写锁定已开启" placement="right">
        <el-form-item prop="password">
          <span class="svg-container">
            <el-icon><Lock/></el-icon>
          </span>

          <el-input
            v-model="loginForm.password"
            autocomplete="off"
            placeholder="密码"
            name="password"
            type="password"
            @blur="capsTooltip = false"
            @keyup="checkCapslock"
            show-password
          />
        </el-form-item>
      </el-tooltip>

      <el-button
        :loading="loading" @click="handleLogin(loginFormRef)"
        type='primary' size="large"
        style='width: 100%;margin-bottom: 30px;'
      >
        登陆
      </el-button>

    </el-form>

    <vcode :show="isShow" @success="onSuccess" @close="onClose"/>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { loginForm, loginRules } from './rules'
import type { FormInstance } from 'element-plus'
import Vcode from 'vue3-puzzle-vcode'

// 登陆相关
import { loading, isShow, handleLogin, onSuccess, onClose } from '@/views/login/useLoginHandle'

const loginFormRef = ref<FormInstance>()

// 键盘大写提示
const capsTooltip = ref(false)
const checkCapslock = (e: any) => {
  const { key } = e
  capsTooltip.value = key && key.length === 1 && (key >= 'A' && key <= 'Z')
}
</script>

<style scoped lang="scss">
@import "index";
</style>
