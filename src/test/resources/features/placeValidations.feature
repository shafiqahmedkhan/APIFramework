Feature: Validating Place API's
  Scenario: Verify if Place is being successfully added AddPlaceAPI
    Given Add Place Payload
    When user calls "AddPlaceAPI" with Post http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "response" in response body is "APP"
