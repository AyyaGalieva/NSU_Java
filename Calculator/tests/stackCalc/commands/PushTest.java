package stackCalc.commands;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

    @Test
    void execute() {
        Push p = new Push();
        Map<String, Double> define = new HashMap<>();
        define.put("a", 4.0);
        Stack<Double> stack = new Stack<>();
        String[] s = new String[2];
        s[1] = "a";
        Double expected = 4.0;
        try {
            p.execute(define, stack, s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected, stack.pop());
    }
}