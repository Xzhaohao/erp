import { ElMessage, ElMessageBox } from 'element-plus/es'
import { fetchEmpList } from './useFetchEmpList'

function deleteEmp(emp: any) {
  ElMessageBox.confirm(
    `你确定要删除 ${emp.name} 吗？`, { type: 'warning' }
  ).then(async () => {
    // await deleteEmpApi(row.id)
    ElMessage.success('删除成功！')
    fetchEmpList()
  })
}

export {
  deleteEmp
}
