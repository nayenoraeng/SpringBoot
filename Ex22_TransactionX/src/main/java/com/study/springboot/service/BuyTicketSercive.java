package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;

@Service
public class BuyTicketSercive implements IBuyTicketSercive {

	@Autowired
	ITransaction1Dao transaction1;
	@Autowired
	ITransaction2Dao transaction2;
	
	@Override
	public int buy (String consumerId, int amount, String error)
	{
		try
		{
			transaction1.pay(consumerId, amount);
			
			if(error.equals("1")) {int n = 10 / 0;}
			
			transaction2.pay(consumerId, amount);
			
			return 1;
		} 
		catch (Exception e)
		{
			return 0;
		}
	}
}
