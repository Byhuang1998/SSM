package com.bylearning.mybatis.mapper;

import com.bylearning.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/23 15:12
 * @description TODO
 */
public interface SelectMapper {

    /**
     * 若sql语句查询的结果为多条时，一定不能以实体类类型作为方法的返回值
     * 否则会抛出异常TooManyResultsException
     */

    User getUserById(@Param("id") Integer id);

    List<User> getAllUser();

    Integer getCount();

    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有的用户信息为map集合
     * 若此查询的数据有多条，并且每条数据转换为map集合
     * 此时有2种解决方案：
     * 1、将mapper接口方法的返回值设置为泛型是map的List集合
     * List<Map<String, Object>>
     * 2、可以将每条数据转换的map集合放在一个大的map中，但是必须要通过@MapKey注解
     * 将查询的某个字段的值作为大的map的键
     * @MapKey("id")
     */
    List<Map<String, Object>> getAllUserToMap();

    @MapKey("id")
    Map<String, Object> getAllUserToMapFunc2();
}
