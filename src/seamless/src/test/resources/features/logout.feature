@Logout
Feature: Logout function

  Scenario Outline: User can log out and ends up in login page

    Given the user logged in "<username>" and "<password>"
    When the user click on login button
    Then the user should see the title "Files - Seamlessly -QA"
    And  the user click on the user's avatar in the upper right corner of the page
    Then the user should see the username in dropdown "<username>"
    When the user click on the logout in dropdown
    Then the user should see the title "Seamlessly -QA"

    Examples:
      | username   | password    |
      | Employee51 | Employee123 |


  Scenario Outline: User can not go to home page again by clicking step back button after successfully logged out

    Given the user logged in "<username>" and "<password>"
    When the user click on login button
    Then the user should see the title "Files - Seamlessly -QA"
    And  the user click on the user's avatar in the upper right corner of the page
    Then the user should see the username in dropdown "<username>"
    When the user click on the logout in dropdown
    Then the user should see the title "Seamlessly -QA"
    When the user click on go back button on the browser
    Then the user can NOT go back to homepage and not see the "Files - Seamlessly -QA"

    Examples:
      | username   | password    |
      | Employee51 | Employee123 |

