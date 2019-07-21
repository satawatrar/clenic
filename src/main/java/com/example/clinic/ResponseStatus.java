package com.example.clinic;

import java.util.stream.Stream;

//@deprecated This enum will be removed in Version 2.0.0
public enum ResponseStatus {

    SUCCESS("0", "SUCCESS") {
        @Override
        public boolean isMatched(String responseCode) {
            return SUCCESS.getCode().equalsIgnoreCase(responseCode);
        }
    },
    FAIL("1", "FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    AUTHENTICATION_FAIL("1001", "AUTHENTICATION_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return AUTHENTICATION_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    }, INVALID_AMOUNT("20054", "INVALID_AMOUNT") {
        @Override
        public boolean isMatched(String responseCode) {
            return INVALID_AMOUNT.getCode().equalsIgnoreCase(responseCode);
        }
    },
    SIGNATURE_NOT_MATCH("1002", "SIGNATURE_NOT_MATCH") {
        @Override
        public boolean isMatched(String responseCode) {
            return SIGNATURE_NOT_MATCH.getCode().equalsIgnoreCase(responseCode);
        }
    },
    TOKEN_EXPIRED("1003", "TOKEN_EXPIRED") {
        @Override
        public boolean isMatched(String responseCode) {
            return TOKEN_EXPIRED.getCode().equalsIgnoreCase(responseCode);
        }
    },
    OTP_REQUIRED_FAIL("1004", "OTP_REQUIRED_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return OTP_REQUIRED_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    OTP_FAIL("1005", "OTP_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return OTP_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    UPDATE_OTP_FAIL("1006", "UPDATE_OTP_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return UPDATE_OTP_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    REFRESH_TOKEN_FAIL("1007", "REFRESH_TOKEN_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return REFRESH_TOKEN_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },

    INVALID_CHANNEL("2001", "INVALID_CHANNEL") {
        @Override
        public boolean isMatched(String responseCode) {
            return INVALID_CHANNEL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    TRANSACTION_ID_DUPLICATE("2002", "TRANSACTION_ID_DUPLICATE") {
        @Override
        public boolean isMatched(String responseCode) {
            return TRANSACTION_ID_DUPLICATE.getCode().equalsIgnoreCase(responseCode);
        }
    },
    CANNOT_UPDATE_DATABASE("2003", "CANNOT_UPDATE_DATABASE") {
        @Override
        public boolean isMatched(String responseCode) {
            return CANNOT_UPDATE_DATABASE.getCode().equalsIgnoreCase(responseCode);
        }
    },
    EXCHANGE_RATE_NOT_MATCH("2004", "EXCHANGE_RATE_NOT_MATCH") {
        @Override
        public boolean isMatched(String responseCode) {
            return EXCHANGE_RATE_NOT_MATCH.getCode().equalsIgnoreCase(responseCode);
        }
    },
    DATA_NOT_FOUND("2005", "DATA_NOT_FOUND") {
        @Override
        public boolean isMatched(String responseCode) {
            return DATA_NOT_FOUND.getCode().equalsIgnoreCase(responseCode);
        }
    },
    GENERATE_PASSCODE_FAIL("2006", "GENERATE_PASSCODE_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return GENERATE_PASSCODE_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    FAIL_CANCEL_DUPLICATE("2007", "FAIL_CANCEL_DUPLICATE") {
        @Override
        public boolean isMatched(String responseCode) {
            return FAIL_CANCEL_DUPLICATE.getCode().equalsIgnoreCase(responseCode);
        }
    },
    FAIL_CANCEL("2008", "FAIL_CANCEL") {
        @Override
        public boolean isMatched(String responseCode) {
            return FAIL_CANCEL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    TMNID_NOT_FOUND("2009", "TMNID_NOT_FOUND") {
        @Override
        public boolean isMatched(String responseCode) {
            return TMNID_NOT_FOUND.getCode().equalsIgnoreCase(responseCode);
        }
    },
    CHANNEL_TRANSACTION_ID_DUPLICATE("2010", "CHANNEL_TRANSACTION_ID_DUPLICATE") {
        @Override
        public boolean isMatched(String responseCode) {
            return CHANNEL_TRANSACTION_ID_DUPLICATE.getCode().equalsIgnoreCase(responseCode);
        }
    },
    DATA_EXISTING("2011", "DATA_EXISTING") {
        @Override
        public boolean isMatched(String responseCode) {
            return DATA_EXISTING.getCode().equalsIgnoreCase(responseCode);
        }
    },
    TRANSACTION_IN_PROGRESS("2012", "TRANSACTION_IN_PROGRESS") {
        @Override
        public boolean isMatched(String responseCode) {
            return TRANSACTION_IN_PROGRESS.getCode().equalsIgnoreCase(responseCode);
        }
    },
    CONNECTION_ERROR("3001", "CONNECTION_ERROR") {
        @Override
        public boolean isMatched(String responseCode) {
            return CONNECTION_ERROR.getCode().equalsIgnoreCase(responseCode);
        }
    },
    CONNECTION_TIMED_OUT("3002", "CONNECTION_TIMED_OUT") {
        @Override
        public boolean isMatched(String responseCode) {
            return CONNECTION_TIMED_OUT.getCode().equalsIgnoreCase(responseCode);
        }
    },
    BILL_PAY_ENQUIRY_FAIL("7000", "BILL_PAY_ENQUIRY_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return BILL_PAY_ENQUIRY_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    BILL_PAY_VERIFY_FAIL("7001", "BILL_PAY_VERIFY_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return BILL_PAY_VERIFY_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    BILL_PAY_CONFIRM_FAIL("7002", "BILL_PAY_CONFIRM_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return BILL_PAY_CONFIRM_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    INSUFFICIENT_BALANCE_FAIL("7003", "INSUFFICIENT_BALANCE_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return INSUFFICIENT_BALANCE_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    DEDUCT_FAIL("7004", "DEDUCT_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return DEDUCT_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    GET_BALANCE_FAIL("7005", "GET_BALANCE_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return GET_BALANCE_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    BANK_CASH_IN_FAIL("8001", "BANK_CASH_IN_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return BANK_CASH_IN_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    BANK_CASH_IN_VERIFY_FAIL("8002", "BANK_CASH_IN_VERIFY_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return BANK_CASH_IN_VERIFY_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    VALIDATION_FAIL("4001", "VALIDATION_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return VALIDATION_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    CHANGE_PASSWORD_FAIL("5001", "CHANGE_PASSWORD_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return CHANGE_PASSWORD_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    DATABASE_ERROR("5002", "DATABASE_ERROR") {
        @Override
        public boolean isMatched(String responseCode) {
            return DATABASE_ERROR.getCode().equalsIgnoreCase(responseCode);
        }
    },
    GENERATE_TRANS_FAIL("3022", "GENERATE_TRANS_FAIL") {
        @Override
        public boolean isMatched(String responseCode) {
            return GENERATE_TRANS_FAIL.getCode().equalsIgnoreCase(responseCode);
        }
    },
    SYSTEM_ERROR("9000", "SYSTEM_ERROR") {
        @Override
        public boolean isMatched(String responseCode) {
            return SYSTEM_ERROR.getCode().equalsIgnoreCase(responseCode);
        }
    },
    INVALID_PHONE_NO("2063", "INVALID_PHONE_NO") {
        @Override
        public boolean isMatched(String responseCode) {
            return INVALID_PHONE_NO.getCode().equalsIgnoreCase(responseCode);
        }
    };

    private String responseCode;
    private String responseMessage;

    ResponseStatus(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public String getCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public abstract boolean isMatched(String responseCode);

    public static Stream<ResponseStatus> stream() {
        return Stream.of(ResponseStatus.values());
    }
}
