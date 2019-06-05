package autoit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerDemo 
{
public Logger log = Logger.getLogger(LoggerDemo.class);
public void loggerDebug()
{
	log.debug("this is a debug method");
}
public void loggerInfo()
{
	log.info("This is information about AUT");
}
public void loggerError()
{
	log.error("This is an error message");
}

public void loggerFatal()
{
	log.fatal("this is fatal error occured  during execution");
}

public void loggerWarn()
{
	log.warn("This is a warning message");
}
@Test
public void LoggerDemo()
{
	loggerDebug();
	loggerError();
	loggerFatal();
	loggerWarn();
	loggerInfo();
	
}
}
