import { ref } from 'vue'
import { fetchAllSupplierApi, fetchGoodsTypeApi } from '@/api/goods'
import { getCache, setCache } from '@/utils/storage'
import { SUPPLIER } from '@/constant'

const list = ref([])
const total = ref(0)
const page = ref(1)
const limit = ref(10)
const loading = ref(false)

const supplierList = ref([])

const params = ref({
  name: '',
  supplierName: ''
})

// 获取所有状态正常的供应商
export async function fetchAllSupplier() {
  let supplierCache: any = getCache(SUPPLIER)
  if (!supplierCache) {
    supplierCache = await fetchAllSupplierApi()
    setCache(SUPPLIER, supplierCache)
  }

  supplierList.value = supplierCache
}

function fetchGoodsTypeList() {
  loading.value = true
  fetchGoodsTypeApi({
    page: page.value,
    limit: limit.value,
    name: params.value.name,
    supplierName: params.value.supplierName
  })
    .then((res: any) => {
      list.value = res.rows
      total.value = res.total

      // 获取全部供应商
      fetchAllSupplier().then()
    })
    .finally(() => {
      setTimeout(() => {
        loading.value = false
      }, 200)
    })
}

// 重置查询条件
function resetParams() {
  params.value = { name: '', supplierName: '' }
  fetchGoodsTypeList()
}

// 显示条数改变
const handleSizeChange = (val: number) => {
  limit.value = val
  fetchGoodsTypeList()
}

// 分页改变
const handleCurrentChange = (val: number) => {
  page.value = val
  fetchGoodsTypeList()
}

export {
  list,
  total,
  page,
  limit,
  loading,
  params,
  supplierList,
  fetchGoodsTypeList,
  resetParams,
  handleSizeChange,
  handleCurrentChange
}
