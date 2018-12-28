package stackCalc.commands;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SubTest {

    @Test
    void execute() {
        Sub sub = new Sub();
        Map<String, Double> define = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        Double a = 3.8;
        Double b = 5.0;
        stack.push(a);
        stack.push(b);
        String[] s = new String[0];
        Double expected = b - a;
        try {
            sub.execute(define, stack, s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected, stack.pop());
    }
}