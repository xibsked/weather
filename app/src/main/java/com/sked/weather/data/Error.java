package com.sked.weather.data;

import com.sked.weather.BuildConfig;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * BigBee, All rights Reserved
 * Created by Sanjeet on 11-Dec-16.
 */

public class Error {
    private String message;
    private Throwable throwable;
    private static String NETWORK_ERROR = "Unable to connect to the server." +
            " Make sure that Wi-Fi or cellular mobile data is turned on, then try again";
    private Code code;

    private Error(Builder builder) {
        throwable = builder.throwable;
    }

    public String message() {
        if (throwable != null) {
            if (throwable instanceof UnknownHostException || throwable instanceof SocketTimeoutException)
                return NETWORK_ERROR;
            else {
                if (BuildConfig.DEBUG)
                    return throwable.getMessage();
            }
        }

        return message;
    }

    public Code code() {
        return this.code;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String message;
        private Throwable throwable;

        private Builder() {
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Error build() {
            return new Error(this);
        }

        public Builder throwable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }
    }

    public enum Code {
        UNKNOWN_HOST, INVALID_CREDENTIAL
    }
}
