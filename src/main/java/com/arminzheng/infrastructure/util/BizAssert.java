package com.arminzheng.infrastructure.util;

import com.arminzheng.infrastructure.exception.BizException;
import org.springframework.lang.Nullable;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * BizAssert
 *
 * @author zy
 * @version 2022/2/27
 */
public class BizAssert {

  public static final String UN_CHOOSE_ARG = "未选中数据";

  public static void notNull(Object pojo, String msg) {
    if (pojo == null) {
      throw new BizException(msg);
    }
  }

  public static void notNull(Object pojo) {
    notNull(pojo, UN_CHOOSE_ARG);
  }

  public static void notEmpty(Object target, String msg) {
    if (isEmpty(target)) {
      throw new BizException(msg);
    }
  }

  public static void notEmpty(Object pojo) {
    notEmpty(pojo, UN_CHOOSE_ARG);
  }

  public static boolean isEmpty(@Nullable Object obj) {
    if (obj == null) {
      return true;
    } else if (obj instanceof Optional) {
      return !((Optional<?>) obj).isPresent();
    } else if (obj instanceof CharSequence) {
      return ((CharSequence) obj).length() == 0;
    } else if (obj.getClass().isArray()) {
      return Array.getLength(obj) == 0;
    } else if (obj instanceof Collection) {
      return ((Collection<?>) obj).isEmpty();
    } else {
      return obj instanceof Map && ((Map<?, ?>) obj).isEmpty();
    }
  }
}
