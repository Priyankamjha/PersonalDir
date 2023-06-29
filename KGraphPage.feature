@GraphTest
Feature: Graph page validation

  Background: User  Login with  valid "username" and "password"
    When The user clicks the Get Started button
    And user clicks on SignIn button he is directed to login page
    When User enters valid username "Team" and password "Ninjas123"
    And User clicks on login button
    Then It should navigate to the home page with a message " You are logged in  "


  @Test_graph_02
  Scenario Outline: User should be able to navigate to all options in graph page
    Given The user is on the Graph page after logged in
    When User clicks "<options>" link for graph
    Then User directed to "<options>" page for graph

    Examples: 
      | options               |
      | Graph                 |
      | Graph Representations |

  @Test_graph_03
  Scenario Outline: User should be able to test run valid code in tryEditor
    Given The user is in a "<options>" page for graph having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor for graph from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button for graph
    Then The user should be presented with Run result for graph

    Examples: 
      | options               | Sheetname       | RowNumber |
      | Graph                 | ValidPythonCode |         0 |
      | Graph Representations | ValidPythonCode |         0 |
      
@Test_graph_04
  Scenario Outline: User should be able to test run invalid code in tryEditor 
    Given The user is in a "<options>" page for graph having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor  for graph from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button for graph
    Then The user should be presented with error message for graph

    Examples: 
      Examples:

      | options               | Sheetname         | RowNumber |
      | Graph                 | InvalidPythonCode |         0 |
      | Graph Representations | InvalidPythonCode |         0 |

@Test_graph_05
  Scenario: User should be able to navigate to Graph Representations page and click on Practice Questions
    Given The user is on Editor page and navigates to Graph Representations page
    When the user will click on Practice Questions for graph
    Then The user will be directed to Practice page for graph
