import pymysql
import csv

conn = pymysql.connect(host='127.0.0.1', user='withearth', password='aia', db='withearth',charset='utf8')
curs = conn.cursor()
conn.commit()   



f = open('starbucks.csv','r' ,encoding='cp949')
rd= csv.reader(f)

for row in rd:
   cafe_idx=(row[0])
   cafe_name=(row[1])
   location=(row[2])
   qrcode=(row[3])
   cafe_lat=(row[4])
   cafe_lon=(row[5])

 
    #print(line)

sql ="insert into withearth.cafe (cafe_idx,cafe_name,location,qrcode,cafe_lat,cafe_lon) values (%s,%s,%s,%s,%s,%s)"

curs.execute(sql,(cafe_idx,cafe_name,location,qrcode,cafe_lat,cafe_lon))


conn.commit()

conn.close()
f.close()

