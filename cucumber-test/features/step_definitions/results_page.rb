Then(/^the title of the Results page should say "([^"]*)"$/) do |arg1|
  expect(page).to have_content(arg1)
end

Then(/^I should see a collage of images$/) do
	page.find('div#collage.container', :visible => false)
end


Then(/^the width the collage must be between (\d+) and (\d+) percent of viewport width$/) do |arg1, arg2|
  w = page.find('div#collage.container', :visible => false)[:style]
  val = /width: (\d+)vw/.match(w)[1]
  expect(val).to be_between(arg1, arg2)
end

Then(/^the height of the collage must be between (\d+) and (\d+) percent of viewport height$/) do |arg1, arg2|
  w = page.find('div#collage.container', :visible => false)[:style]
  val = /(\d+)vh/.match(w)[1]
  expect(val).to be_between(arg1, arg2)
end

Then(/^there should be (\d+) photos in the collage$/) do |arg1|
  expect(page).to have_css('img', count: arg1)
end

Then(/^I should see the "([^"]*)" title$/) do |arg1|
	expect(page).to have_content(arg1)
end

Then(/^I should see the title "([^"]*)"$/) do |arg1|
	expect(page).to have_content(arg1)
end

Then(/^a recipe should have a Name, Stars, Prep time, Cook time$/) do
  rl = page.find('div#recList')
  expect(rl).to have_content('Prep Time:')  
  expect(rl).to have_content('Cook Time:')

end

When(/^I click on a Recipe$/) do
  click_on "Feta-Stuffed Hamburgers"
end

Then(/^I should be redirected to that Recipe's page$/) do
  expect(page).to have_title "Recipe"
  expect(page).to have_content "Feta-Stuffed Hamburgers"
end

Then(/^a restaurant should have a Name, Address, Stars, Minutes, and Price Range$/) do
  rl = page.find('div#restList')
  expect(rl).to have_content('$')
  expect(rl).to have_content('Distance:')  
end

When(/^I click on a Restaurant$/) do
  click_on "Traditions"
end

Then(/^I should be redirected to that Restaurant's page$/) do
  expect(page).to have_title "Restaurant"
  expect(page).to have_content "Traditions"
end

When(/^I click on "(.+)"$/) do |arg1|
  click_on arg1
end

Then(/^I should be redirected to that item's page$/) do
  expect(page).to have_title("Restaurant")
end

When(/^I select "([^"]*)" from the dropdown$/) do |arg1|
  select arg1+" List", :from => 'list'
end

Then(/^I should no longer see the item$/) do

end
