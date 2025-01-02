2025-01-02    20:49

status: #adult 
tags: [[Computer Science]]


# 寄存器(Register)

## cpu的"工作台"

寄存器是 cpu 内部的高速存储单元
cpu在进行各种计算和操作的时候会把一些频繁访问的数据临时存储到寄存器里面

## 寄存器的作用

- 高速存储, 访问速度甚至比 RAM 还要快得多, 离cpu运算单元非常近
- 临时存储, 只是存放cpu正在处理的数据

## 常见的寄存器种类

- **通用寄存器**: 用于存储各种类型的数据
- **专用寄存器**: 用来执行特定的任务
	- **程序计数器(Program Counter, PC)**: 存储下一条指令的内存地址
	- **指令寄存器(Instruction Register, IR)**: 存储当前正在执行的指令
	- **堆栈指针(Stack Pointer, SP)**: 指向栈顶的地址
	- **基址寄存器(Base Pointer, BP)**: 指向栈底或函数的[[基地址(Base Address)]]
	- **状态寄存器(Status Register, PSR)**: 存储cpu的各种状态信息, 如仅为标志, 零标志等
- **段寄存器**: 在分段式内存管理的系统中使用, 存储段的基址和界限


# References

[[有哪些常见的寄存器]]
