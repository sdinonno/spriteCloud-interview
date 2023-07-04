@regression @ui @sampleApp
Feature: Sample App

  Background:
    Given the user is in UITAP Home
      And the user opens "Sample App" page

    Scenario: A user logs in with valid credentials
      Given the user has valid credentials
      When the user performs a log in with their credentials
      Then the user sees a successfully login message

    Scenario: A user tries to log in with invalid credentials
      Given the user has invalid credentials
      When the user performs a log in with their credentials
      Then the user sees a login error message

    Scenario: A user logs out after to log in with valid credentials
      Given the user has valid credentials
        And the user performs a log in with their credentials
      When the user logs out
      Then the user sees a successfully log out message
        And the user sees Log In button enabled

