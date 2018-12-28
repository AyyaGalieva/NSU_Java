package stackCalc;

import stackCalc.exceptions.CommandException;

import java.util.Map;
import java.util.Stack;

public interface Command {
    void execute(Map<String, Double> define, Stack<Double> stack, String[] s) throws CommandException;
}