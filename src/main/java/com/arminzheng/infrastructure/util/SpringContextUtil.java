package com.arminzheng.infrastructure.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
public class SpringContextUtil implements ApplicationContextAware {

  public static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(@NonNull ApplicationContext applicationContext)
      throws BeansException {
    SpringContextUtil.applicationContext = applicationContext;
  }

  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  public static String getProperty(String path) {
    return applicationContext.getEnvironment().getProperty(path);
  }

  public static Object getBean(String name) throws BeansException {
    if (applicationContext == null) return null;
    return applicationContext.getBean(name);
  }

  public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
    if (applicationContext == null) return null;
    return applicationContext.getBean(name, requiredType);
  }
}
