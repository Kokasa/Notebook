2024-12-13    01:23

status: #adult 

tags: [[Mybatis-plus]], 


# Mybatis-Plus中的查询包装器

又称条件构造器
以java代码的形式, 构建SQL查询条件, 免除了书写冗杂的XML文件


## QueryWrapper

MP提供的基础查询条件构建器, 用来构建SQL的WHERE语句
可以通过链式调用的方式对查询条件进行拼接
使用方法如: 
```java
QueryWrapper<User> queryWrapper = new QueryWrapper<>();
queryWrapper.eq("age", 18) // age = 18
            .like("name", "John") // name LIKE 'John%'
            .gt("salary", 5000); // salary > 5000

List<User> users = userMapper.selectList(queryWrapper);
```


## LambdaQueryWrapper

解决了QueryWrapper的硬编码问题, 而是引用和映射实体类的字段(通过Lambda表达式), 在编译时就检查字段是否存在

例如: 
```java
LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
lambdaQueryWrapper.eq(User::getAge, 18) // age = 18
                  .like(User::getName, "John") // name LIKE 'John%'
                  .gt(User::getSalary, 5000); // salary > 5000

List<User> users = userMapper.selectList(lambdaQueryWrapper);
```

### 为什么使用LambdaQueryWraper

- 编译时检查: 如果引用了不存在字段, 编译器会报错
- 重构友好:  修改字段名时能够统一重构get方法, 而不是修改字符串

## 常见的查询方法

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

## [[链式调用]]
支持链式调用, 可以更直观地拼接查询条件, 简洁而且可读性强

## 动态查询

可以在代码中添加校验逻辑来动态决定是否添加某个查询条件

例如[[Ruoyi-Vue-Plus]]中的运用
```java
private LambdaQueryWrapper<FineStudent> buildQueryWrapper(FineStudentBo bo) {  
    Map<String, Object> params = bo.getParams();  
    LambdaQueryWrapper<FineStudent> lqw = Wrappers.lambdaQuery();  
  
    // 基本查询条件  
    lqw.eq(StringUtils.isNotBlank(bo.getStudentCode()), FineStudent::getStudentCode, bo.getStudentCode())  
        .eq(StringUtils.isNotBlank(bo.getStudentEnrollmentNumber()), FineStudent::getStudentEnrollmentNumber, bo.getStudentEnrollmentNumber())  
        .eq(StringUtils.isNotBlank(bo.getIdentityNumber()), FineStudent::getIdentityNumber, bo.getIdentityNumber())  
        .eq(bo.getDormitoryId() != null, FineStudent::getDormitoryId, bo.getDormitoryId())  
        .eq(bo.getClassId() != null, FineStudent::getClassId, bo.getClassId())  
        .like(StringUtils.isNotBlank(bo.getStudentName()), FineStudent::getStudentName, bo.getStudentName())  
        .eq(StringUtils.isNotBlank(bo.getGender()), FineStudent::getGender, bo.getGender())  
        .eq(StringUtils.isNotBlank(bo.getTransferStatus()), FineStudent::getTransferStatus, bo.getTransferStatus())  
        .eq(StringUtils.isNotBlank(bo.getBirthplace()), FineStudent::getBirthplace, bo.getBirthplace())  
        .eq(StringUtils.isNotBlank(bo.getCurrentResidence()), FineStudent::getCurrentResidence, bo.getCurrentResidence())  
        .eq(StringUtils.isNotBlank(bo.getStatus()), FineStudent::getStatus, bo.getStatus());  
  
    // 处理日期范围查询  
    if (params != null) {  
        if (params.get("birthDateRange") != null) {  
            String[] birthDateRange = ((String) params.get("birthDateRange")).split(",");  
            lqw.ge(StringUtils.isNotEmpty(birthDateRange[0]), FineStudent::getBirthDate, birthDateRange[0])  
               .le(StringUtils.isNotEmpty(birthDateRange[1]), FineStudent::getBirthDate, birthDateRange[1]);  
        }  
        if (params.get("enrollmentDateRange") != null) {  
            String[] enrollmentDateRange = ((String) params.get("enrollmentDateRange")).split(",");  
            lqw.ge(StringUtils.isNotEmpty(enrollmentDateRange[0]), FineStudent::getEnrollmentDate, enrollmentDateRange[0])  
               .le(StringUtils.isNotEmpty(enrollmentDateRange[1]), FineStudent::getEnrollmentDate, enrollmentDateRange[1]);  
        }  
        if (params.get("graduationDateRange") != null) {  
            String[] graduationDateRange = ((String) params.get("graduationDateRange")).split(",");  
            lqw.ge(StringUtils.isNotEmpty(graduationDateRange[0]), FineStudent::getGraduationDate, graduationDateRange[0])  
               .le(StringUtils.isNotEmpty(graduationDateRange[1]), FineStudent::getGraduationDate, graduationDateRange[1]);  
        }  
    }  
  
    return lqw;  
}
```

## 其他操作

这两种包装器只支持查询操作, 如果想进行更新删除等操作应该使用 UpdateWrapper 或者 DeleteWrapper
# References

[[2 - Source Material/AI/Mybatis-plus中的查询包装器|Mybatis-plus中的查询包装器]]
[[Lambda 表达式]]
[[LambdaQueryWrapper]]