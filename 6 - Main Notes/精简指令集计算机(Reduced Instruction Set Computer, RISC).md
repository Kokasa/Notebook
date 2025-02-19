2025-01-05    02:19

status: #adult 
tags: [[Computer Science]], [[计算机指令]]

# 精简指令集计算机(Reduced Instruction Set Computer)

和[[复杂指令集计算机(Complex Instruction Set Computer, CISC)]]不同, RISC旨在充分利用已有的指令, 让现在的指令最大化被利用

- 减少指令系统中的指令种类, 规范指令格式, 简化寻址方式, 降低成本, 代码量和功耗, 答复提高处理器性能
- 代表: ARM架构, MIPS架构, RISC-V架构

## 特点: 

- 尽量选取使用频率高的简单指令, 复杂指令通过这些简单指令的组合实现
- 指令字长固定, 指令格式少, 寻址方式少
- 只允许load和store两种指令访问主存, 其余操作均在寄存器之间执行
- CPU中包含大量的通用寄存器, 以减少对主存的访问
- 通常采用[[指令流水线技术]], 大部分指令在一个时钟周期内完成
- 采用[[硬布线控制器(Hardwired Controller)]], 不用或者很少使用[[微程序控制器]], 大大提升控制部件的速度
- 特别注重编译优化, 减少程序运行时间

[[RISC和CISC的比较]]

# References
