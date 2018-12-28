package stackCalc;

import org.apache.log4j.Logger;
import stackCalc.exceptions.FactoryException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandFactory {
    private static final Logger logger = Logger.getLogger(CommandFactory.class.getSimpleName());

    private Map<String, String> commandConf = new HashMap<>();
    private static CommandFactory instance = new CommandFactory();
    private CommandFactory() {
        Properties prop = new Properties();

        try (InputStream config = CommandFactory.class.getResourceAsStream("cmd.properties")) {
            prop.load(config);

        }catch(IOException e) {
            logger.error("Unable to open config stream");
        }

        for (String strCmd : prop.stringPropertyNames())
            commandConf.put(strCmd, (String)prop.get(strCmd));
    }
    public static CommandFactory getInstance() {
        return instance;
    }
    public Command getCmd(String cmdName) throws FactoryException {
        Class c;
        if (commandConf.containsKey(cmdName)) {
            try {
                c = Class.forName(commandConf.get(cmdName));
                return (Command)c.newInstance();
            }catch (Exception e){
                throw new FactoryException("Unable to instance the class");
            }
        }
        else
            throw new FactoryException("no such command in config");
    }
}
