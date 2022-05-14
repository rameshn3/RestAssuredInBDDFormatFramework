@deleteapi
Feature: REQRES DELETE API Feature
  Scenario: ReqRes DELETE API to delete the specific user
    Given provide valid endpoint to delete the user
    When the request is send to the server delete the user
    Then validate delete user response statuscode
      | 204 |
    

