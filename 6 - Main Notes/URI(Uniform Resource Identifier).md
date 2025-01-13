2025-01-12    14:59

status: #adult 
tags: [[Network]]


# URI(Uniform Resorce Identifier)

## 网络资源的唯一标识

URI(Uniform Resource Identifier)是一个字符串, 提供一种统一的方式来标识网络上的资源

## 组成部分

- **方案(Scheme)**: 指定用来访问资源的协议或者方法, 常见方法比如: http(s), ftp, mailto等等
- **授权(Authority)**: 指定资源的访问权限, 通常包含以下部分: 
	- **用户信息(Userinfo)**: 用户名和密码, 用来请求需要身份验证的资源
	- **主机(Host)**: 资源所在的服务器的域名或者IP地址
	- **端口(Port)**: 服务器监听的网络端口
	- **路径(Path)**: 资源在服务器上的路径
	- **查询(Query)**:请求资源时包含的查询参数
	- **片段(Fragement)**:指定资源中的某个片段或者位置, 用来在网页中精确定位

## URI分类

### URL(Uniform Resource Locator)

包含 方案, 主机, 路径, 用来指定资源在互联网上的具体位置, 例如`https://www.example.com/path/to/resource`
`ftp://ftp.example.com/pub/file.zip`
`mailto:info@example.com`

### URN(Uniform Resource Name)

这个URI与位置无关, 且持久
它使用特定的命名空间标识资源, 即使资源移动到不同的位置, URN依然生效, 常见于图书存储
例如 `urn:isbn:978-0-321-76572-3` 是一个使用ISBN命名空间标识图书的URN

## URI工作方式

1. 解析URI
2. 建立连接
3. 发送请求
4. 服务器响应
5. 客户端处理

## URI和URL

URI是资源的唯一标识, URL则告诉大家这个资源的位置, 也同样属于URI的一种


# References
