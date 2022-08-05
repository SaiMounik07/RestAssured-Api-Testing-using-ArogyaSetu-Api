Feature: To Run Api Testing

  Scenario Outline: The user has to perform the api testing for apiSetu website
    Given User has to get The state details "<basePath for states>"
    When User has to get districts using state id "<basepath for districts>"
    Then User has to find districts using pin "<basePath for vaccine center>" and "<pincode>" and "<date>"
    And Verify Schema of response "<basePath for vaccine center>" and "<pincode>" and "<date>"
    Examples:
      |basePath for states|basepath for districts|basePath for vaccine center|pincode|date|
      |api/v2/admin/location/states|api/v2/admin/location/districts/|api/v2/appointment/sessions/public/findByPin|600001|31-03-2021|
      |api/v2/admin/location/states|api/v2/admin/location/districts/|api/v2/appointment/sessions/public/findByPin|621212|01-03-2021|