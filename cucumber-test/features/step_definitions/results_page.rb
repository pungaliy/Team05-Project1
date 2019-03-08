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
  expect(rl).to have_content('☆')

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
  expect(rl).to have_content('Address:')  
  expect(rl).to have_content('Distance:')
  expect(rl).to have_content('☆')
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

Then(/^the rows should be alternating$/) do
  rests = page.all('#restList > div')
  recs = page.all('#recList > div')
  for i in [0,2,4]
    expect(rests[i][:class]).to have_content "alt"
    expect(recs[i][:class]).to have_content ""
  end

  for i in [1,3]
    expect(rests[i][:class]).to have_content ""
    expect(recs[i][:class]).to have_content "alt"
  end
end

Then(/^the restaurants should be sorted by driving time$/) do
  rests = page.all('#restList > div')
  previous = 0
  for i in rests
    mins = /(\d+) min/.match(i['innerHTML'])[1].to_i
    expect(mins).to be >= previous
    previous = mins
  end

end

Given(/^I wait (\d+) seconds$/) do |arg1|
  sleep arg1.to_i
end

Then(/^the recipes should be sorted by prep time$/) do
  recs = page.all('#recList > div')
  previous = 0
  for i in recs
    mins = /Prep Time: (\d+) min/.match(i['innerHTML'])[1].to_i
    expect(mins).to be >= previous
    previous = mins
  end
end
