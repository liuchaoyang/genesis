package com.liu.example;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Test;

import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.junit.Assert.assertEquals;


public class ByteBuddyUtils {



    @Test
    public void createNewObject() {
        DynamicType.Unloaded unloadedType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.isToString())
                .intercept(FixedValue.value("create new object by ByteBuddy!"))
                .make();
        Class aClass = unloadedType.load(ByteBuddyUtils.class.getClassLoader()).getLoaded();
        Object o = null;
        try {
            o = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(o.toString());
        assertEquals("create new object by ByteBuddy!", o.toString());
    }

    @Test
    public void delegation() {
        Class aClass = new ByteBuddy()
                .subclass(User.class)
                .method(named("myString")
                        .and(isDeclaredBy(User.class))
                        .and(returns(String.class)))
                .intercept(MethodDelegation.to(Delegation.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded();
        Object o = null;
        try {
            o = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(((User)o).myString());


        User user = new User();
        user.setAge("11");
        System.out.println(user.myString());
    }

    public static class Delegation {
        public static String myString() {
            return "delegation hha";
        }

    }


    @Test
    public void redefine() {
        ByteBuddyAgent.install();
        new ByteBuddy()
                .redefine(User.class)
                .method(named("myString"))
                .intercept(FixedValue.value("redefine myString method haha"))
                .make()
                .load(getClass().getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

        User user = new User();
        user.setAge("11");
        System.out.println(user.myString());
    }

}
