import { ref } from 'vue'
import { fetchGoodsApi } from '@/api/goods'
import { ElMessage } from 'element-plus/es'
import { fetchAllSupplier } from '@/views/goods-type/useFetchGoodsType'

const list = ref([])
const total = ref(0)
const page = ref(1)
const limit = ref(10)
const loading = ref(false)

const initial = {
  name: '',
  supplierName: '',
  producer: '',
  unit: '',
  minInPrice: undefined,
  maxInPrice: undefined,
  minOutPrice: undefined,
  maxOutPrice: undefined
}
const params = ref({ ...initial })

function fetchGoodsList() {
  const minInPrice = params.value.minInPrice
  const maxInPrice = params.value.maxInPrice
  const minOutPrice = params.value.minOutPrice
  const maxOutPrice = params.value.maxOutPrice

  // 只允许输入数字
  if (
    (minInPrice && isNaN(minInPrice)) || (maxInPrice && isNaN(maxInPrice)) ||
    (minOutPrice && isNaN(minOutPrice)) || (maxOutPrice && isNaN(maxOutPrice))
  ) {
    return ElMessage.error('价格参数不合法！')
  }

  loading.value = true

  fetchGoodsApi({
    page: page.value,
    limit: limit.value,
    name: params.value.name,
    supplierName: params.value.supplierName,
    producer: params.value.producer,
    unit: params.value.unit,
    minInPrice,
    maxInPrice,
    minOutPrice,
    maxOutPrice
  })
    .then((res: any) => {
      list.value = res.rows
      total.value = res.total

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
  params.value = { ...initial }
  fetchGoodsList()
}

// 显示条数改变
const handleSizeChange = (val: number) => {
  limit.value = val
  fetchGoodsList()
}

// 分页改变
const handleCurrentChange = (val: number) => {
  page.value = val
  fetchGoodsList()
}

export {
  list,
  total,
  page,
  limit,
  loading,
  params,
  fetchGoodsList,
  handleSizeChange,
  handleCurrentChange,
  resetParams
}
