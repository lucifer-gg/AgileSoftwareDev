const path = require('path')
function resolve (dir) {
    return path.join(__dirname,dir)
}

module.exports = {
    configureWebpack: config => {
        config.resolve = {
           extensions: ['.js', '.vue', '.json'],
            alias: {
              'vue$': 'vue/dist/vue.esm.js',
              '@': resolve('src'),
            }
        }
    },
    // devServer:{
    //   port:8000, // 启动端口
    //   open:true  // 启动后是否自动打开网页
    // }
}