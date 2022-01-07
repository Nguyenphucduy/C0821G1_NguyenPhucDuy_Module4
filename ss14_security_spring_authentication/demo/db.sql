SELECT * FROM student_management.app_user;

--  tắt chế độ ràng buộc khóa ngoại
SET FOREIGN_KEY_CHECKS=0; 
INSERT INTO `student_management`.`app_user` (`user_id`, `enabled`, `encryted_password`, `user_name`) 
VALUES('1', '0', '$2a$12$j3BOY0h5.FDLfm469DAzIebR.zQ9izONnkaLk6qYPrVVU9j.PKVWG', 'phucduy');
