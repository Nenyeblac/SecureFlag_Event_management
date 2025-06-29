package utilities;

import com.jayway.jsonpath.DocumentContext;

public class PayloadMaker {
    public void setPayloadForCreateBooking(DocumentContext requestBody, String eRef, String bType, String sWaitList){
        requestBody.set("eventReference", eRef);
        requestBody.set("bookingType", bType);
       requestBody.set("shouldWaitList", sWaitList);
    }
}
