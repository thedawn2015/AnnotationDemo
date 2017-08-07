package com.app.simon.annotationdemo;

import java.lang.reflect.Field;

/**
 * desc: NewName Provider
 * date: 2017/8/7
 *
 * @author xw
 */
public class NewNameProvider {
    /**
     * 注解绑定，逻辑实现
     *
     * @param object
     */
    public static void bind(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NewName.class)) {
                NewName newName = field.getAnnotation(NewName.class);
                try {
                    field.set(object, newName.name());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
