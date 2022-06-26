import { ref } from 'vue'
import { DepFormData, updateDepApi } from '@/api/dep'
import type { FormInstance } from 'element-plus/es'
import { ElMessage } from 'element-plus/es'
import { fetchDepList } from '@/views/dep-list/useFetchDepList'

const updateDepDialog = ref<Boolean>(false)
const depForm = ref<DepFormData | unknown>(undefined)

function initForm(data: any) {
  depForm.value = {
    id: data.id,
    name: data.name,
    tele: data.tele,
    email: data.email,
    description: data.description
  }
  updateDepDialog.value = true
}

function closedDialog(formEl: FormInstance | undefined) {
  updateDepDialog.value = false
  if (!formEl) return
  formEl.resetFields()
}

function submit(formEl: FormInstance | undefined) {
  if (!formEl) return

  formEl.validate(async valid => {
    if (!valid) return

    await updateDepApi(depForm.value)
    ElMessage.success('添加成功！')
    closedDialog(formEl)
    fetchDepList()
  }).then()
}

export {
  updateDepDialog,
  depForm,
  closedDialog,
  submit,
  initForm
}
