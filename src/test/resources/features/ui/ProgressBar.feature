@regression @ui @progressBar
Feature: Progress Bar

  Background:
    Given the user is in UITAP Home
      And the user opens "Progress Bar" page

    Scenario Outline: A user stop the top bar in different percentages
      Given the user clicks on Start
        And the user waits for "<percentage>" percentage
      When the user clicks on Stop
      Then the user sees Result is equal to "<number>"
      Examples:
        | percentage | number |
        | 75         | 0      |
        | 50         | -25    |
        | 74         | -1     |
        | 76         | 1      |
        | 90         | 15     |