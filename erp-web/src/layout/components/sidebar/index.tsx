import { defineComponent } from 'vue'
import { useStore } from 'vuex'
import SidebarMenu from './SidebarMenu'
// @ts-ignore
import styles from './index.module.scss'
const logo = require('@/assets/logo.png')

export default defineComponent({
  name: 'sidebar',
  setup() {
    const store = useStore()

    return () => {
      return <div>
        <div class={styles['logo-container']}>
          <img src={logo} alt="logo" class={styles.logo}/>
          { store.getters.sidebarOpened ? <h1 class={styles['logo-title']}>ERP系统</h1> : '' }
        </div>

        <el-scrollbar>
          <SidebarMenu/>
        </el-scrollbar>
      </div>
    }
  }
})
