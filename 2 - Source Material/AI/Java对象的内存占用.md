在Java中，一个实体（对象）占用的内存由以下几个因素决定：

### 1. **对象头（Object Header）**

- **Mark Word**: 占用 8 字节（在 64 位 JVM 中，使用压缩指针时为 8 字节；未压缩时为 16 字节）。
- **Class Pointer**: 指向类元数据的指针，通常占用 4 字节（压缩指针）或 8 字节（未压缩指针）。
- **数组长度（仅数组对象）**: 如果是数组对象，需额外加上 4 字节来存储数组的长度（压缩时）。

### 2. **实例字段（Instance Fields）**

- 每个字段的大小取决于其数据类型：
    
    - `boolean`: 1 字节
        
    - `byte`: 1 字节
        
    - `char`: 2 字节
        
    - `short`: 2 字节
        
    - `int`: 4 字节
        
    - `float`: 4 字节
        
    - `long`: 8 字节
        
    - `double`: 8 字节
        
    - 引用类型（如对象引用、数组引用）: 4 字节（压缩指针）或 8 字节（未压缩指针）。
        
    
    > 字段会按照对齐规则排列（通常为 8 字节对齐），这可能会导致“填充字节”（Padding）的出现。
    

### 3. **对齐填充（Padding）**

Java 对象的大小需要是 8 字节的倍数（默认情况下）。如果对象字段不足以填充到 8 字节的边界，会自动添加额外的填充字节。

---

### **内存计算示例**

#### 假设一个简单的类：

```java
class Example {
    int id;
    boolean isActive;
    double value;
}
```

1. **对象头**:
    - 16 字节（64 位 JVM，启用压缩指针）。
2. **实例字段**:
    - `int id`: 4 字节
    - `boolean isActive`: 1 字节 + 3 字节填充（为了对齐到 8 字节边界）。
    - `double value`: 8 字节
3. **字段总大小**: `4 + 1 + 3 + 8 = 16` 字节。
4. **对齐到 8 字节倍数**: 无需额外填充。
5. **总大小**: `16（对象头） + 16（字段） = 32 字节`。

---

### **注意事项**

- **压缩指针**: 默认在 64 位 JVM 中启用（对象大小小于 32 GB 时），会减少指针的大小。
- **数组对象**: 除了普通对象的开销，还需计算数组长度和每个元素的内存占用。
- **对象的实际大小**: 可以通过工具（如 Java Instrumentation 或 JOL）获取，手工计算可能有偏差。

#### 使用 JOL 查看对象内存：

```java
import org.openjdk.jol.info.ClassLayout;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(ClassLayout.parseInstance(example).toPrintable());
    }
}
```

结果会详细显示对象内存布局，包括对象头、字段和填充字节。