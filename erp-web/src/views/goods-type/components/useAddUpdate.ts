import { ref } from 'vue'
import { GoodsTypeForm } from '@/api/goods'
import type { FormInstance } from 'element-plus/es'

const title = ref<String>('')
const dialogVisible = ref<Boolean>(false)

const goodsTypeForm = ref<GoodsTypeForm>({
  name: '',
  supplierName: ''
})

/**
 * 点击添加/修改员工按钮
 * @param type 1添加，其他是修改
 * @param data 需修改的原数据
 */
function showDialog(type: Number, data?: any) {
  if (type === 1) {
    title.value = '添加商品类别'
  } else {
    title.value = '修改商品类别'

    goodsTypeForm.value = {
      id: data.id,
      name: data.name,
      supplierName: data.supplierName
    }
  }

  dialogVisible.value = true
}

// 关闭弹窗，并重置表单
function closedDialog(goodsTypeFormEl: FormInstance | undefined) {
  dialogVisible.value = false
  if (!goodsTypeFormEl) return
  goodsTypeFormEl.resetFields()
}

export {
  title,
  dialogVisible,
  goodsTypeForm,
  showDialog,
  closedDialog
}
