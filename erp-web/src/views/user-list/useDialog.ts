import { ref } from 'vue'
import { fetchAllDepApi } from '@/api/dep'
import type { FormInstance } from 'element-plus/es'

interface empFormData {
  name: string;
  mobile: string;
  password?: string;
  password2?: string;
  email: string;
  address: string;
  gender: number | unknown;
  depName: string;
  birthday: string;
  nation: string;
}

const title = ref<String>('')
const ac = ref<Number>()
const dialogVisible = ref<Boolean>(false)
const deps = ref<Array<any>>([])

const empForm = ref<empFormData>({
  name: '',
  mobile: '',
  password: '',
  password2: '',
  email: '',
  address: '',
  gender: undefined,
  depName: '',
  birthday: '',
  nation: ''
})

// 获取所有状态正常的部门
function fetchAllDep() {
  fetchAllDepApi().then((res: any) => {
    deps.value = res
  })
}

/**
 * 点击添加/修改员工按钮
 * @param type 1添加，其他是修改
 * @param data 需修改的原数据
 */
function showDialog(type: Number, data?: any) {
  if (type === 1) {
    title.value = '添加员工'
    ac.value = 1
  } else {
    title.value = '修改员工信息'
    ac.value = 2

    empForm.value = {
      address: data.address,
      birthday: data.birthday,
      depName: data.depName,
      email: data.email,
      gender: data.gender,
      mobile: data.mobile,
      name: data.name,
      nation: data.nation
    }
  }
  dialogVisible.value = true
  fetchAllDep()
}

// 关闭弹窗，并重置表单
function closedDialog(empFormEl: FormInstance | undefined) {
  dialogVisible.value = false
  if (!empFormEl) return
  empFormEl.resetFields()
}

export {
  title,
  ac,
  dialogVisible,
  empForm,
  deps,
  showDialog,
  closedDialog
}
