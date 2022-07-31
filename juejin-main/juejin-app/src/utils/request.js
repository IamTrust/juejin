import axios from "axios"

const service = axios.create({
    baseURL: 'http://123.60.213.2:9088',
    timeout: 18000
})

export default service