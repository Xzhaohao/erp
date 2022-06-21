import request from '@/utils/request'

interface DepListParams {
  page: Number;
  limit: Number;
  tele?: String;
  depName?: String;
}

export const fetchDepListApi = (params: DepListParams) => request({
  url: '/dep/list',
  params
})
