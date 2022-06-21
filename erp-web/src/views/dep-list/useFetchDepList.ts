import { ref } from 'vue'
import { fetchDepListApi } from '@/api/dep'

const list = ref([])
const total = ref(0)
const page = ref(1)
const limit = ref(10)
const loading = ref(false)

const params = ref({
  tele: '',
  depName: ''
})

function fetchDepList() {
  loading.value = true
  fetchDepListApi({
    page: page.value,
    limit: limit.value,
    depName: params.value.depName,
    tele: params.value.tele
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
    tele: '',
    depName: ''
  }
  fetchDepList()
}

// 显示条数改变
const handleSizeChange = (val: number) => {
  limit.value = val
  fetchDepList()
}

// 分页改变
const handleCurrentChange = (val: number) => {
  page.value = val
  fetchDepList()
}

export {
  list,
  total,
  page,
  limit,
  params,
  loading,
  fetchDepList,
  resetParams,
  handleSizeChange,
  handleCurrentChange
}
