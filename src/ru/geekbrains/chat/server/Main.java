package ru.geekbrains.chat.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class Main {

    public static final Logger logger = Logger.getLogger("");

    public static void main(String[] args) throws IOException {

        logger.setLevel(Level.ALL);
        logger.getHandlers()[0].setLevel(Level.ALL);

        LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));

        logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });

        Handler handler = new FileHandler("serverLog.log", true);
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);

        new Server();
    }
}