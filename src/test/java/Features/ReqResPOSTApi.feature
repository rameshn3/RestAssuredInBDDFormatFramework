Feature: REQRES POST API Feature

  Scenario: ReqRes POST API to create user
    Given provide valid endpoint to create user
    When the request is send to the server with requestbody
    Then validate create user response statuscode
      | 201 |
    And validate the responsebody fields

  Scenario Outline: ReqRes POST API to create users
    Given provide valid endpoint to create users
    When the request is send to the server with requestbody as "<name>" and "<job>"
    Then validate create user response statuscode
      | 201 |
    And validate the responsebody fields

    Examples: 
      | name      | job                  |
      | Morpheus  | leader               |
      | Ramesh Ch | Automation Test lead |
