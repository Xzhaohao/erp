import { ref } from 'vue'

interface GoodsTypeRules {
  name: {
    required: boolean, message: string, trigger: string
  }[];

  supplierName: {
    required: boolean, message: string, trigger: string
  }[]
}

export const goodsTypeRules = ref<GoodsTypeRules>({
  name: [
    { required: true, message: '商品类别名称不能为空！', trigger: 'blur' }
  ],
  supplierName: [
    { required: true, message: '请选择供应商！', trigger: 'change' }
  ]
})
