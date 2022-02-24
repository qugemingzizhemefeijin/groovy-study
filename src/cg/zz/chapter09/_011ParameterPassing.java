package cg.zz.chapter09;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

// 传递参数给Groovy脚本
public class _011ParameterPassing {

    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("groovy");

        try {
            Bindings bindings = engine.createBindings();
            bindings.put("name", "dan");
            engine.eval("println \"Hello ${name} from Groovy\"; name += '!' ", bindings);
            System.out.println("Back in Java:" + bindings.get("name"));
            System.out.println("======================================");
            engine.put("name", "Venkat");
            engine.eval("println \"Hello ${name} from Groovy\"; name += '!' ");
            String name = (String) engine.get("name");
            System.out.println("Back in Java:" + name);
        } catch(ScriptException ex) {
            ex.printStackTrace();
        }
    }

}
