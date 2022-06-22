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
    name: 'system',
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
    name: 'goods',
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
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: [...publicRoutes, ...privateRoutes]
})

export default router
