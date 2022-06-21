import { defineComponent, PropType } from 'vue'

export default defineComponent({
  name: 'TagStatus',
  props: {
    status: {
      type: Number as PropType<number>,
      required: true
    },
    title: {
      type: String as PropType<string>,
      required: true
    }
  },
  setup(props) {
    return () => {
      return <el-tag
        style="border-color: transparent;"
        effect="dark"
        color={props.status === 0 ? '#31c27c' : '#ff5f9f'}
      >
        {props.title}
      </el-tag>
    }
  }
})
