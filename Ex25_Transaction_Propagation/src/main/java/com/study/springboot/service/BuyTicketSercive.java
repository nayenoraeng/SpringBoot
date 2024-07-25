package com.study.springboot.service;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;

@Service
public class BuyTicketSercive implements IBuyTicketSercive {

	@Autowired
	ITransaction1Dao transaction1;
	@Autowired
	ITransaction2Dao transaction2;
//	@Autowired
//	PlatformTransactionManager transactionManager;
//	@Autowired
//	TransactionDefinition definition;
	@Autowired
	TransactionTemplate transactionTemplate;
	
	//1,2 와 3 은 별도의 트랜잭션으로 처리 1,2는 입력되난 3은안된다.
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
	//전체 처리가 된다.
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int buy (String consumerId, int amount, String error)
	{
		//트랙잭션 
//		TransactionStatus status = transactionManager.getTransaction(definition);
		try
		{
			transactionTemplate.execute(new TransactionCallbackWithoutResult()
			{
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0)
				{
					transaction1.pay(consumerId, amount);
					
					if(error.equals("1")) {int n = 10 / 0;}
					
					transaction2.pay(consumerId, amount);
					
				}
			});
			
			return 1;
		} 
		catch (Exception e)
		{
			System.out.println("[Transaction prapagation #2] RollBack");
			return 0;
		}
	}
}
