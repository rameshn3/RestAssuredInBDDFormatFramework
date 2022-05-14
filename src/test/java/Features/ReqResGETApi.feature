Feature: REQRES GET API Feature

  Scenario: ReqRes GET API to list all users
    Given provide valid endpoint to fetch all users
    When the request is send to the server
    Then validate the response statuscode 200

  Scenario Outline: Reqres GET API to list all users with scenario outline
    Given provide valid endpoint to fetch all users
    When the request is send to the server with page number as "<page>"
    Then validate the response of first user record having email as "<emailId>"
    And validate response statuscode <respStatusCode>

    Examples: 
      | page | emailId                  | respStatusCode |
      |    2 | michael.lawson@reqres.in |            200 |
      |    1 | george.bluth@reqres.in   |            200 |

  @smoke @regression
  Scenario: ReqRes GET Single user
    Given provide valid endpoint to fetch the single user
    When the request is send to the server to fetch single user
    Then validate the response statuscode 200
    And validate the response body fields
    |2|janet.weaver@reqres.in|Janet|Weaver|

  Scenario: ReRes GET SingleUser Not Found
    Given provide valid endpoint to fetch the single userNotFound
    When the request is send to the server to fetch single user not found
    Then validate the response statuscode
          | 404 |

      
      
      
      
      
      
      
      
      