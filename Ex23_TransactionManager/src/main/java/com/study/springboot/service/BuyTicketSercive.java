package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;

@Service
public class BuyTicketSercive implements IBuyTicketSercive {

	@Autowired
	ITransaction1Dao transaction1;
	@Autowired
	ITransaction2Dao transaction2;
	@Autowired
	PlatformTransactionManager transactionManager;
	@Autowired
	TransactionDefinition definition;
	
	@Override
	public int buy (String consumerId, int amount, String error)
	{
		//트랙잭션 
		TransactionStatus status = transactionManager.getTransaction(definition);
		try
		{
			//여기로 롤백을 함
			transaction1.pay(consumerId, amount);
			
			if(error.equals("1")) {int n = 10 / 0;}
			
			transaction2.pay(consumerId, amount);
			
			transactionManager.commit(status);
			
			return 1;
		} 
		catch (Exception e)
		{
			System.out.println("[PlatformTransactionManager] RollBack");
			//에러가 나면 transaction1 안에 들어와 있던 데이터도
			//롤백 되어서 없어짐
			transactionManager.rollback(status);
			return 0;
		}
	}
}
