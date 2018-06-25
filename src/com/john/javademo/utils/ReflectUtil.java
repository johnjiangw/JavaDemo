package com.john.javademo.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射相关操作
 */
public class ReflectUtil {
    /**
     * 通过反射 将old对象的值赋值给target对象
     * @param source 源对象
     * @param target 目标对象
     * @param <T>
     * @return
     */
    public static <T> T copyValue(Object source,T target){
        return copyValue(source,target,false);
    }

    /**
     * 通过反射 将old对象的值赋值给target对象 忽略大小写
     * @param source 源对象
     * @param target 目标对象
     * @param ignore 忽略大小写
     * @param <T>
     * @return
     */
    public static <T> T copyValueIgnoreCase(Object source,T target,Boolean ignore){
        return copyValue(source,target,ignore);
    }
    /**
     * 通过反射 将old对象的值赋值给target对象，只赋值有相同属性的
     * @param source 源对象
     * @param target 目标对象
     * @param <T>
     * @return
     */
    private static <T> T copyValue(Object source,T target,Boolean ignore){
        if(target==null||source==null)
            return null;
        try {
            Class<?>clazzTarget= target.getClass();
            Class<?>clazzSource=source.getClass();
            Map<String,Field>mapTarget=new HashMap<>();
            for (Field f:clazzTarget.getDeclaredFields()) {
                if(ignore){
                    mapTarget.put(f.getName().toLowerCase(),f);
                }
                mapTarget.put(f.getName(),f);
            }
            for (Field fOld:clazzSource.getDeclaredFields() ) {
                fOld.setAccessible(true);
                Field fTarget;
                if(ignore){
                    fTarget = mapTarget.get(fOld.getName().toLowerCase());
                }else {
                    fTarget = mapTarget.get(fOld.getName());
                }
                if(fTarget!=null&&fTarget.getGenericType().toString().equals(fOld.getGenericType().toString())){
                    fTarget.setAccessible(true);
                    fTarget.set(target,fOld.get(source));
                }
            }
            return target;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
