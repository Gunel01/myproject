Feature:
  @SW01 @positive
  Scenario: User should be able to return a list of all the Star Wars characters
    Given User submits GET request for a list of all the Star Wars characters and receive response 
    And   User should be able to return a list of all the Star Wars characters
    Then  user validates status code is 200
    And   user validates if the count of the characters in response is the same as required
    
    @SW02 @negative
      Scenario: Negative scenario for requesting list of characters
    Given User submits GET request for a list of all the Star Wars characters with wrong parameter 
    And   User validates status code is 404
    And   User validates error message 
  
     @SW03  @positive
    Scenario Outline: Get the details of a specified Star Wars Character and Verify status code and response are same as expected
    Given User submits GET request for the details of a specified Star Wars Character
    And   API should be able to return the details of a specified Star Wars Character
    And   User validates if status code is 200
    Then  User validates"detail", "value" in response

    Examples:
      |detail     |value           |
      |name       |Luke Skywalker  |
      |height     |172             |
      |mass       |77              |
      |hair_color |blond           |
      |eye_color  |blue            |
      |skin_color |fair            |
      |birth      |19BBY           |
      |gender     |male            |
      
      
      @SW04  @negative
   Scenario Outline: Get the details of a specified Star Wars Character and Verify status code and response are same as expected
    Given User submits GET request by passing "value" of "detail" and receive response
    Then  User validate status code is 200
    And   User Validate if "value" of "detail" in response is same as required.
    
    Examples:
      |detail     |value           |
      |name       |Luke Skywalker  |
      |height     |172             |
      |mass       |77              |
      |hair_color |blond           |
      |eye_color  |blue            |
      |skin_color |fair            |
      |birth      |19BBY           |
      |gender     |male            |

    @SW05 @positive 
    Scenario Outline: submit get request with wrong parameter
    Given User submits GET request for the details of a specified Star Wars Character
    And   API should be able to return the details of a specified Star Wars Character
    And   User validates if status code is 200
    Then  User validates <detail>, <value> in response

    Examples:
      |detail     |value           |
      |name       |Luke Skywalker  |
      |height     |172             |
      |mass       |77              |
      |hair_color |blond           |
      |eye_color  |blue            |
      |skin_color |fair            |
      |birth      |19BBY           |
      |gender     |male            |

     @SW04
  Scenario Outline: Get the details of a specified Star Wars haracter and Verify status code and response are same as expected
    Given User submits GET request by passing "value" of "parameter" of character and receive response
    Then  User validate status code is 200
    And   User Validate if "value" of "parameter" in response is same as required.
    
     Examples:
      |parameter       |value         |
      |name            |Tatooine      |
      |rotation_period |23            |
      |orbital_period  |304           |
      |diameter        |10465         |
      |climate         |arid          |
      
      
   @SW05
Scenario Outline: Submit get request by passing wrong parameters of character
    Given user submits GET request by wrong "value" of "parameter" of character and receive response
    Then  User validates if the response status code is 404
    And   User validates error message .
    
     Examples:
      |parameter       |value         |
      |name            |WRONG         |
      |rotation_period |123           |
      |orbital_period  |456           |
      |diameter        |00101         |
      |climate         |wrong         |
      


