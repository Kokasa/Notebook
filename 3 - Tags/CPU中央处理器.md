2025-01-05    15:00

status: #adult 
tags: [[Computer Science]]


# CPU中央处理器

cpu是计算机的核心, 要执行指令和处理数据, 就像人类的大脑



## cpu的结构

### 1. 控制单元(Control Unit, CU)
这是CPU的指挥中心, 负责指令的读取, 译码和执行
指挥中心协调cpu内各个部件的工作, 保证指令的有序执行

它由以下组件组成: 
- **指令寄存器(Instruction Register, IR)**: 存放当前正在执行的指令
- **指令译码器(Instruction Decoder, ID)**: 将指令翻译成cpu可以理解的控制信号
- **[[程序计数器(Program Counter, PC)]]**: 存放下一条要将要执行的指令的地址
- **时序发生器(Timing Generator, TG)**: 产生cpu运行所需的时序信号, 控制指令执行的节拍
- **操作控制器(Operation Controller, OP)**: 控制运算器, 存储器和IO设备的工作

### 2. 运算单元(Arithmetic Unit, AU)
能执行算术运算和逻辑运算
主要部分有: 
- [[算数逻辑单元(Arithmetic Logic Unit, ALU)]]: 执行简单的算数运算和逻辑运算
- 浮点运算单元(Floating Point Unit): 专门用来执行浮点数运算
- [[累加器(Accumulate, Acc)]]: 用来存放运算结果

### 3. 存储
- **高速缓存(Cache)**: 有L1, L2, L3三级缓存, 从L1到L3容量变大, 速度变慢. 高速缓存用来暂存cpu和内存交换的数据
- **寄存器(Register)**: 用来存储指令, 数据和地址等信息, 是cpu内部数据的"缓存", 比缓存更快
	- 通用寄存器: 很通用, 能存各种数据
	- 专用寄存器: 比较专业, 只存储特定信息, 比如程序计数器, 指令寄存器


### 4. 内部总线
用来连接cpu内部各个部件, 传输数据和控制信号


# References
