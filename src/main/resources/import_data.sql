
--USER
insert into msched.user(user_id,username, password, enabled, role) values(1,'kloem', 'password', 1, 'ADMIN');
insert into msched.user(user_id,username, password, enabled, role) values(2,'dkheiv', 'password', 1, 'FACULTY');
insert into msched.user(user_id,username, password, enabled, role) values(3,'sean', 'tmptmp', 1, 'FACULTY');
insert into msched.user(user_id,username, password, enabled, role) values(4,'fitsum', 'pass222', 1, 'FACULTY');
insert into msched.user(user_id,username, password, enabled, role) values(5,'feven', 'pass111', 1, 'STUDENT');
insert into msched.user(user_id,username, password, enabled, role) values(6,'pukar', 'pass333', 1, 'STUDENT');

--Admin
insert into msched.admin(admin_id, first_name, last_name, email, user_id) values (1, 'Khemroat', 'Loem', 'kloem@mum.edu', 1);

--Faculty
insert into msched.faculty(faculty_id, first_name, last_name, email, user_id) values (1, 'Dora', 'Kheiv', 'dkheiv@mum.edu', 2);
insert into msched.faculty(faculty_id, first_name, last_name, email, user_id) values (2, 'Sean', 'Cake', 'scake@mum.edu', 3);
insert into msched.faculty(faculty_id, first_name, last_name, email, user_id) values (3, 'Fitsum', 'B', 'fb@mum.edu', 4);

--Faculty
insert into msched.student(student_id, first_name, last_name, email, user_id) values (1, 'Feven', 'E', 'fe@mum.edu', 5);
insert into msched.faculty(faculty_id, first_name, last_name, email, user_id) values (2, 'Pukar', 'M', 'mp@mum.edu', 6);

--Entry
insert into msched.entry(entry_id, name, entry_date, fpp_student_num, local_student_num, mpp_student_num, percent_ofcpt, percent_ofopt) values(1, 'August 2016', '2016-08-05', 50, 20, 50, 10, 10);
insert into msched.entry(entry_id, name, entry_date, fpp_student_num, local_student_num, mpp_student_num, percent_ofcpt, percent_ofopt) values(2, 'October 2016', '2016-10-28', 50, 20, 50, 10, 10);
insert into msched.entry(entry_id, name, entry_date, fpp_student_num, local_student_num, mpp_student_num, percent_ofcpt, percent_ofopt) values(3, 'January 2017', '2017-01-30', 50, 20, 50, 10, 10);

--Student 
insert into msched.student(student_id, email, first_name, last_name, gender, phone_no, snn, student_type, entry_entry_id, user_id) values (2, 'khievdora@gmail.com', 'Dora', 'Khiev', 1, '0976600719', '1234567897', 1, 2, 2);