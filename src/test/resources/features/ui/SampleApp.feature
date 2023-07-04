@regression @ui
Feature: Sample App

  Background:
    Given the user is in UITAP Home
      And the user opens "Sample App" page

    Scenario:
      Given the user has valid credentials
      When the user performs a log in with their credentials
        Then the user sees a successfully login message

    Scenario:
      Given the user has invalid credentials
      When the user performs a log in with their credentials
      Then the user sees a login error message

    Scenario:
      Given the user has valid credentials
        And the user performs a log in with their credentials
      When the user logs out
      Then the user sees a successfully log out message
        And the user sees Log In button enabled

