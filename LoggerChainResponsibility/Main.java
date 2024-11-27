package LoggerChainResponsibility;

public class Main {
    public static void main(String[] args) {
        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logObject.log(LogProcessor.ERROR, "exceptions happens");
        logObject.log(LogProcessor.DEBUG, "need to debug");
        logObject.log(LogProcessor.INFO, "just for Info");

    }
}
