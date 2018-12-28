package stackCalc.commands;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {

    @Test
    void execute() {
        Print pr = new Print();
        Map<String, Double> define = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        stack.push(5.0);
        stack.push(3.5);
        String[] s = new String[0];
        int expected = 2;
        try {
            pr.execute(define, stack, s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected, stack.size());
    }
}