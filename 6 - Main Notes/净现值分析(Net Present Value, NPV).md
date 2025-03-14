2025-01-05    21:44

status: #adult 
tags: [[收益分析]], [[项目管理(Project Management)]]


# 净现值分析(Net Present Value, NPV)

## 货币时间价值(Time Value of Money, TVM)

在详细介绍NPV之前, 我们可以先想一下, 今天的1元钱和未来的1元钱谁更有价值
当然, 这里并不是在讲解[[通货膨胀]]
而我们在这里考虑到钱的流动, 今天的钱能够通过投资来产生收益

## 将未来的金钱折算成现在的价值
我们要做的是让钱生钱, 预估项目未来的收益, 并折算成现在的价值, 再减去初始投资成本, 就是NPV

$$NPV=
{\sum^{N}_{t=0}} {\frac{C_t}{(1+r)^{t}}}$$
- $C_t=在第t期的净现金流(收入-支出)$
- $r=折现率$
- $t=时间期数(单位: 年)$
- $N=项目的总时间周期$

### 对公式的逐步推导
1. **每期的现金流现值**
$$PV_t=\frac{C_t}{(1+r)^t}$$
1. **总的现金流价值**
$$NPV=
{\sum^{N}_{t=0}} PV_t$$
### 结果分析: 

- $NPV>0$: 项目的预期收益超过成本, 值得投资
- $NPV=0$: 项目的收益正好抵消成本
- $NPV<0$: 项目无法带来足够收益

## 优缺点: 

### 优点: 
1. 综合考虑了时间价值, 将不同尺度的未来收益放在现在评价
2. 为决策者提供清晰的收益预期
### 缺点: 
1. 过渡依赖折现率, 容易造成偏差
2. 受未来现金流影响, 这些数据都非常主观

# References

[[TVM在投资中的地位]]

[[NPV是如何计算的]]

[[NPV的诞生]]