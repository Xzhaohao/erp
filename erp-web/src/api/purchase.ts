import request from '@/utils/request'

interface OrderListParams {
  page: Number;
  limit: Number;
  orderState?: Number;
  creater?: String;
  minTotal?: Number;
  maxTotal?: Number;
  minCreateTime?: String;
  maxCreateTime?: String;
  minOrderPrice?: Number;
  maxOrderPrice?: Number;
}

// 获取供应商列表
export const fetchOrderApi = (data: OrderListParams, type: number) => request({
  url: `/order/list/${type}`,
  method: 'POST',
  data
})
