package com.sbs.basic1.base.rsData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData {
  private final String resultCode;
  private final String msg;
  private final Object data;

  public static RsData of(String resultCode, String msg) {
    return of(resultCode, msg, null);
  }

  public static RsData of(String resultCode, String msg, Object data) {
    return new RsData(resultCode, msg, data);
  }

  public boolean isSuccess() {
    return resultCode.startsWith("S-");
  }

  /*
  public boolean abc() {
    return false;
  }
   */

  /*
  public boolean isAbc() { // 이름이랑 관련이 있다. --> isAbc(int a) : 이런 형태는 나오지 않는다.
    return false;
  }
   */
}
