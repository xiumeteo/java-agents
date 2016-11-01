package com.xiumeteo.agent;

import com.xiumeteo.agent.util.ClassLogger;

import java.lang.instrument.Instrumentation;

public class SimpleAgent {

    public static void premain(String args, Instrumentation instrumentation){
        ClassLogger logger = new ClassLogger();
        instrumentation.addTransformer(logger);
    }

}
