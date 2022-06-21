import { ref } from 'vue'

export interface LoginFormData {
  mobile: string;
  password: string;
}

export const loginForm = ref<LoginFormData>({
  mobile: '13555555555',
  password: 'liella123'
})

export interface LoginFormRules {
  mobile: ({
    required: boolean;
    message: string;
    trigger: string;
  } | {
    required: boolean;
    validator: (rule: LoginFormRules, value: string, callback: Function) => void;
    trigger: string;
  })[];

  password: ({
    required: boolean;
    message: string;
    trigger: string;
  } | {
    required: boolean;
    validator: (rule: LoginFormRules, value: string, callback: Function) => void;
    trigger: string;
  })[];
}

export const validateMobile = (rule: LoginFormRules, value: string, callback: Function) => {
  const regex = /^[1][3-9][0-9]{9}$/
  if (!regex.test(value)) {
    callback(new Error('手机号格式不合法！'))
  } else {
    callback()
  }
}

export const validatePassword = (rule: LoginFormRules, value: string, callback: Function) => {
  const regex = /^(?![\d]+$)(?![a-z]+$)(?![A-Z]+$)[\da-zA-z]{6,16}$/
  if (!regex.test(value)) {
    callback(new Error('密码至少包含数字，大、小写字母中的2种，且长度在6-16位之间！'))
  } else {
    callback()
  }
}

export const loginRules = ref<LoginFormRules>({
  mobile: [
    { required: true, message: '手机号不能为空！', trigger: 'blur' },
    { required: true, trigger: 'blur', validator: validateMobile }
  ],
  password: [
    { required: true, message: '密码不能为空！', trigger: 'blur' },
    { required: true, trigger: 'blur', validator: validatePassword }
  ]
})
