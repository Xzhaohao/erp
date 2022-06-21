import type { FormInstance } from 'element-plus'
import { closedDialog, empForm } from './useDialog'
import { saveEmpApi, updateEmpApi } from '@/api/emp'
import { ElMessage } from 'element-plus/es'
import { fetchEmpList } from './useFetchEmpList'

const submit = (empFormEl: FormInstance | undefined) => {
  if (!empFormEl) return
  empFormEl.validate(async valid => {
    if (!valid) return

    if (empForm.value.id) {
      await updateEmpApi(empForm.value)
      ElMessage.success('修改成功！')
    } else {
      await saveEmpApi(empForm.value)
      ElMessage.success('添加成功！')
    }

    fetchEmpList()
    closedDialog(empFormEl)
  })
}

export {
  submit
}
