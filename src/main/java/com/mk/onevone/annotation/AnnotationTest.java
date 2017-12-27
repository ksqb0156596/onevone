package com.mk.onevone.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {

    private String name;

    @Test(isNotNull = true,maxLength = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        AnnotationTest annotationTest = new AnnotationTest();
        annotationTest.setName("aaa");
        Class<AnnotationTest> clazz = AnnotationTest.class;
        for(Method m : clazz.getDeclaredMethods()){
            Test test = m.getAnnotation(Test.class);
            if(test != null){
                System.out.println(test.isNotNull());
                System.out.println(test.maxLength());
                try {
                    System.out.println(m.invoke(annotationTest));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
