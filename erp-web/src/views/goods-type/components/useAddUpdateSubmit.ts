import type { FormInstance } from 'element-plus'
import { goodsTypeForm, closedDialog } from './useAddUpdate'
import { ElMessage } from 'element-plus/es'
import { fetchGoodsTypeList } from '../useFetchGoodsType'
import { saveGoodsTypeApi, updateGoodsTypeApi } from '@/api/goods'

export function submit(formEl: FormInstance | undefined) {
  if (!formEl) return

  formEl.validate(async valid => {
    if (!valid) return

    if (goodsTypeForm.value.id) {
      await updateGoodsTypeApi(goodsTypeForm.value)
      ElMessage.success('修改成功！')
    } else {
      await saveGoodsTypeApi(goodsTypeForm.value)
      ElMessage.success('添加成功！')
    }

    fetchGoodsTypeList()
    closedDialog(formEl)
  }).then()
}
