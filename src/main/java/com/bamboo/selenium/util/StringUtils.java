package com.bamboo.selenium.util;

import cn.hutool.core.util.StrUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: GuoQing
 * @Date: 2019/3/28 11:30
 * @description
 */
public class StringUtils extends StrUtil {

  /**
   * 判断是否是数字
   * @param str
   * @return
   */
  public static boolean isNumeric(String str){
    Pattern pattern = Pattern.compile("[0-9]*");
    Matcher isNum = pattern.matcher(str);
    if( !isNum.matches() ){
      return false;
    }
    return true;
  }

}
