/*
 *
 *  Class Name: AccountDetails
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
package com.app.data;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * <h1>AccountDetails</h1> <b>enter short description(less than 80 chars)</b>
 * <p>
 * Enter more detailed description here
 * </p>
 * .
 */
public class AccountDetails {
    private static final Logger logger = LogManager.getLogger(AccountDetails.class);
    /** The acc id. */
    private int accId;

    /** The account name. */
    private String accountName;

    /** The account balance. */
    private Double accountBalance = 0.0;

    /**
     * Gets the acc id.
     *
     * @return the acc id
     */
    public int getAccId() {
        synchronized (this) {
            return accId;
        }
    }

    /**
     * Sets the acc id.
     *
     * @param accId
     *        the new acc id
     */
    public void setAccId(int accId) {
        synchronized (this) {
            this.accId = accId;
        }
    }

    /**
     * Gets the account name.
     *
     * @return the account name
     */
    public String getAccountName() {
        synchronized (this) {
            return accountName;
        }
    }

    /**
     * Sets the account name.
     *
     * @param accountName
     *        the new account name
     */
    public void setAccountName(String accountName) {
        synchronized (this) {
            this.accountName = accountName;
        }
    }

    /**
     * Gets the account balance.
     *
     * @return the account balance
     */
    public Double getAccountBalance() {
        synchronized (this) {
            return accountBalance;
        }
    }

    /**
     * Sets the account balance.
     *
     * @param accountBalance
     *        the new account balance
     */
    public void setAccountBalance(Double accountBalance) {
        synchronized (this) {
            this.accountBalance = accountBalance;
        }
    }

    /**
     * <h1>withdraw</h1> <b>Withdraw.</b>
     * <p>
     * Enter more detailed description here
     * </p>
     *
     * @param value
     *        the value
     */
    public void withdraw(Double value) {
        synchronized (this) {
            accountBalance = accountBalance - value;
        }

    }

    /**
     * <h1>deposit</h1> <b>Deposit.</b>
     * <p>
     * Enter more detailed description here
     * </p>
     *
     * @param value
     *        the value
     */
    public void deposit(Double value) {
        synchronized (this) {
            accountBalance = accountBalance + value;
        }
    }
}
