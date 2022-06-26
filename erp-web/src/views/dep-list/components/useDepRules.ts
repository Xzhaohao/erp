import { ref } from 'vue'

export const depRules = ref({
  name: [
    { required: true, message: '部门名称不能为空！', trigger: 'blur' }
  ],
  tele: [
    { required: true, message: '手机号不能为空！', trigger: 'blur' }
  ]
})
