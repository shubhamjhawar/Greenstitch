package com.accenture.lkm.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.bean.PizzaBean;
import com.accenture.lkm.bean.PizzaOrderBean;
import com.accenture.lkm.dao.PizzaDAOWrapper;
import com.accenture.lkm.exception.NoRecordFoundException;
import com.accenture.lkm.service.PizzaServiceImpl;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/root-config.xml"})
@Transactional
public class PizzaServiceImplTest {
	
  @Autowired
  private PizzaServiceImpl pizzaServiceImpl;
  
  /**
   * 	
   * To-Do Item 1.25: This method tests the getOrderDetailsWithRecordsFound functionality in PizzaServiceImpl
     by retrieving pizza orders within a specified bill range from the database.
     TODO: Implement the testGetOrderDetailsWithRecordsFound method:
        --Prepare test data by setting valid fromBill and toBill values that exists in database.
        --Invoke the getOrderDetails method of pizzaServiceImpl, passing the fromBill and toBill..
        --Verify that PizzaOrder exists within the bill range.
        
   */
  @Test
  public void testGetOrderDetailsWithRecordsFound() throws Exception {
     double fromBill=10.0;
     double toBill=200.0;
     List<PizzaOrderBean> pizzaOrders=pizzaServiceImpl.getOrderDetails(fromBill, toBill);
     assertNotNull(pizzaOrders);
     assertTrue(!pizzaOrders.isEmpty());
     for(PizzaOrderBean pizzaOrder:pizzaOrders) {
    	 assertTrue(pizzaOrder.getBill()>=fromBill && pizzaOrder.getBill()<=toBill);
     }
  }
  
  /**
   * 	
   * To-Do Item 1.26: This method tests the getOrderDetailsWithNoRecordsFound functionality in PizzaServiceImpl
     by retrieving pizza orders within a specified bill range from the database when no records are found.
     TODO: Implement the testGetOrderDetailsWithNoRecordsFound method:
        --Set invalid fromBill and toBill values that do not correspond to any records in the database.
        --Verify that the NoRecordFoundException is thrown when invoking the getOrderDetails method of pizzaServiceImpl.
        --Verify that the message of the thrown exception matches the expected message: "No records were found for the entered Bill Range".
        
   */

  @Test(expected=NoRecordFoundException.class)
  public void testGetOrderDetailsWithNoRecordsFound() throws Exception {
     double fromBill=-1.0;
     double toBill=-2.0;
     try {
    	 pizzaServiceImpl.getOrderDetails(fromBill, toBill);
    	 fail("No Record Found Exception was expected");
     }catch(NoRecordFoundException e){
    	 assertEquals("No records were found for the entered Bill Range", e.getMessage());
         throw e;
     }
  }
  /**
   * 	
   * To-Do Item 1.27: This method tests the transactional behavior of adding a pizza order
     in PizzaServiceImpl by verifying that no changes are made to the database when adding a pizza order.
     TODO: Implement the testTransactionalBehavior method:
        --Prepare test data by setting valid fromBill and toBill values that exist in the database.
        --Retrieve the initial list of pizza orders using getOrderDetails method of pizzaServiceImpl.
        --Record the initial number of orders
        --Add a new pizza order using addPizzaOrderDetails method of pizzaServiceImpl.
        --Retrieve the final list of pizza orders using getOrderDetails method of pizzaServiceImpl.
        --Record the final number of orders.
        --Verify that the initial and final number of orders are equal, indicating that no changes were made to the database.
   */
  @Test
  public void testTransactionalBehavior() throws Exception {
	 double fromBill=100.0;
	 double toBill=200.0;
	 List<PizzaOrderBean> initialOrders=pizzaServiceImpl.getOrderDetails(fromBill, toBill);
	 int startCount=initialOrders.size();
	 try {
		 pizzaServiceImpl.addPizzaOrderDetails(new PizzaOrderBean());
		 fail("Expected RuntimeException to be thrown due to transactional rollback");
	 }catch(RuntimeException e) {
		 List<PizzaOrderBean> finalOrders = pizzaServiceImpl.getOrderDetails(fromBill, toBill);
		 int endCount = finalOrders.size();
		 assertEquals(startCount, endCount);
	 }
	 	}
  }






	


