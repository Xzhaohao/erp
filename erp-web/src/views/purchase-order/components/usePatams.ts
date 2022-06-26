import { ref } from 'vue'
import { ElMessage } from 'element-plus/es'

// const initial = { goodsType: '', goodsName: '', num: 1, price: 0.00 }
const params = ref([
  { goodsType: '', goodsName: '', num: 1, price: 0.00 }
])

// 点击添加订单项
function addParams() {
  params.value.push({ goodsType: '', goodsName: '', num: 1, price: 0.00 })
}

// 删除订单项
function removeRow(index: any) {
  if (params.value.length <= 1) {
    return ElMessage.warning('别删了，只剩一个订单项了！')
  }
  params.value.splice(index, 1)
}

function getSummaries(param: any) {
  const { columns, data } = param
  const sums: string[] = []

  columns.forEach((column: any, index: any) => {
    if (index === 0) {
      sums[index] = '合计'
      return
    }

    // 商品总数
    const totalNumArr = data.map((item: any) => item.num)
    sums[2] = totalNumArr.reduce((pre: any, cur: any) => Number(pre) + Number(cur))

    // 总价
    const totalPriceArr = data.map((item: any) => item.num * item.price)
    const totalPrice = totalPriceArr.reduce((pre: any, cur: any) => pre + cur)
    sums[4] = totalPrice + ' 元'
  })

  return sums
}

export {
  params,
  addParams,
  getSummaries,
  removeRow
}
