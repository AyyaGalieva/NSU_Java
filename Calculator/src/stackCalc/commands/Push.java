package stackCalc.commands;

import stackCalc.Command;
import stackCalc.exceptions.CommandException;

import java.util.Map;
import java.util.Stack;

public class Push implements Command {
    public void execute(Map<String, Double> define, Stack<Double> stack, String[] s) throws CommandException {
        if (s.length < 2)
            throw new CommandException("few arguments");

        if (define.containsKey(s[1]))
            stack.push(define.get(s[1]));
        else
            stack.push(Double.valueOf(s[1]));
    }
}
