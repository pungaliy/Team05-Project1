Then(/^I should see the title of the Recipe$/) do
	expect(page).to have_css('div.listTitle')
end

Then(/^I should see an image$/) do
	expect(page).to have_css('img')
end

Then(/^I should see the prep time for the dish$/) do
	expect(page).to have_content('Prep Time')
end

Then(/^I should see the cook time for the dish$/) do
	expect(page).to have_content('Cook Time')
end

Then(/^I should see a list of ingredients for the dish$/) do
	expect(page).to have_content('Ingredients')
end

Then(/^I should see a list of instructions for the dish$/) do
	expect(page).to have_content('Instructions')
end

Then(/^I should see the name of the Restaurant$/) do
	expect(page).to have_css('div.listTitle')
end

Then(/^I should see an address$/) do
	expect(page).to have_css('a#address', :visible => false)
end

Then(/^I should see a phone number$/) do
	expect(page).to have_css('div#phone', :visible => false)
end

Then(/^I should see a website link$/) do
	expect(page).to have_css('a#link', :visible => false)
end

When(/^I click the website$/) do
	page.find('a#link', visible: :all).click
end

Then(/^I should be redirected to that website$/) do
	expect(page.current_path).not_to include "localhost"
end

When(/^I click the address$/) do
	page.find('a#address', visible: :all).click
end

Then(/^I should be redirected to Google Maps$/) do
	expect(page).to have_title "Google Maps"
end

Then(/^the starting address should be Tommy Trojan$/) do
	w = page.title.to_s
	val = /Tommy Trojan/.match(w)
	expect(val).not_to eq(nil)
end

Then(/^the desination address should be filled in$/) do
	w = page.title.to_s
	val = /to (.+)/.match(w)
	expect(val).not_to eq(nil)
end

Then(/^I should see a Printable View button$/) do
	expect(page).to have_button('Printable View')
end

Then(/^I should see a dropdown menu$/) do
	expect(page).to have_select('list')
end

Then(/^the dropdown value should be empty$/) do
	expect(page).to have_select('list', selected: "")
end

