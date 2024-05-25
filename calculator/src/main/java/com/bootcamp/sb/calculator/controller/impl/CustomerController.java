package com.bootcamp.sb.calculator.controller.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.calculator.controller.CustomerOperation;
import com.bootcamp.sb.calculator.model.modeltest.Address;
import com.bootcamp.sb.calculator.model.modeltest.Customer;
import com.bootcamp.sb.calculator.model.modeltest.CustomerList;
import com.bootcamp.sb.calculator.model.modeltest.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@Controller
@ResponseBody
@ToString
public class CustomerController implements CustomerOperation{

/*  @GetMapping(value = "/customers/test")
  public CustomerList test(){
     return new CustomerList(
    List.of(new Customer("Vincent", (LocalDate.of(2013,10,03)),//
    List.of(new Order(1,(List.of(new Address("12345","abcd","Kowloon"))
    ))))),
    List.of(new Customer("Jenny",(LocalDate.of(2015,10,03)),
    List.of(new Order(2, List.of(new Address("12345","abcd","Kowloon")
    )))List.of(new Order(3,
    List.of(new Address("12345","abcd","Kowloon")
    )))))
    );
  }
*/

   @Override
   public CustomerList getList() {
    System.out.println("Start...........................................................................................");
    Address add1 = new Address("12345","abcd","Kowloon");
    List<Address> addressList = new ArrayList<>();
    System.out.println(addressList.toString());
    addressList.add(add1);
    Order o1 = new Order(1, addressList);
    Order o2 = new Order(2, addressList);
    Order o3 = new Order(3, addressList);
    List<Order> orderList = new ArrayList<>();
    List<Order> orderList2 = new ArrayList<>();
    orderList.add(o1);
    orderList2.add(o2);
    orderList2.add(o3);
    Customer c1 =
        new Customer("Vincent", LocalDate.of(2013, 10, 03), orderList);
    Customer c2 =
        new Customer("Jenny", LocalDate.of(2015,10,03), orderList2);
    List<Customer> customerList = new ArrayList<>();
    customerList.add(c1);
    customerList.add(c2);
    CustomerList result = new CustomerList(customerList);
    System.out.println(result.toString());
    System.out.println("End................................................................................................");
    return result;
  }
}
