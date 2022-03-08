package com.arminzheng.infrastructure.util;

import java.util.UUID;

/**
 * UuidUtil
 *
 * @author zy
 * @version 2022/1/26
 */
public class UUidUtils {
  public static String generatedUUID16() {
    return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
  }
}
