Feature: This feature is to validate shopping functionality

  @etsy
  Scenario: Shop for an item on etsy.com
    Given The title of the page is "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone"
    Then I search for "phone case"
    And I verify the search result contains "phone case"
    Then I choose Free Shipping
    Then I verify the default price is Any Price
    Then I verify default selected country is "United States"
    #And I select item number 2 from the search result
   And I select random item from the search result
    Then I select option number 1 from existing dropdown menu(s)
