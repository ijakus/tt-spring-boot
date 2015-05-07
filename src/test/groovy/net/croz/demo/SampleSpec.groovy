package net.croz.demo

import spock.lang.Specification

class SampleSpec extends Specification {

  def "Spock specification in spring-boot works"() {
    expect:
    true
  }

  def "Customer toString method returns valid format"() {
    given:
    def customer = new Customer(name: name, age: age)

    expect:
    customer.toString() == displayName

    where:
    name | age || displayName
    'AA' | 12  || 'AA (12)'
    'BB' | 32  || 'BB (32)'
    'CC' | 2   || 'CC (2)'
  }
}
