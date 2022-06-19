const { defineConfig } = require('@vue/cli-service')

const path = require('path')
const AutoImport = require('unplugin-auto-import/webpack')
const Components = require('unplugin-vue-components/webpack')
const { ElementPlusResolver } = require('unplugin-vue-components/resolvers')

function resolve(dir) {
  return path.join(__dirname, dir)
}

module.exports = defineConfig({
  transpileDependencies: true,
  configureWebpack: {
    plugins: [
      AutoImport({
        resolvers: [ElementPlusResolver()]
      }),
      Components({
        resolvers: [ElementPlusResolver()]
      })
    ],
    resolve: {
      alias: {
        '@': resolve('src')
      },
      fallback: {
        path: require.resolve('path-browserify')
      }
    }
  },
  devServer: {
    port: 3000,
    open: false
  },
  chainWebpack(config) {
    config
      .plugin('html')
      .tap(args => {
        args[0].title = 'ERP系统'
        return args
      })
  }
})
