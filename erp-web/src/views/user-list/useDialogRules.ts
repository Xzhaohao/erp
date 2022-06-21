import { ref } from 'vue'
import { validateMobile, validatePassword } from '@/views/login/rules'
import { empForm } from './useDialog'

const validatePassword2 = (rule: any, value: string, callback: Function) => {
  if (value !== empForm.value.password) {
    callback(new Error('两次输入的密码不一致！'))
  } else {
    callback()
  }
}

export const empRules = ref({
  name: [
    { required: true, message: '姓名不能为空！', trigger: 'blur' }
  ],
  mobile: [
    { required: true, message: '手机号不能为空！', trigger: 'blur' },
    { required: true, trigger: 'blur', validator: validateMobile }
  ],
  password: [
    { required: true, message: '密码不能为空！', trigger: 'blur' },
    { required: true, trigger: 'blur', validator: validatePassword }
  ],
  password2: [
    { required: true, message: '确认密码不能为空！', trigger: 'blur' },
    { required: true, trigger: 'blur', validator: validatePassword2 }
  ],
  email: [
    { required: true, message: '邮箱不能为空！', trigger: 'blur' }
  ],
  address: [
    { required: true, message: '地址不能为空！', trigger: 'blur' }
  ],
  gender: [
    { required: true, message: '请选择性别！', trigger: 'change' }
  ],
  depName: [
    { required: true, message: '请选择部门！', trigger: 'change' }
  ],
  birthday: [
    { type: 'date', required: true, message: '请填写生日！', trigger: 'change' }
  ],
  nation: [
    { required: true, message: '请选择民族！', trigger: 'change' }
  ]
})
