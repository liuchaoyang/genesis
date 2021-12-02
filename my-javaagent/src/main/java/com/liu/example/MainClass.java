package com.liu.example;



public class MainClass {

    //-javaagent:/xxx/java/liu/genesis/my-javaagent/target/my-javaagent.jar
    public static void main(String[] args) {
        System.out.println("main");

//        try {
//            String name = ManagementFactory.getRuntimeMXBean().getName();
//            System.out.println("jvm name:" + name);
//            String pid = name.substring(0, name.indexOf("@"));
//            System.out.println("jvm pid:" + pid);
//            com.sun.tools.attach.VirtualMachine virtualMachine = com.sun.tools.attach.VirtualMachine.attach(pid);
//            virtualMachine.loadAgent("/Users/liuchaoyang/Documents/java/liu/genesis/my-javaagent/target/my-javaagent.jar", "");
//            virtualMachine.detach();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
