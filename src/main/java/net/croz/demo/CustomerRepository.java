package net.croz.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

  private final JdbcOperations database;

  @Autowired
  public CustomerRepository(JdbcOperations database) {
    this.database = database;
  }

  public void create(Customer customer) {
    database.update("INSERT INTO CUSTOMER (name, age)VALUES (?, ?)", new Object[]{customer.getName(), customer.getAge()});
  }

  public List<Customer> findAll() {
    return database.query("SELECT name, age FROM CUSTOMER", new BeanPropertyRowMapper<Customer>(Customer.class));
  }

  public List<Customer> findAllOlderThan(Integer age) {
    return database.query("SELECT name, age FROM CUSTOMER WHERE age > ?", new Object[] { age }, new BeanPropertyRowMapper<Customer>(Customer.class));
  }
}
