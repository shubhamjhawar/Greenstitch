package com.accenture.lkm.dao;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.PizzaOrderEntity;


/**
To-Do Item 1.3: Define a custom repository for managing Pizza orders.
	TODO:
	--Use custom repository.
	--Add a method to save pizza order details in the database.
*/
@RepositoryDefinition(idClass=Integer.class,domainClass=PizzaOrderEntity.class)
@Transactional(value = "txManager")
public interface PizzaOrderDAO {
	PizzaOrderEntity save(PizzaOrderEntity entity);
}
