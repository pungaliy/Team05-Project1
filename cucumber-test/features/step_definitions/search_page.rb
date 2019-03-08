Then(/^I should see two text boxes$/) do
  expect(page).to have_field 'num' and expect(page).to have_field 'query'
end

Then(/^the text box should have the prompt value "([^"]*)"$/) do |arg1|
  p = find('input#query')['placeholder']
  expect(p).to eq('Enter Food')
end

Then(/^the text box should have a default value of (\d+)$/) do |arg1|
  expect(page).to have_field('num', with: arg1)
end

When(/^I enter (\d+) into the number box$/) do |arg1|
  page.fill_in 'num', with: arg1
end

Then(/^I should see no change$/) do
  page.should have_title("Search")  
end

When(/^I enter \-(\d+) into the number box$/) do |arg1|
  page.fill_in 'num', with: ('-' + arg1.to_s)
end

When(/^I enter "([^"]*)" into the \b(?:search|text)\b box$/) do |arg1|
  page.fill_in('query', with: arg1)
end

Then(/^I should see a button labeled "([^"]*)"$/) do |arg1|
  expect(page).to have_content(arg1)
end

Then(/^the color of the "([^"]*)" button should not be black$/) do |arg1|
  color = find('button').native.css_value('color')
  expect(color).not_to eq('rgba(0, 0, 0, 0)')
end

Given(/^the search box is empty$/) do
  page.fill_in('query', with: '')
end

Given(/^the search box has value "([^"]*)"$/) do |arg1|
  page.fill_in('query', with: arg1)
end






