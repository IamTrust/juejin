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
    }
}