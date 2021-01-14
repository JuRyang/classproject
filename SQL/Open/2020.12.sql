-- 입력 sql
INSERT INTO `opn`.`guestbook_message`(guest_name,password,message ) VALUES
('test','1234','반갑습니다');

-- INSERT INTO guestbook_message (guest_name,password,message ) VALUES(?,?,?);

-- 질의sql
SELECT * FROM opn.guestbook_message;
-- SELECT * FROM opn.guestbook_message;

-- 삭제 sql
DELETE FROM `opn`.`guestbook_message` WHERE message_id=1;
-- DELETE FROM `opn`.`guestbook_message` WHERE message_id=?;

-- w전체 게시물의 개수 구하기
select count(*) from opn.guestbook_message;
-- select count(*) from guestbook_message;

-- 페이지 별 메시지 리스트
select * from opn.guestbook_message order by message_id desc limit 3,3;
-- select * from opn.guestbook_message order by message_id desc limit ?,?