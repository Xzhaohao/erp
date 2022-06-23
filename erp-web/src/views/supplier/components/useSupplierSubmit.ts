import type { FormInstance } from 'element-plus'
import { supplierForm, closedDialog } from './useAUSupplier'
import { ElMessage } from 'element-plus/es'
import { saveSupplierApi, updateSupplierApi } from '@/api/goods'
import { fetchSupplier } from '../useFetchSupplier'

export function submit(formEl: FormInstance | undefined) {
  if (!formEl) return

  formEl.validate(async valid => {
    if (!valid) return

    if (supplierForm.value.id) {
      await updateSupplierApi(supplierForm.value)
      ElMessage.success('修改成功！')
    } else {
      await saveSupplierApi(supplierForm.value)
      ElMessage.success('添加成功！')
    }

    fetchSupplier()
    closedDialog(formEl)
  }).then()
}
