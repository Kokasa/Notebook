2025-01-07    23:28

status: #adult 
tags: [[ICONIX]], [[UML]]


# 健壮性分析(Robustness Analysis)

## 将用例描述转化成初步的对象交互图, 为后续的详细设计铺垫

- **验证用例的完整性和一致性**: 检查用例描述是否清晰, 完整, 是否存在遗漏或者歧义
- **识别关键对象和职责**: 确定哪些对象需要参与到用例的执行中, 并且明确他们的职责
- **发现潜在的设计问题**: 通过简单的交互, 能及早发现设计中的缺陷, 比如交互不清晰
- **为序列图建模提供基础**: 健壮性分析结果可以直接创建序列图, 来详细描述对象之间的交互


## 健壮性分析中使用的元素(三种对象)

### 1. 边界对象(Boundary Object)
- 相当于[[项目层级]]中的View层, 是系统与外部参与者之间的接口
- 在UML中的表现:
	![[Pasted image 20250107234050.png]]
	这样一个带有垂直线的圆圈

- 作用: 
	- 接受用户输入
	- 将用户的输入转化成系统内传输的格式([[反序列化]])
	- 向用户显示系统的输出
- 例如: 登录界面, 注册表单, 商品展示, 打印机接口等等
### 2. 控制对象(Control Object)

- 协调边界对象和实体对象之间的交互, 也就是业务逻辑, 充当项目层级中的服务层到控制层 

- 在UML中的表示
	![[Pasted image 20250107234203.png]]
	这样带有箭头的圆圈

- 作用: 
	- 接受边界对象传来的请求
	- 协调实体对象, 完成业务逻辑和操作
- 例如: 登录控制器, 订单控制器, 支付控制器等等
### 实体对象(Entity Object)

- 就是[[领域图(Domain Model Diagram)]]中的概念或者实体, 有属性和相应的方法
- 在UML中的表示
	![[Pasted image 20250107234154.png]]
	可以直接用圆圈或者带横线的圆圈
- 作用
	- 存储和管理数据
	- 提供基础交互方法
- 示例: 顾客, 商品, 订单, 账户等等


## 健壮性分析流程

1. 从[[用例图(Use Case Diagram)]]中选择一个用例, 进行分析
2. 仔细分析用例, 将其分解成具体步骤
3. 为每个步骤识别对象, 确定需要哪些边界对象, 控制对象和实体参与
4. 绘制健壮性图: 把现有的对象按照交互顺序和业务逻辑排列, 用关联线进行连接
5. 更新领域模型, 执行完上面的过程, 很容易找到领域模型中缺少一些必要的类或者属性

# References

[[ICONIX中的健壮性分析]]
