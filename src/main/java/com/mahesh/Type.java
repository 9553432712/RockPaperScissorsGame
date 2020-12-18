package com.mahesh;


import java.util.HashMap;
import java.util.Map;

//@Getter
public enum Type {
  R("ROCK", 0),
  P("PAPER", 1),
  S("SCISSOR", 2),
  N("NONE", -1);

  private static final Map<Integer, Type> typeHashMap = new HashMap<>();

  static {
    for (Type type : Type.values()) {
      typeHashMap.put(type.ordinal(), type);
    }
  }

  private final String description;
  private final int value;

  public static Type valueOf(int value) {
    return typeHashMap.get(value);
  }

  private Type(String description, int value) {
    this.description = description;
    this.value = value;
  }

  public static String getRepresentation() {
    StringBuilder resultBuffer = new StringBuilder();
    for (Type type : Type.values()) {
      resultBuffer.append(type.name());
      resultBuffer.append("-->");
      resultBuffer.append(type.description + "\t");
    }
    return resultBuffer.toString();
  }

}
