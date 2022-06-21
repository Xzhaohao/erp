import request from '@/utils/request'
import { empFormData } from '@/views/user-list/useDialog'

interface EmpListParams {
  page: Number;
  limit: Number;
  name?: String;
  mobile?: String;
  gender?: Number;
  depName?: String;
}

// 获取员工列表
export const fetchEmpListApi = (params: EmpListParams) => request({
  url: '/emp/list',
  params
})

// 添加员工
export const saveEmpApi = (data: empFormData) => request({
  url: '/emp/save',
  method: 'POST',
  data
})

// 修改员工信息
export const updateEmpApi = (data: empFormData) => request({
  url: '/emp/update',
  method: 'PUT',
  data
})
