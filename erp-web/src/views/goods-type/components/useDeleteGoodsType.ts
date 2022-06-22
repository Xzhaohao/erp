import { ElMessage, ElMessageBox } from 'element-plus/es'
import { fetchGoodsTypeList } from '../useFetchGoodsType'
import { deleteGoodsTypeApi } from '@/api/goods'

export function deleteGoodsType(row: any) {
  ElMessageBox.confirm(
    `你确定要删除【 ${row.name} 】吗？`, { type: 'warning' }
  ).then(async () => {
    await deleteGoodsTypeApi(row.id)
    ElMessage.success('删除成功！')
    fetchGoodsTypeList()
  }).catch(err => err)
}
