package com.money.orchestrator.resource;


import com.amazonaws.util.Base64;

public class Base64DecodeEncodeUsingAmazonAwsLibrary {

    private static byte[] decodeBase64String(final String base64String) {
        return Base64.decode(base64String.getBytes());
    }

    private static byte[] encodeStringToBase64(final String someString) {
        return Base64.encode(someString.getBytes());
    }
}
