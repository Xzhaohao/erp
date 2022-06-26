import request from '@/utils/request'

interface DepListParams {
  page: Number;
  limit: Number;
  tele?: String;
  depName?: String;
}

export interface DepFormData {
  id?: String;
  name: String;
  tele: String;
  email?: String;
  description?: String;
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

// 添加部门
export const saveDepApi = (data: DepFormData) => request({
  url: '/dep/save',
  method: 'POST',
  data
})

// 修改部门
export const updateDepApi = (data: DepFormData | unknown) => request({
  url: '/dep/update',
  method: 'PUT',
  data
})

// 删除部门
export const deleteDepApi = (id: string) => request({
  url: `/dep/delete/${id}`,
  method: 'DELETE'
})
