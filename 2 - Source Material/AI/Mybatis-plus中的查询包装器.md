MyBatis-Plus 提供的查询包装器（`QueryWrapper` 和 `LambdaQueryWrapper`）是一个非常方便的工具，用于构建 SQL 查询条件，简化了条件构建的过程。以下是如何理解它们的几个关键点：

### 1. **QueryWrapper**

`QueryWrapper` 是 MyBatis-Plus 提供的一个查询条件构建器，用于构建 SQL 的 WHERE 子句。你可以通过链式调用的方式，轻松地对查询条件进行拼接。`QueryWrapper` 支持多种操作符，如等于、不等于、大于、小于、模糊查询等。

#### 示例：

```java
QueryWrapper<User> queryWrapper = new QueryWrapper<>();
queryWrapper.eq("age", 18) // age = 18
            .like("name", "John") // name LIKE 'John%'
            .gt("salary", 5000); // salary > 5000

List<User> users = userMapper.selectList(queryWrapper);
```

在上面的例子中：

- `eq`：表示“等于”
- `like`：表示模糊查询
- `gt`：表示“大于”

`QueryWrapper` 会自动根据这些方法生成对应的 SQL 语句。

### 2. **LambdaQueryWrapper**

`LambdaQueryWrapper` 是 MyBatis-Plus 的一个增强版，它解决了在使用 `QueryWrapper` 时遇到的字段名硬编码的问题，避免了手动拼接字符串时可能的错误（如字段名拼写错误）。它通过 Lambda 表达式来引用字段，这样就能够在编译时检查字段是否存在。

#### 示例：

```java
LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
lambdaQueryWrapper.eq(User::getAge, 18) // age = 18
                  .like(User::getName, "John") // name LIKE 'John%'
                  .gt(User::getSalary, 5000); // salary > 5000

List<User> users = userMapper.selectList(lambdaQueryWrapper);
```

在这里，`User::getAge`、`User::getName` 和 `User::getSalary` 是通过 Lambda 表达式来引用类字段的，因此避免了硬编码的字段名。

### 3. **常见的查询方法**

- `eq`: 等于
- `ne`: 不等于
- `gt`: 大于
- `lt`: 小于
- `ge`: 大于等于
- `le`: 小于等于
- `like`: 模糊查询
- `between`: 范围查询
- `in`: 包含查询
- `isNull`: 是否为 NULL

### 4. **链式调用**

`QueryWrapper` 和 `LambdaQueryWrapper` 支持链式调用，可以更直观地拼接查询条件。这种方式不仅简洁而且可读性强。

### 5. **动态查询**

通过组合多种方法，`QueryWrapper` 和 `LambdaQueryWrapper` 支持动态查询，适应各种查询场景。比如，你可以在代码中动态决定是否添加某个查询条件：

```java
QueryWrapper<User> queryWrapper = new QueryWrapper<>();
if (age != null) {
    queryWrapper.eq("age", age);
}
if (name != null) {
    queryWrapper.like("name", name);
}
List<User> users = userMapper.selectList(queryWrapper);
```

### 6. **其他高级功能**

- **排序**：`orderByAsc` 和 `orderByDesc` 可以用来指定排序规则。
- **分页**：结合 MyBatis-Plus 的分页插件，`QueryWrapper` 可以实现分页查询。
- **SQL 片段**：可以通过 `apply` 方法自定义 SQL 片段进行更复杂的查询。

```java
queryWrapper.apply("DATE_FORMAT(create_time, '%Y-%m-%d') = '2024-12-13'");
```

总之，`QueryWrapper` 和 `LambdaQueryWrapper` 使得构建 SQL 查询更加灵活和简洁，尤其是当查询条件动态变化时，它们的优势更加明显。