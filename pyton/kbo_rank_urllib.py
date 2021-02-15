import urllib.request as req
import re

#URL 
url = 'https://sports.news.naver.com/kbaseball/record/index.nhn?category=kbo'

#url 접속
html = req.urlopen(url)
#응답 결과를 문자열로 변경
html_code = str(html.read().decode('utf-8'))

tag_list = re.findall(r'(<span id=\"team_)(.+)(\/span)',html_code)

for tag in tag_list:
    #print(tag)
    print(tag[1].split('>')[1])

