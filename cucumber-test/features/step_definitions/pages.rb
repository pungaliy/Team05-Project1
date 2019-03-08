def visitor(page)
	visit page
end

def go_to_page(page)
	dictionary = { 
		"Search" => "", 
		"Results" => "ReturnResults?query=hamburger&options=5", 
		"Restaurant" => "Restaurant.jsp?id=DXFhzx94myitMxmBhsdz8A",
		"Recipe" => "Recipe.jsp?id=2",
		"Favorites" => "ToList?list=favorite",
		"Favorite" => "ToList?list=favorite",
		"Do Not Show" => "ToList?list=not",
		"To Explore" => "ToList?list=explore"
	}

	if (page != "Search" and page != "Results")
		visit "localhost:8080/ReturnResults?query=hamburger&options=5"
	end

	return dictionary[page]
end

def full_path(page) 
	return "localhost:8080/" + page
end

Given (/^I am on the (.+) [P|p]age$/) do |arg1|
	visitor full_path(go_to_page arg1)
end

Then(/^I should be on the (.+) [P|p]age$/) do |arg1|
	expect(page.title).to have_content(arg1)
end

Then(/^I should get be redirected to the (.+) [P|p]age$/) do |arg1|
    expect(page.title).to have_content(arg1)
end

When(/^I visit (.*)$/) do |arg1|
	visitor (full_path arg1)
end

Then(/^the background color is Whitesmoke$/) do
  color = find('html').native.css_value('background-color')
  expect(color).to eq("rgba(245, 245, 245, 1)")
end

When(/^I \b(?:click|press)\b the "([^"]*)" [B|b]utton$/) do |arg1|
  click_button(arg1)
end

