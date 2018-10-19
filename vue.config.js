const path = require('path')

module.exports = {
    outputDir: path.resolve(__dirname, './src/main/resources/static'),
    pages: {
        index: {
            entry: 'src/main/js/main.js'
        }
    }
}