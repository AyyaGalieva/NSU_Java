package stackCalc.commands;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {

    @Test
    void execute() {
        Define def = new Define();
        Map<String, Double> define = new HashMap<>();
        define.put("a", 5.0);
        Stack<Double> stack = new Stack<>();
        String[] s = new String[3];
        s[1] = "a";
        s[2] = "3.0";
        Double expected = 3.0;
        try {
            def.execute(define, stack, s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected, define.get("a"));
    }
}