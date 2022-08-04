import axios from "axios"

const service = axios.create({
    baseURL: 'http://106.14.212.78:9088',
    timeout: 18000
})

export default service