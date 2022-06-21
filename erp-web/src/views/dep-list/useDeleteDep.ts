import { ElMessage, ElMessageBox } from 'element-plus/es'
import { fetchDepList } from './useFetchDepList'

function deleteDep(dep: any) {
  ElMessageBox.confirm(
    `你确定要删除 ${dep.name} 吗？`, { type: 'warning' }
  ).then(async () => {
    // await deleteEmpApi(row.id)
    ElMessage.success('删除成功！')
    fetchDepList()
  }).catch(err => err)
}

export {
  deleteDep
}
