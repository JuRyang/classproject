-- 입력 sql
INSERT INTO `opn`.`guestbook_message`(guest_name,password,message ) VALUES('test','1234','반갑습니다');

-- INSERT INTO guestbook_message (guest_name,password,message ) VALUES(?,?,?);

-- 질의sql
SELECT * FROM opn.guestbook_message;
-- SELECT * FROM opn.guestbook_message;

-- 삭제 sql
DELETE FROM `opn`.`guestbook_message` WHERE message_id=1;
-- DELETE FROM `opn`.`guestbook_message` WHERE message_id=?;


