import { ElMessage, ElMessageBox } from 'element-plus/es'
import { fetchSupplier } from '../useFetchSupplier'
import { deleteSupplierApi } from '@/api/goods'

export function deleteSupplier(row: any) {
  ElMessageBox.confirm(
    `你确定要删除【 ${row.name} 】吗？`, { type: 'warning' }
  ).then(async () => {
    await deleteSupplierApi(row.id)
    ElMessage.success('删除成功！')
    fetchSupplier()
  }).catch(err => err)
}
