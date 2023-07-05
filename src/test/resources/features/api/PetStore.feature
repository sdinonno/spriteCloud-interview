@regression @api @petstore
Feature: Petstore - Valid API scenarios

  Background:
    Given the user has a valid API Key for the "https://petstore.swagger.io/v2" URI

    Scenario: An user tries to add a new pet to the store
      When the user performs a POST with a "pet" payload to the "/pet" endpoint
      Then the user receives a HTTP Code Status 200

    Scenario: An user tries to search a pet by ID
      When the user performs a POST with a "pet" payload to the "/pet" endpoint
      Then the user receives a HTTP Code Status 200

    Scenario: An user tries to create a new user
      Given the user has information about an User
      When the user performs a POST to the "/user" endpoint
      Then the user receives a HTTP Code Status 200

    Scenario: An administrator tries to delete a non-existent user
      When the user performs a DELETE to "/user" endpoint with value "ssdinonno"
      Then the user receives a HTTP Code Status 404