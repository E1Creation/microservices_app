package com.indivara.apigateway.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Header {

  public static final String CONTENT_TYPE_JSON = "Content-Type: application/json";
  public static final String X_MEMBER_ID = "X-Member-Id";
  public static final String X_USERNAME = "X-UserName";
  public static final String AUTHORIZATION = "Authorization";
}
