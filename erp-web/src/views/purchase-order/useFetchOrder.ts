import { ref } from 'vue'
import { ElMessage } from 'element-plus/es'
import { fetchOrderApi } from '@/api/purchase'

const list = ref([])
const total = ref(0)
const page = ref(1)
const limit = ref(10)
const loading = ref(false)

const initial = {
  orderState: undefined,
  creater: '',
  minTotal: undefined,
  maxTotal: undefined,
  createTime: '',
  minOrderPrice: undefined,
  maxOrderPrice: undefined
}
const params = ref({ ...initial })

function fetchOrderList() {
  const minTotal = params.value.minTotal
  const maxTotal = params.value.maxTotal
  const minOrderPrice = params.value.minOrderPrice
  const maxOrderPrice = params.value.maxOrderPrice

  // 只允许输入数字
  if (
    (minTotal && isNaN(minTotal)) || (maxTotal && isNaN(maxTotal)) ||
    (minOrderPrice && isNaN(minOrderPrice)) || (maxOrderPrice && isNaN(maxOrderPrice))
  ) {
    return ElMessage.error('价格参数不合法！')
  }

  loading.value = true

  let minCreateTime
  let maxCreateTime
  if (params.value.createTime.length > 0) {
    minCreateTime = params.value.createTime[0]
    maxCreateTime = params.value.createTime[1]
  }

  fetchOrderApi({
    page: page.value,
    limit: limit.value,
    orderState: params.value.orderState,
    creater: params.value.creater,
    minTotal,
    maxTotal,
    minCreateTime,
    maxCreateTime,
    minOrderPrice,
    maxOrderPrice
  }, 1)
    .then((res: any) => {
      list.value = res.rows
      total.value = res.total
    })
    .finally(() => {
      setTimeout(() => {
        loading.value = false
      }, 200)
    })
}

// 重置查询条件
function resetParams() {
  params.value = { ...initial }
  fetchOrderList()
}

// 显示条数改变
const handleSizeChange = (val: number) => {
  limit.value = val
  fetchOrderList()
}

// 分页改变
const handleCurrentChange = (val: number) => {
  page.value = val
  fetchOrderList()
}

export {
  list,
  total,
  page,
  limit,
  loading,
  params,
  fetchOrderList,
  resetParams,
  handleSizeChange,
  handleCurrentChange
}
