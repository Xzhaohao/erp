import { defineComponent, PropType } from 'vue'
import { useRouter } from 'vue-router'
import { useStore } from 'vuex'
// @ts-ignore
import styles from './ContextMenu.module.scss'

export default defineComponent({
  name: 'ContextMenu',
  props: {
    index: {
      type: Number as PropType<number>,
      required: true
    }
  },

  setup(props) {
    const router = useRouter()
    const store = useStore()

    const onRefreshClick = () => router.go(0)

    const onCloseRightClick = () => {
      store.commit('app/removeTagsView', {
        type: 'right',
        index: props.index
      })
    }

    const onCloseOtherClick = () => {
      store.commit('app/removeTagsView', {
        type: 'other',
        index: props.index
      })
    }

    return () => {
      return <ul class={styles['context-menu-container']}>
        <li onClick={onRefreshClick}>刷新</li>
        <li onClick={onCloseRightClick}>关闭右侧</li>
        <li onClick={onCloseOtherClick}>关闭其他</li>
      </ul>
    }
  }
})
