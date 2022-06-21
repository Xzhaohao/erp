import type { FormInstance } from 'element-plus'
import { empForm } from './useDialog'

const submit = (empFormEl: FormInstance | undefined) => {
  if (!empFormEl) return
  empFormEl.validate(valid => {
    if (!valid) return

    // todo 发起API请求添加员工
    console.log(empForm.value)
  })
}

export {
  submit
}
