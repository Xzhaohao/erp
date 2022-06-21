import request from '@/utils/request'

interface DepListParams {
  page: Number;
  limit: Number;
  tele?: String;
  depName?: String;
}

// 获取部门列表
export const fetchDepListApi = (params: DepListParams) => request({
  url: '/dep/list',
  params
})

// 获取所有状态正常的部门
export const fetchAllDepApi = () => request({
  url: '/dep/all'
})
