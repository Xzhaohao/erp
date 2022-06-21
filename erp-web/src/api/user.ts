import request from '@/utils/request'
import { LoginFormData } from '@/views/login/rules'

export const loginApi = (data: LoginFormData) => request({
  url: '/sys/login',
  method: 'POST',
  data
})

export const fetchUserInfoApi = () => request({
  url: '/sys/profile'
})

export const logoutApi = () => request({
  url: '/sys/logout',
  method: 'POST'
})
