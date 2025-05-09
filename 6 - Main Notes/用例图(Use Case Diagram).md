2025-01-07    22:58

status: #adult 
tags: [[ICONIX]], [[UML]]


# 用例图(Use Case Diagram)

## 用例图要表达什么?
用例图从 用户的角度 展示了 系统提供的服务 和 用户怎么和系统交互
能很好的帮助开发团队和用户更好地理解系统的功能范围和用户需求

## 用例图包含的元素

### 1. 参与者(Actor)
- 与系统进行交互的外部实体, 可以是人, 其他系统, 硬件或者组织, 只要是代表系统外部的角色都可以是参与者, 当然, 不能是具体某个人, 而是泛指一类或者几类群体!
- Actor在UML中的表示
	![[Pasted image 20250107230512.png]]
	如图, 这个简笔画小人就是Actor在UML图中的表现

- 特点
	- 参与者是系统外部的角色
	- 一个参与者可以参与多个用例
	- 一个用例也能被多个参与者使用
	- 参与者不一定是人

- 举例: 网上银行系统中，“客户”、“银行职员”、“ATM机”都可以是参与者


### 2. 用例(Use Case)

- 定义: 系统提供的完整功能单元, 描述参与者(Actor)如何使用系统来完成特定的任务或者目标, 代表着系统的一个功能或服务

- 在UML中的表示
	![[Pasted image 20250107231051.png]]

- 特点
	- 描述一个完整的有意义的交互过程
	- 关注"做什么", 而不是"怎么做", 暂时不考虑实现细节
	- 用例应该对参与者有明显价值
- 示例: 图书馆管理系统中，“借书”、“还书”、“查询图书”都是用例


### 3. 关联(Association)
- 定义: 表示参与者和用例之间的交互关系, 表明参与者使用的用例
- 表示: 
	- 泛化：继承（A→B，A泛化自B）
	- 包含：必要组成部分（A⇢B，A包含B）
	- 扩展：可选（A⇢B，A扩展自B)

- 示例：在网上购物系统中，“顾客”与“浏览商品”、“添加到购物车”、“下单”、“支付”等用例之间存在关联关系，表示顾客可以使用这些功能。


## 用例图的作用

- 帮助开发团队更好地理解用户需求
- 用简单的图形和文字描述, 易于多方人员交流沟通
- 可以为后续设计, 编码和测试提供指导


# References

[[用例图的介绍]]