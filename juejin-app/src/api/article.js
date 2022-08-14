import request from "../utils/request"

export default {
    getArticleInfo(current, limit) {
        return request({
            url: `/juejinserver/index_data/find_article/${current}/${limit}`,
            method: "get"
        })
    },

    getArticleDetailById(articleId) {
        return request({
            url: `/juejinserver/index_data/findArticleDetail/${articleId}`,
            method: "get"
        })
    },

    getArticleTagsById(articleId) {
        return request({
            url: `/juejinserver/index_data/findArticleTags/${articleId}`,
            method: "get"
        })
    },

    getArticleContentById(articleId) {
        return request({
            url: `/juejinserver/article_content/getArticleContent/${articleId}`,
            method: "get"
        })
    }
}