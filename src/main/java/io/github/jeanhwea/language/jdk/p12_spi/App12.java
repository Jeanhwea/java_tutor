package io.github.jeanhwea.language.jdk.p12_spi;

import io.github.jeanhwea.language.jdk.p12_spi.beans.Person;
import java.util.*;

/**
 * SPI
 *
 * @author Jinghui Hu
 * @since 2021-07-28, JDK1.8
 */
@SuppressWarnings("all")
public class App12 {

  public static void main(String[] args) {
    ServiceLoader<Person> persons = ServiceLoader.load(Person.class);
    persons.forEach(Person::sayName);
  }
}
