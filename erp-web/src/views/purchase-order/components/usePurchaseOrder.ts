import { ref } from 'vue'
import { FormInstance } from 'element-plus/es'

const visible = ref<Boolean>(false)

// 关闭弹窗，并重置表单
function closedDialog(formEl: FormInstance | undefined) {
  visible.value = false
  if (!formEl) return
  formEl.resetFields()
}

function submit(formEl: FormInstance | undefined) {}

export {
  visible,
  closedDialog,
  submit
}
