Feature: I can find a city inside a state.

@List
Scenario Outline: Scenario outline name: As a Test Engineer, I want to validate that a exist is present inside the list
    Given I navigate to the list page   
    When I search <state> in the list
    Then I can find the <city> in the list

    Examples:
    |State     |city               |
    |Washington|Seattle, Washington|
    |Chicago   |Illinois, Chicago  |

    #Scenario Outline, permite correr un caso para cada ejemplo en la tabla. 
    

