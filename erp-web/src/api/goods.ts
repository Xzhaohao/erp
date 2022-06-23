import request from '@/utils/request'

interface SupplierListParams {
  page: Number;
  limit: Number;
  name?: String;
  mobile?: String;
  needs?: Number;
  contact?: String;
}

export interface SaveSupplierForm {
  id?: string;
  name: string;
  address: string;
  contact: string;
  mobile: string;
  needs: number | unknown;
}

interface GoodsTypeParams {
  page: Number;
  limit: Number;
  name?: String;
  supplierName?: String;
}

export interface GoodsTypeForm {
  id?: String;
  name: String;
  supplierName: String;
}

interface GoodsParams {
  page: Number;
  limit: Number;
  name?: String;
  supplierName?: String;
  producer?: String;
  unit?: String;
  minInPrice?: Number;
  maxInPrice?: Number;
  minOutPrice?: Number;
  maxOutPrice?: Number;
}

// 获取供应商列表
export const fetchSupplierApi = (params: SupplierListParams) => request({
  url: '/supplier/list',
  params
})

// 获取全部供应商数组
export const fetchAllSupplierApi = () => request({
  url: '/supplier/all'
})

// 添加供应商
export const saveSupplierApi = (data: SaveSupplierForm) => request({
  url: '/supplier/save',
  method: 'POST',
  data
})

// 修改供应商
export const updateSupplierApi = (data: SaveSupplierForm) => request({
  url: '/supplier/update',
  method: 'PUT',
  data
})

// 删除
export const deleteSupplierApi = (id: string) => request({
  url: `/supplier/delete/${id}`,
  method: 'DELETE'
})

// 商品类别列表
export const fetchGoodsTypeApi = (params: GoodsTypeParams) => request({
  url: '/goodsType/list',
  params
})

// 添加商品类别
export const saveGoodsTypeApi = (data: GoodsTypeForm) => request({
  url: '/goodsType/save',
  method: 'POST',
  data
})

// 添加商品类别
export const updateGoodsTypeApi = (data: GoodsTypeForm) => request({
  url: '/goodsType/update',
  method: 'PUT',
  data
})

// 删除商品类别
export const deleteGoodsTypeApi = (id: string) => request({
  url: `/goodsType/delete/${id}`,
  method: 'DELETE'
})

// 商品列表
export const fetchGoodsApi = (params: GoodsParams) => request({
  url: '/goods/list',
  params
})
