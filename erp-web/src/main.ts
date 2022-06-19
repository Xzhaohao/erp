import { createApp } from 'vue'
import App from './App'
import router from './router'
import store from './store'

// Element-Plus
import ElementPlus, { ElMessage } from 'element-plus'
import 'element-plus/dist/index.css'
// Element-Plus icon
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

// 指令
import installDirective from './directives'

// 初始化样式
import './styles/index.scss'

const app = createApp(App)

app.config.globalProperties.$message = ElMessage

installDirective(app)

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.use(router)
  .use(store)
  .use(ElementPlus)
  .mount('#app')
