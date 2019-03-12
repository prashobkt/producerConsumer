/*
 *
 *  Class Name: Deposit
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
package com.app.producer;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.app.consumer.Withddraw;
import com.app.data.AccountDetails;

/**
 * <h1>Deposit</h1> <b>This thread act as a producer</b>
 * <p>
 * Deposit thread changes the account balance
 * </p>
 * .
 */
public class Deposit extends Thread {
    private static final Logger logger = LogManager.getLogger(Deposit.class);

    /** The account details. */
    private AccountDetails accountDetails;

    /** The amount to deposit. */
    private Double amountToDeposit;

    /** The consumer threads. */
    private List<Withddraw> consumerThreads;

    /** The bool exit. */
    private boolean boolExit = false;

    /**
     * <h1>Deposit</h1> <b>Instantiates a new deposit.</b>
     * <p>
     * Enter more detailed description here
     * </p>
     *
     * @param accountDetails
     *        the account details
     * @param amountToDeposit
     *        the amount to deposit
     * @param consumerThreads
     *        the consumer threads
     */
    public Deposit(AccountDetails accountDetails, Double amountToDeposit, List<Withddraw> consumerThreads) {
        this.accountDetails = accountDetails;
        this.amountToDeposit = amountToDeposit;
        this.consumerThreads = consumerThreads;
    }

    /**
     * Sets the exit condition.
     *
     * @param boolExit
     *        the new exit condition
     */
    public void setExitCondition(boolean boolExit) {
        this.boolExit = boolExit;
    }

    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        logger.info("Started Deposit thread");
        while (!boolExit) {

            accountDetails.deposit(amountToDeposit);
            logger.info("add data producer :  " + accountDetails.getAccountBalance());
            if (accountDetails.getAccountBalance() >= 100000.0) {
                setExitCondition(true);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException exception) {

                logger.error(exception.getMessage());
            }
        }
        //close all consumer threads
        logger.info("closing all consumer threads");
        for (Withddraw withdraw : consumerThreads) {
            withdraw.setExitCondition(true);
        }

    }

}
