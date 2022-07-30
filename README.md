# 仿掘金官网

## 后端接口部分

后端接口`API`：

`http://123.60.213.2:9088/juejinserver/index_data/find_article/${current}/${limit}`

参数：`current`为当前页，`limit`为每页记录数。

## 前端部分

无限滚动已经简单实现，没有优化：

![](https://pictures-1312398124.cos.ap-guangzhou.myqcloud.com/20220731005119.png)

### 食用

```
cd juejiin-app

npm install

npm run serve
```

