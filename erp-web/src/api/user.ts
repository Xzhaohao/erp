import request from '@/utils/request'

export const loginApi = (data: object) => request({
  url: '',
  method: 'POST',
  data
})

export const fetchUserInfoApi = () => request({
  url: ''
})

export const logoutApi = () => request({
  url: '/logout',
  method: 'POST'
})
