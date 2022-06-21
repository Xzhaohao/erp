import { ref } from 'vue'
import { fetchEmpListApi } from '@/api/emp'

const list = ref([])
const total = ref(0)
const page = ref(1)
const limit = ref(10)
const loading = ref(false)

const params = ref({
  name: '',
  mobile: '',
  gender: undefined,
  depName: ''
})

// 获取员工列表
const fetchEmpList = () => {
  loading.value = true
  fetchEmpListApi({
    page: page.value,
    limit: limit.value,
    name: params.value.name,
    mobile: params.value.mobile,
    gender: params.value.gender,
    depName: params.value.depName
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
    gender: undefined,
    depName: ''
  }
  fetchEmpList()
}

// 显示条数改变
const handleSizeChange = (val: number) => {
  limit.value = val
  fetchEmpList()
}

// 分页改变
const handleCurrentChange = (val: number) => {
  page.value = val
  fetchEmpList()
}

export {
  list,
  page,
  limit,
  total,
  loading,
  params,
  fetchEmpList,
  resetParams,
  handleSizeChange,
  handleCurrentChange
}
