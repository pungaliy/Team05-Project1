Given(/^I have added the "([^"]*)" to the "([^"]*)" page$/) do |arg1, arg2|
  visit full_path(go_to_page "Results")
  click_on arg1
  select arg2 + " List", :from => 'list'
  click_button "Add to List"
end

Then(/^"([^"]*)" should be on the "([^"]*)" page$/) do |arg1, arg2|
  visit full_path (go_to_page arg2)
  expect(page.title).to have_content(arg2)
  expect(page).to have_content(arg1)
end

Then(/^"([^"]*)" should not be there$/) do |arg1|
  expect(page).not_to have_content(arg1)
end

Then(/^"([^"]*)" should be the first recipe$/) do |arg1|
  first_rec = find_by_id("recList").first("div")
  expect(first_rec).to have_content(arg1)
end

When(/^I choose the "([^"]*)" list$/) do |arg1|
  click_on arg1
end
