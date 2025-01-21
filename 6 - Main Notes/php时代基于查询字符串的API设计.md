2025-01-15    18:06

status: #adult 
tags: [[Network]], [[PHP]]


# php时代API设计

## 为什么会想到PHP

起因在研究华硕校园合伙人论坛时注意到使用的url与现代的[[RESTful]]风格不一致
`forum.php?mod=redirect&tid=76998&goto=lastpost#lastpost`

### 这个URL的组成

1. `forum.php`: 这是服务器上的一个脚本, 发送请求就是请求执行这个脚本
2. `?`: 用来分割
3. `mod=redirect&tid=76998&goto=lastpost`: 传递的参数, 键值对
4. `lastpost`: 标识符, 作为锚点, 用来指定这个特殊的位置
### 含义

请求服务器执行 `forum.php` 脚本，并传递三个参数：`mod=redirect`、`tid=76998` 和 `goto=lastpost`。服务器根据这些参数执行重定向操作，将用户导向主题 ID 为 76998 的帖子的最后一个帖子，并在页面加载后自动滚动到该帖子的位置。

## 动态URL


## 基于过程(请求)的API

如果说RESTful风格是基于资源, 这个就是基于查询操作




# References

[[早期论坛url分析]]