2024-12-12    09:21

status: #child 

tags: [[fine teacher]],  [[system designs]], [[Ruoyi-Vue-Plus]], [[data structure]], [[database design]], 


# Fine系统中课程表模块设计

## 实体类

- 时间段 timeSlot
- 班级 FineClass
- 课程 FineCourse
- 教师 FineTeacher
- 课程表项 FineScheduleItem
- 课程表 FineSchedule

## 业务流程

用户进行时间段的区分 ->
班级设置默认课程 ->
为班级分配胜任课程的教师 ->
将以上信息组成为课程表项 ->
组成课程表

## 详细设计

[[如何处理课程表中时间段的存储]]

[[课程表项的唯一性校验]]

目前只设置了固定的一周课表表现字段为day_of_week
这在中学中也许足够了
后续根据需求会考虑设置更具有广度的课表[[一周课表的拓展]]
## 功能亮点

## 仍需改进的地方

## 想要实现的效果


# References
[[课程表相关接口设计]]
[[对day_of_week枚举周几的存储]]
[[多层次架构系统中对于枚举类型的传递]]
[[课程表项中数据库索引设计和后台唯一性校验]]
[[一周课表的拓展]]