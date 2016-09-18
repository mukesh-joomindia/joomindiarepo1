package in.xgen.asepect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

	private static Logger logger = Logger.getLogger(LoggingAspect.class);
	/**
	    * Log method entry.
	    * 
	    * @param joinPoint
	    */
	public void logEntry(final JoinPoint joinPoint)
	   {
	      log("Entering method " + joinPoint.getSignature().getName() + "...");
	   }
	
	/**
	    * Log method exit.
	    * 
	    * @param joinPoint
	    */
	   public void logExit(final JoinPoint joinPoint)
	   {
	      log("Exiting method " + joinPoint.getSignature().getName() + ".");
	   }
	   
	   /**
	    * Log method exit after returning.
	    * 
	    * @param joinPoint
	    */
	   
	   public void logExitAfterReturn(final JoinPoint joinPoint)
	   {
	      log(  "Exiting method (after return) "
	          + joinPoint.getSignature().getName() + ".");
	   }

	   /**
	    * "Log" the provided String.
	    * 
	    * @param messageToLog String to be logged.
	    */
	   public static void log(final String messageToLog)
	   {
		   System.out.println(messageToLog);
	   }
}
