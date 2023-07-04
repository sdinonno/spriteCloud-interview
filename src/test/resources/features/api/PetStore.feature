@regression @api @petstore
Feature: Petstore - Valid API scenarios

  Background:
    Given the user has a valid API Key for the "https://petstore.swagger.io/v2" URI

    Scenario: An user want to add a new pet to the store
      When the user performs a "POST" with a "pet" payload to the "/pet" endpoint
      Then the user receives a HTTP Code Status "200"

    Scenario: An user want to create a new user
      Given the user has a body with the following attributes
        | attribute  |
        | id         |
        | username   |
        | firstName  |
        | lastName   |
        | email      |
        | password   |
        | phone      |
        | userStatus |
      When the user performs a POST to the "/user" endpoint
      Then the user receives a HTTP Code Status "200"

