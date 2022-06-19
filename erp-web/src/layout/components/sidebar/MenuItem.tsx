import { defineComponent, PropType } from 'vue'
import { Menu } from '@element-plus/icons-vue'

export default defineComponent({
  name: 'MenuItem',
  props: {
    title: {
      type: String as PropType<string>,
      required: true
    }
  },

  setup(props) {
    return () => {
      return <>
        <el-icon><Menu/></el-icon>
        <span>{props.title}</span>
      </>
    }
  }
})
