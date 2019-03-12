/*
 *
 *  Class Name: Withddraw
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
package com.app.consumer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.app.data.AccountDetails;

/**
 * <h1>Withddraw</h1> <b>enter short description(less than 80 chars)</b>
 * <p>
 * Enter more detailed description here
 * </p>
 * .
 */
public class Withddraw extends Thread {
    private static final Logger logger = LogManager.getLogger(Withddraw.class);

    /** The account details. */
    private AccountDetails accountDetails;

    /** The amount to withdraw. */
    private Double amountToWithdraw;

    /** The bool exit. */
    private boolean boolExit = false;

    /** The check. */
    private boolean check = false;

    /**
     * <h1>Withddraw</h1> <b>Instantiates a new withddraw.</b>
     * <p>
     * Withdraw thread performs withdraw and balance check in account details object
     * </p>
     *
     * @param accountDetails
     *        the account details
     * @param amountToWithdraw
     *        the amount to withdraw
     * @param check
     *        the check to determine what to be checked
     */
    public Withddraw(AccountDetails accountDetails, Double amountToWithdraw, boolean check) {
        this.accountDetails = accountDetails;
        this.amountToWithdraw = amountToWithdraw;
        this.check = check;
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
        while (!boolExit) {
            try {
                if (!check) {

                    Double value = accountDetails.getAccountBalance();
                    if (value > amountToWithdraw) {
                        accountDetails.withdraw(amountToWithdraw);
                        logger.info("account balance after withdraw is : " + accountDetails.getAccountBalance());
                    }
                } else {
                    logger.info("account balance is : " + accountDetails.getAccountBalance());
                }
                Thread.sleep(1);
            } catch (InterruptedException e) {

                logger.info(e.getMessage());
            }
        }
    }
}
