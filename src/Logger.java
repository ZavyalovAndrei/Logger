import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;
    private static Logger logger = null;
    private Logger() {};

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy H:mm:ss");
        String formatted = formatter.format(date);
        System.out.println("["+ formatted + " " + num++ + "] " + msg);
    }
}
