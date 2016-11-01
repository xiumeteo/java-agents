package com.xiumeteo.agent.util;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.ProtectionDomain;

public class ClassLogger implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, //
                            String className,  //
                            Class<?> classBeingRedefined, //
                            ProtectionDomain protectionDomain, //
                            byte[] classfileBuffer) throws IllegalClassFormatException { //
        try {
            System.out.println("Class being redefined:" + className);

            if( className.contains("LambdaConsumer") ){
                Path path = Paths.get("classes/" + className + ".class");
                Files.write(path, classfileBuffer);
            }


        } catch (Throwable ignored) { // ignored, don’t do this at home kids
            ignored.printStackTrace();
        } finally {
            return classfileBuffer;
        }
    }
}
