Feature: Checkout
  Scenario: Checkout a banana
    Given the price of a "banana" is 40c
    When I checkout 2 "banana"
    Then the total price should be 80c

  Scenario: Checkout a mango
    Given the price of a "mango" is 80c
    When I checkout 2 "mango"
    Then the total price should be 160c

  Scenario: Checkout a bill
    Given the price of a "banana" is 40c
    When I checkout 2 "banana"
    Given the price of a "mango" is 80c
    When I checkout 2 "mango"
    Then the total price should be 240c

  Scenario Outline: Checkout a bananas
    Given the price of a "banana" is 40c
    When I checkout <count> "banana"
    Then the total price should be <total>c
    Examples:
    |count|total|
    | 1   | 40  |
    | 2   | 80  |
    | 4   | 160 |
    | 8   | 320 |


  Scenario Outline: Checkout a fruitsBill
    Given the price of a "banana" is 40c
    When I checkout <bananaCount> "banana"
    Then the total price of "banana" should be <bananaPriceTotal>c
    Given the price of a "mango" is 80c
    When I checkout <mangoCount> "mango"
    Then the total price of "mango" should be <mangoPriceTotal>c
    Examples:
      |bananaCount|bananaPriceTotal|mangoCount|mangoPriceTotal|
      | 1         | 40             | 1        |  80           |
      | 2         | 80             | 2        | 160           |
      | 4         | 160            | 4        | 320           |
      | 8         | 320            | 8        | 640           |


  Scenario Outline: Checkout a fruitsBills
    Given the price of a "banana" is 40c
    When I checkout <bananaCount> "banana"
    Given the price of a "mango" is 80c
    When I checkout <mangoCount> "mango"
    Then the total price should be <totalPrice>c
    Examples:
      |bananaCount|mangoCount|totalPrice|
      | 1         | 1        | 120      |
      | 2         | 2        | 240      |
      | 4         | 4        | 480      |
      | 8         | 8        | 960      |