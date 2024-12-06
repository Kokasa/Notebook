`LambdaQueryWrapper` 是 [[MyBatis-Plus]] 提供的一个非常方便的工具类，用于构建 SQL 查询条件。它的主要特点是可以通过 [[Lambda 表达式]]来安全、简洁地构建查询条件，避免了传统方式中使用字符串拼接字段名时可能出现的错误，提供了编译时的检查，减少了潜在的 Bug。

### 1. **基本介绍**

`LambdaQueryWrapper` 是 `QueryWrapper` 的一个变种，它允许你在构建查询条件时通过 [[Lambda 表达式]]来指定实体类的字段，而不是直接写字段的字符串名称。这样做的好处是：

- 编译期检查：如果你在 [[Lambda 表达式]]中引用了不存在的字段，编译器会报错。
- 重构友好：在修改字段名时，不需要修改查询条件中的字符串，避免了因重构导致的字段名错误。

### 2. **常用方法**

`LambdaQueryWrapper` 提供了很多方法来方便构建查询条件，常用的方法有：

#### 1. `eq`（等于）

```java
LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
queryWrapper.eq(User::getName, "John");
```

上面的代码相当于 SQL 中的 `SELECT * FROM user WHERE name = 'John'`。

#### 2. `ne`（不等于）

```java
queryWrapper.ne(User::getAge, 18);
```

相当于 SQL 中的 `SELECT * FROM user WHERE age != 18`。

#### 3. `gt`（大于）

```java
queryWrapper.gt(User::getAge, 18);
```

相当于 SQL 中的 `SELECT * FROM user WHERE age > 18`。

#### 4. `lt`（小于）

```java
queryWrapper.lt(User::getAge, 30);
```

相当于 SQL 中的 `SELECT * FROM user WHERE age < 30`。

#### 5. `like`（模糊匹配）

```java
queryWrapper.like(User::getName, "John");
```

相当于 SQL 中的 `SELECT * FROM user WHERE name LIKE '%John%'`。

#### 6. `in`（包含在某个集合中）

```java
queryWrapper.in(User::getAge, 18, 20, 22);
```

相当于 SQL 中的 `SELECT * FROM user WHERE age IN (18, 20, 22)`。

#### 7. `between`（区间查询）

```java
queryWrapper.between(User::getAge, 18, 25);
```

相当于 SQL 中的 `SELECT * FROM user WHERE age BETWEEN 18 AND 25`。

#### 8. `isNull`（字段值为 NULL）

```java
queryWrapper.isNull(User::getEmail);
```

相当于 SQL 中的 `SELECT * FROM user WHERE email IS NULL`。

#### 9. `orderByAsc`（升序排序）

```java
queryWrapper.orderByAsc(User::getAge);
```

相当于 SQL 中的 `SELECT * FROM user ORDER BY age ASC`。

#### 10. `orderByDesc`（降序排序）

```java
queryWrapper.orderByDesc(User::getAge);
```

相当于 SQL 中的 `SELECT * FROM user ORDER BY age DESC`。

### 3. **综合示例**

假设我们有一个 `User` 实体类，包含字段 `id`、`name`、`age`、`email`。如果我们想查找名字为 "John" 且年龄大于 18 的用户，代码如下：

```java
LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
queryWrapper.eq(User::getName, "John")
            .gt(User::getAge, 18);

List<User> users = userMapper.selectList(queryWrapper);
```

这个查询相当于执行 SQL：

```sql
SELECT * FROM user WHERE name = 'John' AND age > 18;
```

### 4. **注意事项**

- `LambdaQueryWrapper` 的方法参数是基于 [[Lambda 表达式]]来传递的，例如 `User::getName`，而不是字符串形式的字段名。这样可以避免因拼写错误导致的查询错误。
- `LambdaQueryWrapper` 只支持用于查询操作（如 `selectList`、`selectOne`），如果你想进行更新、删除等操作，应该使用 `LambdaUpdateWrapper` 或 `LambdaDeleteWrapper`。

### 5. **LambdaQueryWrapper 的链式调用**

`LambdaQueryWrapper` 支持链式调用，你可以在同一个查询条件对象上添加多个条件。例如，下面的代码表示查找名字为 "John"，且年龄大于 18 或者邮箱为空的用户：

```java
LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
queryWrapper.eq(User::getName, "John")
            .gt(User::getAge, 18)
            .isNull(User::getEmail);

List<User> users = userMapper.selectList(queryWrapper);
```

### 总结

`LambdaQueryWrapper` 是 [[MyBatis-Plus]] 中一个非常实用的工具，它通过 [[Lambda 表达式]]来安全构建查询条件，避免了传统 SQL 编写中的字段名拼写错误。通过丰富的条件方法，它使得查询条件的构建更加简洁和灵活，同时也支持链式调用，便于进行复杂查询。