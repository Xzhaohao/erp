import request from '@/utils/request'

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
