package org.hasan.java17;

public sealed interface OoLanguage permits JavaLanguage {
    String printName();
}
