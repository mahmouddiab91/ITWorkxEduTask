Feature:
  Create new course on winjigo website

  Scenario Outline: Login on website using <email>, and <password>, then add new course on website
    Given open website using chrome browser
    And fill home email field <email>
    And fill home password field <password>
    And i click on login button
    When select courses from side menu
    And select add new course
    And fill course basic info using <courseName>
    And save new course
    Then back to courses list page
    And assert the course
    And Close Chrome Browser

    Examples:
      | email | password | courseName |
      | "testregister@aaa.com" | "Wakram_123" | "TestMD" |
