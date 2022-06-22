import { ref } from 'vue'
import { fetchSupplierApi } from '@/api/goods'

const list = ref([])
const total = ref(0)
const page = ref(1)
const limit = ref(10)
const loading = ref(false)

const params = ref({
  name: '',
  mobile: '',
  contact: '',
  needs: undefined
})

// 获取供应商列表
function fetchSupplier() {
  loading.value = true
  fetchSupplierApi({
    page: page.value,
    limit: limit.value,
    name: params.value.name,
    mobile: params.value.mobile,
    contact: params.value.contact,
    needs: params.value.needs
  })
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
const resetParams = () => {
  params.value = {
    name: '',
    mobile: '',
    needs: undefined,
    contact: ''
  }
  fetchSupplier()
}

// 显示条数改变
const handleSizeChange = (val: number) => {
  limit.value = val
  fetchSupplier()
}

// 分页改变
const handleCurrentChange = (val: number) => {
  page.value = val
  fetchSupplier()
}

export {
  list,
  total,
  page,
  limit,
  loading,
  params,
  fetchSupplier,
  resetParams,
  handleSizeChange,
  handleCurrentChange
}
