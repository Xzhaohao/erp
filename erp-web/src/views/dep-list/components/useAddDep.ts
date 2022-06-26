import { ref } from 'vue'
import { ElMessage, FormInstance } from 'element-plus/es'
import { fetchDepList } from '../useFetchDepList'
import { DepFormData, saveDepApi } from '@/api/dep'

const addDepDialog = ref<Boolean>(false)

const depForm = ref<DepFormData>({
  name: '',
  tele: '',
  email: '',
  description: ''
})

// 关闭弹窗，并重置表单
function closedDialog(formEl: FormInstance | undefined) {
  addDepDialog.value = false
  if (!formEl) return
  formEl.resetFields()
}

function submit(formEl: FormInstance | undefined) {
  if (!formEl) return

  formEl.validate(async valid => {
    if (!valid) return

    await saveDepApi(depForm.value)
    ElMessage.success('添加成功！')
    closedDialog(formEl)
    fetchDepList()
  }).then()
}

export {
  addDepDialog,
  depForm,
  closedDialog,
  submit
}
