package step_definitions;

import com.jayway.jsonpath.DocumentContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.PayloadMaker;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EventManagementStepDefs extends BaseSteps{
    Response responseForGetEvents, responseForCreateBooking, responseForCancelBooking;

    @Given("local host is up and running")
    public void local_host_is_up_and_running() {
        //setEndpointPath(baseUrl);
    }

    @When("I send GET request to get the list of events")
    public void i_send_get_request_to_get_the_list_of_events() {
        setEndpointPath(getUrl);
        setHeadersWithContentType();
        responseForGetEvents = getCall();
    }

    @Then("{string} status and statusCode {int} are returned")
    public void statusAndStatusCodeAreReturned(String status, Integer statusCode) {
        assertThat(responseForGetEvents.statusCode(), equalTo(statusCode));
        assertThat(responseForGetEvents.body().jsonPath().get("status"), equalTo(status));
    }


    @When("I send a post request to create an event with the following: {string}, {string},{string}")
    public void i_send_a_post_request_to_create_an_event_with_the_following(String eventRef, String bkType, String shldWaitList) {
        setHeadersWithUserId();
        setEndpointPath(postUrl);
        PayloadMaker payload = new PayloadMaker();
        DocumentContext reqBody = loadJsonTemplate(createBookingPayloadPath);
        payload.setPayloadForCreateBooking(reqBody, eventRef, bkType, shldWaitList);

        responseForCreateBooking = getPostCall();
    }

    @Then("status {string}, {string} and statusCode {int} are returned")
    public void statusAndStatusCodeAreReturned(String status, String bkType, int statusCode) {
        assertThat(responseForCreateBooking.statusCode(), equalTo(statusCode));
        assertThat(responseForCreateBooking.body().jsonPath().get("status"), equalTo(status));
        assertThat(responseForCreateBooking.body().jsonPath().get("type"), equalTo(bkType));
    }

    @When("I cancel the booking with reference {string}")
    public void i_cancel_the_booking_with_reference(String bookingref) {
        setHeadersWithUserId();
        setEndpointPath(baseUrl+"/"+bookingref+"/cancel");
        responseForCancelBooking = getPutCall();
    }

    @Then("the cancellation should be successful with  statusCode {int}")
    public void theCancellationShouldBeSuccessfulWithStatusCode(int statusCode) {
        assertThat(responseForCancelBooking.statusCode(), equalTo(statusCode));
    }
}
