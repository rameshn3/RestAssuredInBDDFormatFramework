@putapi
Feature: REQRES PUT API Feature
  Scenario: ReqRes PUT API to update user
    Given provide valid endpoint to update user
    When the request is send to the server with requestbody to update
    Then validate update user response statuscode
      | 200 |
    And validate the update responsebody fields

