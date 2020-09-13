@Etsy_Explore
  Feature: Exploring etsy.com
    Scenario: making sure we are on home page
      When i am on home page i have to verify tittle of the page
      Then i go for search and send send iphone case
      And verify All categories contains search item
      And verify  default value is Any price
      Then select Free shipping
      And verify ship to default value is "United States"
      And select diffrent "countnry"
      And Select first item from search result
#      And Select Size is "iPhone X" and Customize is "Black without name"
#      Then add item to the cart
      Then Verify Your item is free with shown text "Hooray!" contains whole text