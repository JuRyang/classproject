import sqlite3

#DB 연결
con = sqlite3.connect('sample')
cur = con.cursor()

user_id = input('아이디를 입력해주세요.>>>') 
user_name = input('이름을 입력해주세요.>>>')
user_email =input('이메일을 입력해주세요.>>>')
user_birth_year=int(input('생년월일을 입력해주세요.>>>'))



#SQL
sql_insert = 'insert into usertable values (\'{}\',\'{}\',\'{}\',{})'.format(user_id,user_name,user_email,user_birth_year)
cur.execute(sql_insert)

con.commit()
con.close()

