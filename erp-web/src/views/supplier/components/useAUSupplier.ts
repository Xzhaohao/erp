import { ref } from 'vue'
import { SaveSupplierForm } from '@/api/goods'
import type { FormInstance } from 'element-plus/es'

const title = ref<String>('')
const dialogVisible = ref<Boolean>(false)

const initial = {
  name: '',
  address: '',
  contact: '',
  mobile: '',
  needs: undefined
}
const supplierForm = ref<SaveSupplierForm>({ ...initial })

/**
 * 点击添加/修改员工按钮
 * @param type 1添加，其他是修改
 * @param data 需修改的原数据
 */
function showDialog(type: Number, data?: any) {
  if (type === 1) {
    title.value = '添加供应商'
  } else {
    title.value = '修改供应商'

    supplierForm.value = {
      id: data.id,
      name: data.name,
      address: data.address,
      contact: data.contact,
      mobile: data.mobile,
      needs: data.needs
    }
  }

  dialogVisible.value = true
}

// 关闭弹窗，并重置表单
function closedDialog(formEl: FormInstance | undefined) {
  dialogVisible.value = false
  if (!formEl) return
  supplierForm.value = { ...initial }
  formEl.resetFields()
}

export {
  title,
  dialogVisible,
  supplierForm,
  showDialog,
  closedDialog
}
