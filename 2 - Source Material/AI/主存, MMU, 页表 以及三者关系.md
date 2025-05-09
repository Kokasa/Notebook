是的，您说得完全正确。主存虽然存储着页表，但它并不知道页表里具体有什么内容。

## 主存的职责

主存的主要职责是存储数据和指令。它就像一个巨大的仓库，可以存储各种各样的东西。但是，主存并不知道存储在其中的数据和指令的具体含义。

## 页表的特殊性

页表是一种特殊的数据结构，它记录了虚拟地址和物理地址之间的映射关系。页表对于 MMU 来说至关重要，但对于主存来说，它只是一堆普通的数据。

## 主存与页表的关系

主存存储着页表，但它并不知道页表里的内容。当 MMU 需要访问页表时，它会向主存发出请求，主存会根据 MMU 提供的地址，将相应的页表项返回给 MMU。

## MMU 与页表的关系

MMU 知道页表的结构和内容。它可以根据虚拟地址，找到对应的页表项，并从中提取出物理地址。

## 总结

主存存储着页表，但它并不知道页表里具体有什么内容。MMU 知道页表的结构和内容，它可以根据虚拟地址，找到对应的页表项，并从中提取出物理地址。

## 补充说明

- **页表项：** 页表项是页表中的一个条目，它记录了一个虚拟页和物理页之间的映射关系。
- **虚拟地址：** 虚拟地址是 CPU 生成的地址，它是一个逻辑上的地址，不是真实的物理地址。
- **物理地址：** 物理地址是主存的地址，它是真实的物理地址。

希望这些信息能帮助您更好地理解虚拟存储！如果您还有其他问题，欢迎随时提出。