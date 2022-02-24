package cg.zz.chapter09;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

// 从java中调用Groovy脚本
public class _010CallingScript {

    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("groovy");
        System.out.println("Calling script from Java");
        try {
            engine.eval("println 'Hello from Groovy'");
        } catch(ScriptException ex) {
            ex.printStackTrace();
        }
    }

}
