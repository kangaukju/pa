package kr.co.projectd.logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class DLogger {
	Logger log;
	Map<String, Method> methodCache = new HashMap<String, Method>();
	
	public boolean isDebug() {
		return log.isDebugEnabled();
	}
	public boolean isTrace() {
		return log.isTraceEnabled();
	}
	public boolean isInfo() {
		return log.isInfoEnabled();
	}
	public static DLogger getLogger(Class<?> clazz) {
		return new DLogger(Logger.getLogger(clazz));
	}
	public void I(Object message) {
		log.info(message);
	}
	public void E(Object message) {
		log.error(message);
	}	
	public void T(Object message) {
		log.trace(message);
	}	
	public void D(Object message) {
		log.debug(message);
	}	
	public void W(Object message) {
		log.warn(message);
	}	
	public void F(Object message) {
		log.fatal(message);
	}
	public void i(Object message) {
		log.info(message);
	}
	public void e(Object message) {
		log.error(message);
	}	
	public void t(Object message) {
		log.trace(message);
	}	
	public void d(Object message) {
		log.debug(message);
	}	
	public void w(Object message) {
		log.warn(message);
	}	
	public void f(Object message) {
		log.fatal(message);
	}
	public void i(Class<?> filterClass, Object filter, Object target, Object message) {
		logging(filterClass, filter, target, "info", message);
	}
	public void e(Class<?> filterClass, Object filter, Object target, Object message) {
		logging(filterClass, filter, target, "error", message);
	}
	public void t(Class<?> filterClass, Object filter, Object target, Object message) {
		logging(filterClass, filter, target, "trace", message);
	}
	public void d(Class<?> filterClass, Object filter, Object target, Object message) {
		logging(filterClass, filter, target, "debug", message);
	}
	public void w(Class<?> filterClass, Object filter, Object target, Object message) {
		logging(filterClass, filter, target, "warn", message);
	}
	public void f(Class<?> filterClass, Object filter, Object target, Object message) {
		logging(filterClass, filter, target, "fatal", message);
	}
	
	private DLogger(Logger log) {
		this.log = log;
	}
	private Method findLog4jLogMethod(String name) {
		for (Method method : Logger.class.getMethods()) {
			if (method.getName().equals(name)) {
				if (method.getParameterTypes().length == 1) {
					return method;
				}
			}
		}
		throw new RuntimeException("Could not find Log4j method - "+name);
	}
	private void logging(Class<?> filterClass, Object filter, Object target, String methodName, Object message) {
		// TODO: getDeclaredMethods is only declared methods in this class
		for (Method method : filterClass.getMethods()) {			
			// only public getter method
			if (method.getName().startsWith("get") 
					&& !"getClass".equals(method.getName()))
			{
				try {
					Object filterResult = method.invoke(filter);
					Object targetResult = method.invoke(target);					
					
					if (targetResult == null || filterResult == null) {
						continue;
					}
					
					if (filterResult.equals(targetResult)) {
						
						// check cache
						Method logMethod = methodCache.get(methodName);
						if (logMethod == null) {
							logMethod = findLog4jLogMethod(methodName);
							methodCache.put(methodName, logMethod);
						}
						/*
						else System.out.println("find cache method - " + methodName);
						*/
						logMethod.invoke(log, message);
					}
					
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					throw new RuntimeException(e);					
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
}
