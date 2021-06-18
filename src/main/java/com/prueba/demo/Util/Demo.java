package com.prueba.demo.Util;

import java.io.File;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {
    private static boolean logToFile;
    private static boolean logToConsole;
    private static boolean logMessage;
    private static boolean logWarning;
    private static boolean logError;
    private static boolean logToDatabase;
    private static Map<?, ?> dbParams;
    private static Logger logger;

    public Demo(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
                boolean logMessageParam, boolean logWarningParam, boolean logErrorParam) {
        logger = Logger.getLogger("MyLog");
        logError = logErrorParam;
        logMessage = logMessageParam;
        logWarning = logWarningParam;
        logToDatabase = logToDatabaseParam;
        logToFile = logToFileParam;
        logToConsole = logToConsoleParam;
        dbParams =  ReadWriteFiles.leerArchivoConfig("static/config");
    }

    public static void LogMessage(String messageText, boolean message, boolean warning, boolean error) throws Exception {
        messageText.trim();
        Statement stmt = null;
        if (messageText == null || messageText.length() == 0) {
            return;
        }
        if (!logToConsole && !logToFile && !logToDatabase) {
            throw new Exception("Invalid configuration");
        }
        if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
            throw new Exception("Error or Warning or Message must be specified");
        }
        String l = null;
        if (dbParams!=null) {
            File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt");
            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            FileHandler fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt");
            ConsoleHandler ch = new ConsoleHandler();

            if(logToFile) {
                logger.addHandler(fh);
                logger.log(Level.INFO, messageText);
            }

            if(logToConsole) {
                logger.addHandler(ch);
                logger.log(Level.INFO, messageText);
            }

            stmt = new DatabaseConnection(dbParams).ConnectionBD();
        }
        if(logToDatabase && stmt!= null) {
            stmt.executeUpdate("insert into trazas (mensaje) values ('" + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + "-" + messageText + "')");
            stmt.close();
        }

    }
}
