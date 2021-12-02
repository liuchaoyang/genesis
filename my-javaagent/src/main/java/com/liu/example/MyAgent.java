package com.liu.example;

import java.lang.instrument.Instrumentation;

public class MyAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("MyAgent premain.");
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("AgentMain start");
        System.out.println(agentArgs);
        System.out.println(inst);
        //获取所有已加载的类
        Class[] allLoadedClasses = inst.getAllLoadedClasses();
        for (Class loadedClass : allLoadedClasses) {
            System.out.println(loadedClass);
        }
    }

    public static void main(String[] args) {
        System.out.println("-----------------");
    }
}
