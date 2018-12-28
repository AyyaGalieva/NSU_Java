package stackCalc.commands;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {

    @Test
    void execute() {
        Add add = new Add();
        Map<String, Double> define = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        stack.push(3.8);
        stack.push(2.5);
        String[] s = new String[0];
        Double expected = 6.3;
        try {
            add.execute(define, stack, s);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expected, stack.pop());
    }
}