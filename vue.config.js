const path = require('path')

module.exports = {
    outputDir: path.resolve(__dirname, './src/main/resources/static'),
    pages: {
        index: {
            entry: 'src/main/js/main.js'
        }
    },
    devServer: {
        proxy: {
            '/undefined': {
                target: 'http://api:8080',
                ws: true,
                changeOrigin: true,
                pathRewrite: {
                    '^/undefined' : '/api/v1'
                },
            }
        }
    }
}