package net.croz.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

@SpringApplicationConfiguration(classes = CustomerDemoApplication.class)
@WebAppConfiguration
class IntegrationSampleSpec extends Specification implements CustomerHelper {

  @Autowired
  CustomerRepository customerRepository

  def "Spock integration specification in spring-boot works"() {
    expect:
    true
  }

  def "Customer is persisted in database"() {
    given:
    def customer = new Customer(name: 'Ivo Ivic', age: 11)

    when:
    customerRepository.create(customer)

    then:
    customerCount() == old(customerCount()) + 1
  }


  def "It is possible to find customers older than some age"() {
    given:
    def customerList = (0..numberOfCustomers).collect {
      new Customer(name: "Name${it}", age: it + 10)
    }

    when:
    customerList.each { customerRepository.create(it)}

    then:
    customerOlderThanCount(age) == old(customerOlderThanCount(age)) + expectedResult

    where:
    numberOfCustomers | age || expectedResult
    5                 | 10  || 5
    10                | 55  || 0
  }
}
