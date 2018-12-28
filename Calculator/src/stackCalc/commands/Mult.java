package stackCalc.commands;

import stackCalc.Command;
import stackCalc.exceptions.CommandException;

import java.util.Map;
import java.util.Stack;

public class Mult implements Command {
    public void execute(Map<String, Double> define, Stack<Double> stack, String[] s) throws CommandException{
        if (stack.empty())
            throw new CommandException("stack is empty");
        else if (stack.size() == 1)
            throw new CommandException("only 1 argument in the stack");

        stack.push(stack.pop() * stack.pop());
    }
}
