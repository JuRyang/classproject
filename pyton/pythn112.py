from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import bs4

driver = webdriver.Chrome(r'C:\Users\Yang\Desktop\chromedriver.exe')
driver.get("https://www.istarbucks.co.kr/store/store_map.do")

time.sleep(2)
driver.find_element_by_class_name('loca_search').click()

time.sleep(2)
driver.find_element_by_xpath('//*[@id="container"]/div/form/fieldset/div/section/article[1]/article/article[2]/div[1]/div[2]/ul/li[1]/a').click()

time.sleep(2)
driver.find_element_by_xpath('//*[@id="mCSB_2_container"]/ul/li[1]/a').click()

time.sleep(2)
startbuks = bs4.BeautifulSoup(driver.page_source, 'lxml')

starbucks_list = startbuks.find_all('p', class_='result_details')
starbucks_address_list = []

for starbuks in starbucks_list:
    starbucks_address_list.append(starbuks.text)

starbucks_address_list