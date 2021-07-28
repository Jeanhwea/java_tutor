package io.github.jeanhwea.language.jdk.p12_spi.beans.impl;

import io.github.jeanhwea.language.jdk.p12_spi.beans.Person;

public class Doctor implements Person {

  @Override
  public void sayName() {
    System.out.println("I am a doctor!");
  }
}
