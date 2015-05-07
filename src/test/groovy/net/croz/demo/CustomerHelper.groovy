package net.croz.demo

trait CustomerHelper {

  abstract CustomerRepository getCustomerRepository()

  int customerCount() {
    customerRepository.findAll().size()
  }

  int customerOlderThanCount(int age) {
    customerRepository.findAllOlderThan(age).size()
  }
}
