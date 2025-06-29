@TestToRun
Feature: SecureFlag Events

  @TestToRun
  Scenario: Get the list of events
    Given local host is up and running
    When I send GET request to get the list of events
    Then "SUCCESS" status and statusCode 200 are returned

  @TestToRun
  Scenario Outline: Create events
    Given local host is up and running
    When I send a post request to create an event with the following: "<eventReference>", "<bookingType>","<shouldWaitList>"
    Then status "<status>", "<bookingType>" and statusCode 200 are returned
    Examples:
      | eventReference                       | bookingType | shouldWaitList | status      |
      | 3fa85f64-5717-4562-b3fc-2c963f66afa6 | REGULAR     | true           | SUCCESSFUL  |
      | 1c6e8fbf-9c0a-4d87-9a2c-bf68cc1e1f4b | REGULAR     | true           | WAIT_LISTED |
      | c0a8015a-000f-11ee-be56-0242ac120002 | REGULAR     | true           | WAIT_LISTED |
      | 123e4567-e89b-12d3-a456-426614174000 | REGULAR     | true           | SUCCESSFUL  |
      | 550e8400-e29b-41d4-a716-446655440000 | REGULAR     | true           | WAIT_LISTED |
      | f47ac10b-58cc-4372-a567-0e02b2c3d479 | REGULAR     | true           | WAIT_LISTED |

  @TestToRun
  Scenario Outline: Cancel a booking
    Given local host is up and running
    When I cancel the booking with reference "<bookingRef>"
    Then the cancellation should be successful with  statusCode 200
    Examples:
      | bookingRef                       |
      | 0f2e922ac9864e2381000f513fa5d84a |