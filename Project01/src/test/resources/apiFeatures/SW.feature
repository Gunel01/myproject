Feature:
  Scenario: User should be able to return a list of all the Star Wars characters

  Scenario
  @SW01
    Given user submits GET request for a list of all the Star Wars characters and receive response
    And user retrieves Star Wars character IDs from response and add them to a List
    Then user validates status code is 200
    And user validates if value of "characters" in response are same as required.


  Scenario Outline
    @SW02
    Given user submits GET request for the details of a specified Star Wars Character and receive response
    And API should be able to return the details of a specified Star Wars Character
    And User validates if response status code is 200
    Then User validates <detail>, <value> in response

    Examples:
      | detail    | value          |
      | name      | Luke Skywalker |
      | height    | 172            |
      | mass      | 77             |
      |hair_color |blond           |
      |eye_color  |blue            |
      |skin_color |fair            |
      |birth      |19BBY           |
      |gender     |male            |



  Scenario Outline
    @SW03

    Given I submit GET request and receive response
    And I should be able to search for the details of a character or planet
    Then I validate status code is 200
    And I Validate if value of <details> in response are same as required.
    Examples:
      |





