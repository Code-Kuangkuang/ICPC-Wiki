package com.project.icpcwiki.util;

//? BeanUtils 工具类
import org.springframework.beans.BeanUtils;
//? CollectionUtils 工具类
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

// ? 单个复制和列表复制
public class CopyUtil {

    /**
     * 单体复制
     */
    public static <T> T copy(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        T obj = null;
        try {
            // ! 被放弃
            // obj = clazz.newInstance();
            obj = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            // ? 异常处理内容
            e.printStackTrace();
            return null;
        }
        // ? 属性copyProperties复制实现
        BeanUtils.copyProperties(source, obj);
        return obj;
    }

    /**
     * 列表复制
     */
    @SuppressWarnings("rawtypes")
    public static <T> List<T> copyList(List source, Class<T> clazz) {
        List<T> target = new ArrayList<>();
        // ? CollectionUtils 判断是否为空
        if (!CollectionUtils.isEmpty(source)) {
            // ? 循环遍历
            for (Object c : source) {
                T obj = copy(c, clazz);
                target.add(obj);
            }
        }
        return target;
    }
}
