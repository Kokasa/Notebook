2025-01-02    13:29

status: #adult 
tags: [[单元测试]]


# 桩模块(Stubs)

模拟下级模块, 被被测单元调用
提供预定的输出或者行为, 以隔离被测单元和其他模块的交互

## 作用

- **替代依赖**
	临时替代尚未开发或者难以控制的模块, 比如数据库, 网络接口, 第三方库等
- **提供预定输出**
	根据需要返回预定的值, 模拟不同的场景
- **隔离测试**
	使测试更加集中和可控, 避免其他模块干扰


**例子：** 假设 `calculate_discount()` 函数内部需要调用一个函数 `get_tax_rate()` 来获取税率。但是 `get_tax_rate()` 函数尚未实现或不稳定。这时，可以创建一个桩模块来替代 `get_tax_rate()`，例如：

# References

[[如何设计桩模块]]