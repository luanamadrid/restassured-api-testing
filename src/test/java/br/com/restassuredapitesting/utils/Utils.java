package br.com.restassuredapitesting.utils;

import org.json.simple.JSONObject;

public class Utils {

    public static JSONObject validPayloadBooking() {
        JSONObject payload = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        payload.put("firstname","Ronaldo1");
        payload.put("lastname","Fenomeno2");
        payload.put("totalprice",111);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingdates);
        payload.put("additionalneeds","Breakfast");

        return payload;

    }


    public static JSONObject invalidPayloadBooking() {
        JSONObject invalidPayload = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        invalidPayload.put("firstname1","Ronaldo1");
        invalidPayload.put("lastname","Fenomeno2");
        invalidPayload.put("totalprice",111);
        invalidPayload.put("depositpaid",true);
        invalidPayload.put("bookingdates",bookingdates);
        invalidPayload.put("additionalneeds","Breakfast");

        return invalidPayload;

    }

        public static JSONObject moreParametersPayloadBooking() {
        JSONObject moreParameters = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

            moreParameters.put("firstname","Ronaldo1");
            moreParameters.put("lastname","Fenomeno2");
            moreParameters.put("totalprice",111);
            moreParameters.put("depositpaid",true);
            moreParameters.put("bookingdates",bookingdates);
            moreParameters.put("additionalneeds","Breakfast");

            moreParameters.put("teste","teste");
            moreParameters.put("teste2","teste2");

        return moreParameters;

    }

    public static  String getContractsBasePath(String pack, String contract) {
        return System.getProperty("user.dir")
                + "/src/test/java/br/com/restassuredapitesting/tests/"
                + pack
                + "/contracts/"
                + contract
                + ".json";
    }

}
