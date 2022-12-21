package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author dongkewei
 * @date 2022/07/19 11:41 AM
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AccountDetail {

    /**
     * A meta object containing the current data status and the auth method
     */
    private Meta meta;

    /**
     * An object with all account data
     */
    private Account account;

    /**
     * The account name of the connected user
     */
    private String name;

    /**
     * The account number of the connected user
     */
    private String accountNumber;

    /**
     * The account type of the connected user E.g SAVINGS ACCOUNT, CURRENT ACCOUNT
     */
    private String type;

    /**
     * The current account balance of the connected user
     */
    private String balance;

    /**
     * The curency of the connected user (NGN, GHS ETC)
     */
    private String currency;

    /**
     * The BVN of the connected user
     */
    private String bvn;

    @Data
    public static class Meta {

        /**
         * The status of the returned connected data, if it is AVAILABLE, PROCESSING, FAILED
         */
        private String dataStatus;

        /**
         * This refers to the authentication method used by user. It returns either, mobile_banking or internet_banking
         */
        private String authMethod;

    }

    @Data
    public static class Account {

        /**
         * The unique identifier for the member which has new or updated transaction data
         */
        private String id;

        /**
         * All data related to the financial institution of the connected user
         */
        private Institution institution;

    }

    @Data
    public static class Institution {

        /**
         * The institution name of the connected account
         */
        private String name;

        /**
         * The bank code of the institution name connected to this account
         */
        private String bankCode;

        /**
         * The type of banking method for this connected user. E.g PERSONAL_BANKING, BUSINESS_BANKING etc
         */
        private String type;

    }

}
