2024-12-13    01:48

status: #adult  

tags: [[Java]], [[OOP]], [[Principle]]


# Lambda表达式

## 概念
Java8 新特性, 目的是支持 [[函数式编程(Functional Programming)]]

通过Lambda表达式, Java能够以更简洁更清晰的方式表示匿名函数(没有名称的方法),
让代码更灵活更易于维护

Lambda表达式允许把函数作为参数传递给方法, 将代码片段作为数据进行传递

核心概念: **让代码更简洁, 更可读**


## 基本语法

```java
(parameters) -> expression
```

解释: 
- parameters: 方法的参数, 和传统方法的参数类似
- -> : 箭头操作符, 指向表示Lambda表达式中的主体部分
- expression: Lambda表达式的主体部分, 可以是一个表达式或者代码块


### 示例
```java
(x, y) -> x + y
```

这个表达式表示 **一个匿名函数**    **接受两个参数**    **返回相加后的结果**

### Lambda表达式组成部分详细解释

1. **参数列表**： Lambda 表达式的参数可以是 0 个、1 个或多个。参数类型可以省略，编译器会根据上下文推断出参数类型（即类型推断）。
    
    - 例如：`(int a, int b)` 或者简化为 `(a, b)`（类型推断）。
2. **箭头操作符 (`->`)**： 将参数列表与 Lambda 表达式的主体分开，类似于传统方法中的参数列表和方法体之间的分隔符。
    
3. **主体部分**： 主体部分可以是一个简单的表达式或者一个代码块。如果是一个简单的表达式，它会返回这个表达式的值。如果是一个代码块，你需要显式地使用 `return` 语句来返回结果。
    
#### 示例：

- **无参数 Lambda 表达式**：
    
    ```java
    () -> System.out.println("Hello, World!");
    ```
    
    这个 Lambda 表达式没有输入参数，并打印 `"Hello, World!"`。
    
- **一个参数 Lambda 表达式**：
    
    ```java
    (name) -> System.out.println("Hello, " + name);
    ```
    
    这个 Lambda 表达式有一个输入参数 `name`，它打印 `"Hello, name"`。
    
- **多个参数 Lambda 表达式**：
    
    ```java
    (a, b) -> a + b
    ```
    
    这个 Lambda 表达式接受两个参数，返回它们的和。
    
- **带代码块的 Lambda 表达式**：
    
    ```java
    (a, b) -> {
        int sum = a + b;
        return sum;
    }
    ```
    
    这个 Lambda 表达式有两个参数，使用代码块并显式返回两个数的和。
    
## 应用场景

lambda表达式最常用的常见是[[函数式接口]]

## Lambda表达式的优势

### 1. 对代码的简化
简化代码, 减少了冗长的匿名类代码

如: 
- 传统的[[匿名类(Anonymous Class)]]:
```java
		List<String> list = Arrays.asList("a", "b", "c");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
```

- 使用lambda表达式:
```java
		List<String> list = Arrays.asList("a", "b", "c");
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));

```



### 2. 提高可读性

### 3. 增强函数式编程
传递行为(如方法), 提高代码的灵活性


# References
[[Lambda 表达式]]
[[函数和方法的关系]]