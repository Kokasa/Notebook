from [[Ruoyi-Vue-Plus]]

package org.dromara.common.core.utils;

## 树形结构
``` java
/**  
 * 根据前端定制差异化字段  
 */  
public static final TreeNodeConfig DEFAULT_CONFIG = TreeNodeConfig.DEFAULT_CONFIG.setNameKey("label");  
  
/**  
 * 构建树形结构  
 *  
 * @param <T>        输入节点的类型  
 * @param <K>        节点ID的类型  
 * @param list       节点列表，其中包含了要构建树形结构的所有节点  
 * @param nodeParser 解析器，用于将输入节点转换为树节点  
 * @return 构建好的树形结构列表  
 */  
public static <T, K> List<Tree<K>> build(List<T> list, NodeParser<T, K> nodeParser) {  
    if (CollUtil.isEmpty(list)) {  
        return CollUtil.newArrayList();  
    }  
    K k = ReflectUtils.invokeGetter(list.get(0), "parentId");  
    return TreeUtil.build(list, k, DEFAULT_CONFIG, nodeParser);  
}  
```


## 分组树形结构
```java
/**  
 * 构建分组树形结构  
 *  
 * @param <T>           输入节点的类型  
 * @param <K>           节点ID的类型  
 * @param list          节点列表  
 * @param groupField    分组字段的获取函数  
 * @param nodeParser    节点解析器  
 * @param rootNodeName  根节点名称格式化函数，用于自定义根节点显示名称  
 * @return 构建好的树形结构列表  
 */  
public static <T, K> List<Tree<K>> buildGroupTree(  
    List<T> list,  
    Function<T, String> groupField,  
    NodeParser<T, K> nodeParser,  
    Function<String, String> rootNodeName) {  
    if (CollUtil.isEmpty(list)) {  
        return CollUtil.newArrayList();  
    }  
  
    // 按分组字段分组  
    Map<String, List<T>> groupMap = list.stream()  
        .collect(Collectors.groupingBy(groupField));  
  
    List<Tree<K>> result = new ArrayList<>();  
  
    // 为每个分组创建一个根节点，并添加子节点  
    groupMap.forEach((group, items) -> {  
        // 创建分组节点  
        Tree<K> groupNode = new Tree<>();  
        groupNode.setId((K) ("group_" + group)); // 使用特殊前缀避免ID冲突  
        groupNode.setParentId((K) "0");  
        groupNode.setName(rootNodeName.apply(group));  
        groupNode.putExtra("type", "group");  
  
        // 处理分组下的子节点  
        List<Tree<K>> children = items.stream()  
            .map(item -> {  
                Tree<K> node = new Tree<>();  
                nodeParser.parse(item, node);  
                node.setParentId((K) ("group_" + group));  
                return node;  
            })  
            .collect(Collectors.toList());  
  
        groupNode.setChildren(children);  
        result.add(groupNode);  
    });  
  
    // 对结果进行排序（根据分组名称）  
    result.sort(Comparator.comparing(node -> node.getName().toString()));  
  
    return result;  
}
```
