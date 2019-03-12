/*
 *
 *  Class Name: Main
 *  Created by: prashob
 *  Date: Mar 12, 2019
 *  
 *  Version: 1.0
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: prashob
 *  Date: Mar 12, 2019
 *  Desc: Created and Implemented
 */
package com.app.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.app.consumer.Withddraw;
import com.app.data.AccountDetails;
import com.app.producer.Deposit;

/**
 * <h1>Main</h1> <b>enter short description(less than 80 chars)</b>
 * <p>
 * Enter more detailed description here
 * </p>
 * .
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    /**
     * The main method.
     *
     * @param args
     *        the arguments
     */
    public static void main(String... args) {
        logger.info("Task Excecution started");
        List<Withddraw> ConsumerThreads = new ArrayList<>();

        //create a data object and add data
        AccountDetails mydetails = new AccountDetails();
        mydetails.setAccId(1000);
        mydetails.setAccountName("MyName");
        mydetails.setAccountBalance(10.0);

        logger.info("initialize consumer threads");
        Withddraw amountWithdraw = new Withddraw(mydetails, 100.0, false);
        amountWithdraw.start();
        Withddraw balanceCheck = new Withddraw(mydetails, 0.0, true);
        balanceCheck.start();

        logger.info("storing consumer threads in a arraylist");
        ConsumerThreads.add(amountWithdraw);
        ConsumerThreads.add(balanceCheck);

        logger.info("triggering producer thread");
        Deposit producer = new Deposit(mydetails, 1000.0, ConsumerThreads);
        producer.start();
    }
}
