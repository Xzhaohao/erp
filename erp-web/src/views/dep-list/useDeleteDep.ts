import { ElMessage, ElMessageBox } from 'element-plus/es'
import { fetchDepList } from './useFetchDepList'
import { deleteDepApi } from '@/api/dep'

export function deleteDep(dep: any) {
  ElMessageBox.confirm(
    `你确定要删除【 ${dep.name} 】吗？`, { type: 'warning' }
  ).then(async () => {
    await deleteDepApi(dep.id)
    ElMessage.success('删除成功！')
    fetchDepList()
  }).catch(err => err)
}
