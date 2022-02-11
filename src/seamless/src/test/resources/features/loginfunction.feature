
Feature:Acceptance Criteria:

  1-User can login with valid credentials
  2-User can not login with any invalid credentials
  -"Wrong username or password." should be displayed for invalid credentials
  -"Please fill out this field" message should be displayed if the password or username is empty
  3-User can see the password in a form of dots by default
  4-User can see the password explicitly if needed
  5-User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
  6-User can see valid placeholders on Username and Password fields

  Scenario: User can login with valid credentials
    Given the user is on the login page
    When the user logins with valid credentials
    Then the user should be able to login succesfully

  Scenario Outline: try to login invalid credentials
    Given the user is on the login page
    When the user logins with "<userName>" and "<password>"
    Then  the user should not be able to login

    Examples:
      |userName    | password    |
      |Employee131 |             |
      |Employee131 | abc123      |
      | abc12      | Employee123 |
      |            |             |
      |  abc123    |   abc123    |
      |            |Employee123  |

  Scenario: Login then logout and navigate back
    Given the user is on the login page
    When the user logins with valid credentials
    And the user log out and navigate back
    Then the user should not be able to login


  Scenario: User should see password in a form of dots by default
    Given the user enters in  password
    Then the password appears in a form of dots by default

  Scenario: User should see password explicitly if needed
    Given the user is on the login page
    And  the user enters in  password
    When the user click on eye button in password input box
    Then the password appears explicitly on password input box

  Scenario: User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
    Given the user is on the login page
    Then the user should see forget password link
    When the user clicks Forget password link
    Then User should see reset password button
  @wip
  Scenario: User can see valid placeholders on Username and Password fields
    Given the user is on the login page
    Then the user should see the valid placeholders on username and password fields