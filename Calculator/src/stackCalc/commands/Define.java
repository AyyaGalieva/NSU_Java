package stackCalc.commands;

import stackCalc.Command;
import stackCalc.exceptions.CommandException;

import java.util.Map;
import java.util.Stack;

public class Define implements Command {
    public void execute(Map<String, Double> define, Stack<Double> stack, String[] s) throws CommandException{
        if (s.length < 3)
            throw new CommandException("few arguments");
        define.put(s[1], Double.valueOf(s[2]));
    }
}
