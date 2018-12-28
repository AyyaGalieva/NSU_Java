package stackCalc;

import org.apache.log4j.Logger;
import stackCalc.exceptions.FactoryException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Run {

    private static final Logger logger = Logger.getLogger(Run.class.getSimpleName());

    Stack<Double> stack = new Stack<>();
    Map<String, Double> define = new HashMap<>();

    public void run(String file) throws FileNotFoundException {
        Scanner sc;
        if (file.equals(""))
            sc = new Scanner(System.in);
        else
            sc = new Scanner(new FileInputStream(file));

        String str;

        while (sc.hasNextLine()) {
            str = sc.nextLine();
            if (str.charAt(0) == '#')
                continue;
            String[] s = str.split(" ");
            Command cmd = null;
            try {
                cmd = CommandFactory.getInstance().getCmd(s[0]);
            }catch (FactoryException e){
                logger.error(e.getMessage());
            }
            try {
                    cmd.execute(define, stack, s);
            }catch (Exception e) {
                    logger.error(e.getMessage());
            }
        }
    }
}
