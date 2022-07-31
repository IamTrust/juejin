# 仿掘金官网

## 后端接口部分

后端接口`API`：

`http://123.60.213.2:9088/juejinserver/index_data/find_article/${current}/${limit}`

参数：`current`为当前页，`limit`为每页记录数。

## 前端部分

### 启动

#### 进入`juejin-app`目录

```
cd juejin-app
```

#### 安装依赖

```
npm install
```

#### 启动服务器

```
npm run serve
```



### 进度

* 无限滚动已经简单实现，没有优化：

    ![](https://pictures-1312398124.cos.ap-guangzhou.myqcloud.com/20220731005119.png)

* 文章列表样式调整基本完成，缺少数据：文章作者、文章类型。
* 滚动条下滑导航栏消失已实现，缺少过渡动画。

### 没有实现的：
* 点击搜索框变长，创作者中心消失。
* 右下角点击回到顶部。

