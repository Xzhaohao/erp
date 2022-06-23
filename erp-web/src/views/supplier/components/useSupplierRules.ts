import { ref } from 'vue'

interface SupplierRules {
  name: {
    required: boolean, message: string, trigger: string
  }[];

  address: {
    required: boolean, message: string, trigger: string
  }[];

  contact: {
    required: boolean, message: string, trigger: string
  }[];

  mobile: {
    required: boolean, message: string, trigger: string
  }[];

  needs: {
    required: boolean, message: string, trigger: string
  }[]
}

export const supplierRules = ref<SupplierRules>({
  name: [
    { required: true, message: '供应商名称不能为空！', trigger: 'blur' }
  ],
  address: [
    { required: true, message: '供应商地址不能为空！', trigger: 'blur' }
  ],
  contact: [
    { required: true, message: '联系人不能为空！', trigger: 'blur' }
  ],
  mobile: [
    { required: true, message: '联系电话不能为空！', trigger: 'blur' }
  ],
  needs: [
    { required: true, message: '请选择送货方式！', trigger: 'change' }
  ]
})
