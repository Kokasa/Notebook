2025-02-16    20:12

status: #adult 
tags: [[Computer Science]]


# 四种IO控制方式

	cpu是智慧的大脑, 其他的I/O设备就像是我的手脚, 
	手脚只有长在自己身体上才能自由使用
想要保证cpu和I/O设备之间的通信, 我们可以有不同的方式

- 程序查询方式(Polling, 串行方式, 菊花链)
	cpu挨个询问I/O设备, 就像是点名一样, 收到回复即进行通信
	虽然设计上很简单, 但是这样就要浪费珍贵的cpu资源在一遍一遍的询问上, 效率低
- [[中断(Interrupt)]]
	IO设备主动举手! 向cpu发送中断请求, cpu响应后就进行数据传输
	这就需要IO设备具有一定发信能力, 对硬件要求高
- [[直接存储技术(Direct Memory Access, DMA)]]
	不需要CPU, IO设备直接就和内存进行数据传输, 这样数据不需要经过中转, 传输速度快, CPU压力也小, 但是需要更高级的DMA控制器硬件支持, 所以适用于硬盘, 网卡等需要高速传输的设备
- [[通道方式]]
	使用专门的通道来管理IO操作, CPU只需要发出简单的命令即可, 这样CPU压力小, 而且cpu, 通道, IO设备能并行工作
	实现起来较复杂, 也仅在大型计算机系统中应用


# References
