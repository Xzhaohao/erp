import request from '@/utils/request'

export interface empFormData {
  id?: string;
  name: string;
  mobile: string;
  password?: string;
  password2?: string;
  email: string;
  address: string;
  gender: number | unknown;
  depName: string;
  birthday: string;
  nation: string;
}

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
