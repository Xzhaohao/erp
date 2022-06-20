import { ref } from 'vue'
import { fetchEmpListApi } from '@/api/emp'

const list = ref([])
const total = ref(0)
const page = ref(1)
const limit = ref(10)

const fetchEmpList = async () => {
  const res: any = await fetchEmpListApi({ page: page.value, limit: limit.value })
  list.value = res.rows
  total.value = res.total
}

export {
  list,
  page,
  limit,
  total,
  fetchEmpList
}
