import { defineComponent, computed } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { useStore } from 'vuex'
import { filterRoutes, generateMenus } from '@/utils/route'
import SidebarItem from './SidebarItem.vue'

export default defineComponent({
  name: 'SidebarMenu',
  setup() {
    // 路由信息
    const router = useRouter()
    const routes = computed(() => {
      const fRoutes = filterRoutes(router.getRoutes())
      return generateMenus(fRoutes)
    })

    // 默认激活项
    const route = useRoute()
    const activeMenu = computed(() => {
      const { path } = route
      return path
    })

    const store = useStore()

    return () => {
      return <>
        <el-menu
          collapse={!store.getters.sidebarOpened}
          unique-opened={true}
          default-active={activeMenu.value}
          active-text-color="#ffffff"
          background-color="#304156"
          text-color="#bfcbd9"
          router
        >
          {routes.value.map((item: any) => <SidebarItem key={item.path} route={item}/>)}
        </el-menu>
      </>
    }
  }
})
