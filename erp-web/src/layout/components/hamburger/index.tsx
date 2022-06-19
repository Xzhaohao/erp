import { defineComponent } from 'vue'
import { useStore } from 'vuex'
// @ts-ignore
import styles from './index.module.scss'
import { Expand, Fold } from '@element-plus/icons-vue'

export default defineComponent({
  name: 'hamburger',
  setup() {
    const store = useStore()

    const toggleClick = () => store.commit('app/triggerSidebarOpened')

    return () => {
      return <div class={styles['hamburger-container']} onClick={toggleClick}>
        <span id="guide-hamburger">
          <el-icon class={styles.hamburger}>
            { store.getters.sidebarOpened ? <Expand /> : <Fold /> }
          </el-icon>
        </span>
      </div>
    }
  }
})
