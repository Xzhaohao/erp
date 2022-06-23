import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Layout from '@/layout/index.vue'

// 公共路由
export const publicRoutes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/dashboard',
    name: 'Layout',
    component: Layout,
    children: [
      {
        path: '/dashboard',
        name: 'dashboard',
        component: () => import('@/views/dashboard/index.vue'),
        meta: { title: '仪表盘' }
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/login/index.vue')
  },
  {
    path: '/:catchAll(.*)',
    name: '/404',
    component: () => import('@/views/404.vue')
  }
]

// 私有路由
export const privateRoutes: Array<RouteRecordRaw> = [
  {
    path: '/system',
    name: 'systemManage',
    redirect: '/sys/role',
    component: () => Layout,
    meta: { title: '系统管理' },
    children: [
      {
        path: '/sys/role',
        name: 'roleList',
        component: () => import('@/views/role-list/index.vue'),
        meta: { title: '角色管理' }
      },
      {
        path: '/sys/user',
        name: 'userList',
        component: () => import('@/views/user-list/index.vue'),
        meta: { title: '员工管理' }
      },
      {
        path: '/sys/dep',
        name: 'depList',
        component: () => import('@/views/dep-list/index.vue'),
        meta: { title: '部门管理' }
      }
    ]
  },
  {
    path: '/goods',
    name: 'goodsManage',
    redirect: '/goods/supplier',
    component: () => Layout,
    meta: { title: '商品管理' },
    children: [
      {
        path: '/goods/supplier',
        name: 'Supplier',
        component: () => import('@/views/supplier/index.vue'),
        meta: { title: '供应商' }
      },
      {
        path: '/goods/type',
        name: 'GoodsType',
        component: () => import('@/views/goods-type/index.vue'),
        meta: { title: '商品类别' }
      },
      {
        path: '/goods/list',
        name: 'GoodsList',
        component: () => import('@/views/goods-list/index.vue'),
        meta: { title: '商品列表' }
      }
    ]
  },
  {
    path: '/purchase',
    name: 'purchaseManage',
    redirect: '/purchase/order',
    component: () => Layout,
    meta: { title: '采购管理' },
    children: [
      {
        path: '/purchase/order',
        name: 'purchaseOrder',
        component: () => import('@/views/purchase-order/index.vue'),
        meta: { title: '采购订单' }
      },
      {
        path: '/purchase/reject',
        name: 'purchaseReject',
        component: () => import('@/views/purchase-reject/index.vue'),
        meta: { title: '采购退货' }
      },
      {
        path: '/purchase/approve',
        name: 'purchaseApprove',
        component: () => import('@/views/purchase-approve/index.vue'),
        meta: { title: '采购审批' }
      }
    ]
  },
  {
    path: '/sale',
    name: 'saleManage',
    redirect: '/sale/order',
    component: () => Layout,
    meta: { title: '销售管理' },
    children: [
      {
        path: '/sale/order',
        name: 'saleOrder',
        component: () => import('@/views/sale-order/index.vue'),
        meta: { title: '销售订单' }
      },
      {
        path: '/sale/reject',
        name: 'saleReject',
        component: () => import('@/views/sale-reject/index.vue'),
        meta: { title: '销售退货' }
      },
      {
        path: '/sale/approve',
        name: 'saleApprove',
        component: () => import('@/views/sale-approve/index.vue'),
        meta: { title: '销售审批' }
      }
    ]
  },
  {
    path: '/transport',
    name: 'goodsTransport',
    redirect: '/transport/appoint',
    component: () => Layout,
    meta: { title: '商品运输' },
    children: [
      {
        path: '/transport/list',
        name: 'transportList',
        component: () => import('@/views/transport-list/index.vue'),
        meta: { title: '运输任务列表' }
      },
      {
        path: '/transport/appoint',
        name: 'transportAppoint',
        component: () => import('@/views/transport-appoint/index.vue'),
        meta: { title: '运输任务指派' }
      }
    ]
  },
  {
    path: '/depot',
    name: 'depotManage',
    redirect: '/depot/list',
    component: () => Layout,
    meta: { title: '仓库管理' },
    children: [
      {
        path: '/depot/stocks',
        name: 'depotStocks',
        component: () => import('@/views/depot-stocks/index.vue'),
        meta: { title: '库存查询' }
      },
      {
        path: '/depot/in',
        name: 'depotIn',
        component: () => import('@/views/depot-in/index.vue'),
        meta: { title: '入库' }
      },
      {
        path: '/depot/out',
        name: 'depotOut',
        component: () => import('@/views/depot-out/index.vue'),
        meta: { title: '出库' }
      },
      {
        path: '/depot/operate',
        name: 'depotOperate',
        component: () => import('@/views/depot-operate/index.vue'),
        meta: { title: '仓库操作明细' }
      }
    ]
  },
  {
    path: '/report',
    name: 'reportManage',
    redirect: '/report/in',
    component: () => Layout,
    meta: { title: '报表中心' },
    children: [
      {
        path: '/report/in',
        name: 'reportIn',
        component: () => import('@/views/report-in/index.vue'),
        meta: { title: '进货报表' }
      },
      {
        path: '/report/sale',
        name: 'reportSale',
        component: () => import('@/views/report-sale/index.vue'),
        meta: { title: '销售报表' }
      },
      {
        path: '/report/depot',
        name: 'reportDepot',
        component: () => import('@/views/report-depot/index.vue'),
        meta: { title: '仓库报表' }
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: [...publicRoutes, ...privateRoutes]
})

export default router
