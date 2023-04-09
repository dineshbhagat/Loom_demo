//package org.paumard.loom.threads;
//
//import jdk.incubator.concurrent.ExtentLocal;
//
//public class H0_ExtentLocal {
//
//    // --enable-preview --add-modules jdk.incubator.concurrent --add-exports java.base/jdk.internal.vm=ALL-UNNAMED
//
//    public static void main(String[] args) throws InterruptedException {
//
//        ExtentLocal<String> KEY = ExtentLocal.newInstance();
//
//        Runnable task = () -> System.out.println("Key is = " + KEY.get());
//
//        Runnable taskWithScopeLocalA = () -> ExtentLocal.where(KEY, "Value A").run(task);
//        Runnable taskWithScopeLocalB = () -> ExtentLocal.where(KEY, "Value B").run(task);
//
//        taskWithScopeLocalA.run();
//        taskWithScopeLocalB.run();
//    }
//}
//NOTE: Commented since I was using java 20 which does not have class `jdk.incubator.concurrent.ExtentLocal`
