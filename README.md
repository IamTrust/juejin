# 仿掘金官网

## 后端接口部分

后端接口`API`：

`http://123.60.213.2:9088/juejinserver/index_data/find_article/${current}/${limit}`

参数：`current`为当前页，`limit`为每页记录数。

主页数据已经全部完成，一个`json`格式例子如下：

```json
{
  "articleId":"7123467227038220319",
  "userId":"747323639479486",
  "userName":"编程学习网",
  "tagsIds":["6809640408797167623","6809640364677267469"],
  "tagNames":["后端","Go"],
  "ctime":"1658561520",
  "mtime":"1658563532",
  "rtime":"1658563532",
  "title":"Go WebSocket] 你的第三个Go WebSocket服务: 多房间的聊天室（上：思考篇）",
  "coverImage":"https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/8dfcc345eab14946a2684ac98143a434~tplv-k3u1fbpfcp-watermark.image?",
  "briefContent":"该系列第四篇：实现一个多房间的聊天室。这次官网没有demo了，需要我们自己实现！本篇文章介绍了实现「多房间聊天室」的难点及解决方案。",
  "viewCount":755,
  "collectCount":1,
  "diggCount":1,
  "commentCount":1
}
```



## 前端部分

### 启动

#### 进入`juejin-app`目录

```
cd juejin-app
```

#### 安装依赖

```
npm install

npm i element-ui -S  : Element组件库
```

#### 启动服务器

```
npm run serve
```

#### 访问URL

http://localhost:8080

![](https://pictures-1312398124.cos.ap-guangzhou.myqcloud.com/20220807173544.png)

