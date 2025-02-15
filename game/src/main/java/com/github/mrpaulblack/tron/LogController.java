package com.github.mrpaulblack.tron;

import java.time.LocalDateTime;

public abstract class LogController {
    private static StackTraceElement element;
	private static Log globalLogLvl = Log.INFO;

	/**
	 *	<h1><i>setGlobalLogLvl</i></h1>
	 * <p>Sets globalLogLvl attribute with the Log ENUM. This method changes the level of the log
	 * based on the log level provided.</p>
	 * @param logLvl - Log ENUM that changes the global log level
	 */
	public static void setGlobalLogLvl(Log logLvl) {
		globalLogLvl = logLvl;
	}

	/**
	 *	<h1><i>getGlobalLogLvl</i></h1>
	 * <p>Gets the globalLogLvl attribute with the Log ENUM.</p>
	 * @return Log - returns the current global log level
	 */
	public static Log getGlobalLogLvl() {
		return globalLogLvl;
	}

	/**
	 *	<h1><i>log</i></h1>
	 * <p>This static method gets called every time a line is added to the log.
	 * It gets the line and the level and prints it in the terminal based on the global
	 * level.</p>
	 * @param logLvl - Log ENUM sets the log level of that line
	 * @param logLine - String is the actual log line (you can use [object].toString() when calling this method)
	 */
	public static void log(Log logLvl, String logLine) {
		//error lvl
		if (globalLogLvl == Log.ERROR && logLvl == Log.ERROR) {
			element = Thread.currentThread().getStackTrace()[2];
			System.out.println(LocalDateTime.now() + " [" + logLvl + "] (" + element.getClassName() + ") " + logLine);
		}
		//info lvl
		else if (globalLogLvl == Log.INFO && (logLvl == Log.ERROR || logLvl == Log.INFO)) {
			element = Thread.currentThread().getStackTrace()[2];
			System.out.println(LocalDateTime.now() + " [" + logLvl + "] (" + element.getClassName() + "." + element.getMethodName() + ") " + logLine);
		}
		//debug lvl
		else if (globalLogLvl == Log.DEBUG && (logLvl == Log.ERROR || logLvl == Log.INFO || logLvl == Log.DEBUG)) {
			element = Thread.currentThread().getStackTrace()[2];
			System.out.println(LocalDateTime.now() + " [" + logLvl + "] (" + element.getClassName() + "." + element.getMethodName() + "$" + element.getLineNumber() + ") " + logLine);
		}
		//trace lvl
		else if (globalLogLvl == Log.TRACE && (logLvl == Log.ERROR || logLvl == Log.INFO || logLvl == Log.DEBUG || logLvl == Log.TRACE)) {
			element = Thread.currentThread().getStackTrace()[2];
			System.out.println(LocalDateTime.now() + " [" + logLvl + "] (" + element.getClassName() + "." + element.getMethodName() + "$" + element.getLineNumber() + ") " + logLine);
		}
	}    
}
