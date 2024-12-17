2024-12-13    14:28

status: #adult 
tags: [[Ruoyi-Vue-Plus]], [[Mybatis-plus]]


# 关于Ruoyi-Vue-Plus中param参数的传递

## 示例代码
```java
/**  
 * 构建用户查询包装器  
 *  
 * 该方法根据传入的用户业务对象（SysUserBo）中的参数，构建一个用于查询用户信息的动态SQL包装器（Wrapper）  
 * 主要通过判断用户业务对象中的各个字段是否为空，以及参数中的时间范围，来动态组合查询条件  
 *  
 * @param user 用户业务对象，包含查询所需的各个参数  
 * @return 返回一个动态构建的查询包装器  
 */  
private Wrapper<SysUser> buildQueryWrapper(SysUserBo user) {  
    // 获取用户业务对象中的参数集合  
    Map<String, Object> params = user.getParams();  
    // 初始化一个查询包装器  
    QueryWrapper<SysUser> wrapper = Wrappers.query();  
    // 等价于 SQL: WHERE u.del_flag = '0'，筛选出未删除的用户  
    wrapper.eq("u.del_flag", UserConstants.USER_NORMAL)  
        .eq(ObjectUtil.isNotNull(user.getUserId()), "u.user_id", user.getUserId())  
        .like(StringUtils.isNotBlank(user.getUserName()), "u.user_name", user.getUserName())  
        .eq(StringUtils.isNotBlank(user.getStatus()), "u.status", user.getStatus())  
        .like(StringUtils.isNotBlank(user.getPhonenumber()), "u.phonenumber", user.getPhonenumber())  
        // 根据创建时间范围进行查询  
        .between(params.get("beginTime") != null && params.get("endTime") != null,  
            "u.create_time", params.get("beginTime"), params.get("endTime"))  
        // 根据部门ID进行查询，包括该部门及其子部门的用户  
        .and(ObjectUtil.isNotNull(user.getDeptId()), w -> {  
            List<SysDept> deptList = deptMapper.selectList(new LambdaQueryWrapper<SysDept>()  
                .select(SysDept::getDeptId)  
                .apply(DataBaseHelper.findInSet(user.getDeptId(), "ancestors")));  
            List<Long> ids = StreamUtils.toList(deptList, SysDept::getDeptId);  
            ids.add(user.getDeptId());  
            w.in("u.dept_id", ids);  
        }).orderByAsc("u.user_id");  
    // 排除指定的用户ID列表  
    if (StringUtils.isNotBlank(user.getExcludeUserIds())) {  
        wrapper.notIn("u.user_id", StringUtils.splitTo(user.getExcludeUserIds(), Convert::toLong));  
    }  
    // 返回构建好的查询包装器  
    return wrapper;  
}
```

## param参数在这里的作用

用于封装前端传回的额外查询参数
可以在后台对param进行统一处理

## 来源

查看发现param参数存在于Bo类继承的BaseEntity, 属于Ruoyi-Vue-Plus框架默认添加的字段

# References
[[Mybatis-Plus中的查询包装器(QueryWrapper)]]