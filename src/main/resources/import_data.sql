
--USER
insert into account(account_id,username, password, enabled, role, email) values(1,'kloem', 'password', true, 'ADMIN', 'kloem@mum.edu');
insert into account(account_id,username, password, enabled, role, email) values(2,'dora', 'password', true, 'ADMIN', 'dkheiv@mum.edu');
insert into account(account_id,username, password, enabled, role, email) values(3,'sean', 'tmptmp', true, 'FACULTY', 'scake@mum.edu');
insert into account(account_id,username, password, enabled, role, email) values(4,'fitsum', 'pass222', true, 'FACULTY', 'fb@mum.edu');
insert into account(account_id,username, password, enabled, role, email) values(5,'feven', 'pass111', true, 'ADMIN', 'fe@mum.edu');
insert into account(account_id,username, password, enabled, role, email) values(6,'pukar', 'pass333', true, 'STUDENT', 'mp@mum.edu');
insert into account(account_id,username, password, enabled, role, email) values(7,'stu', 'password', true, 'STUDENT', 'stu@mum.edu');
insert into account(account_id,username, password, enabled, role, email) values(8,'snolle', 'password', true, 'FACULTY', 'snolle@mum.edu');
insert into account(account_id,username, password, enabled, role, email) values(9,'dkheiv1', 'password', true, 'FACULTY', 'dkhiev1@mum.edu');
insert into account(account_id,username, password, enabled, role, email) values(10,'dora1', 'password', true, 'STUDENT', 'dkhiev@mum.edu');

--Admin
insert into admin(admin_id, first_name, last_name, account_id) values (1, 'Khemroat', 'Loem', 1);
insert into admin(admin_id, first_name, last_name, account_id) values (2, 'Feven', 'E', 5);
--Faculty
insert into faculty(faculty_id, first_name, last_name, account_id) values (1, 'Dora', 'Kheiv1', 9);
insert into faculty(faculty_id, first_name, last_name, account_id) values (2, 'Sean', 'Cake', 3);
insert into faculty(faculty_id, first_name, last_name, account_id) values (3, 'Fitsum', 'B', 4);
insert into faculty(faculty_id, first_name, last_name, account_id) values (4, 'Steve', 'Nolle', 8);

--Entry
insert into entry(entry_id, entry_date, fpp_student_num, local_student_num, mpp_student_num, percent_ofcpt, percent_ofopt) values(1, '2016-08-05', 50, 20, 50, 10, 10);
insert into entry(entry_id, entry_date, fpp_student_num, local_student_num, mpp_student_num, percent_ofcpt, percent_ofopt) values(2, '2016-10-28', 50, 20, 50, 10, 10);
insert into entry(entry_id, entry_date, fpp_student_num, local_student_num, mpp_student_num, percent_ofcpt, percent_ofopt) values(3, '2017-01-30', 50, 20, 50, 10, 10);
insert into entry(entry_id, entry_date, fpp_student_num, local_student_num, mpp_student_num, percent_ofcpt, percent_ofopt) values(4, '2017-08-30', 10, 10, 05, 0, 0);

--Student 
insert into student(student_id, first_name, last_name, account_id) values (1, 'Pukar', 'M', 6);
insert into student(student_id, first_name, last_name, account_id, entry_id) values (2, 'Stu', 'M', 7, 1);
insert into student(student_id,first_name, last_name, gender, snn, student_type, entry_id, account_id) values (3, 'Dora', 'Khiev', 1, '1234567897', 1, 1, 10);
--Table block
--insert into block(id, name, start_date, end_date, entry_id) values (1, 'October', '2016-10-05', '2016-10-05' , 1 );
--insert into block(id, name, start_date, end_date, entry_id) values (2, 'November', '2016-11-05', '2016-11-05' , 1 );
--insert into block(id, name, start_date, end_date, entry_id) values (3, 'December', '2016-12-05', '2016-12-22' , 1 );
--insert into block(id, name, start_date, end_date, entry_id) values (4, 'January', '2017-01-16', '2017-09-05' , 1 );
--insert into block(id, name, start_date, end_date, entry_id) values (5, 'February', '2017-02-10', '2017-09-05' , 1 );
--Table Course
insert into course(id, course_code, course_name, description, pre_reqiusite_id) values (1, 425,'SWE', 'Software Engineering', null);
insert into course(id, course_code, course_name, description, pre_reqiusite_id) values (2, 403,'DBMS', 'Database Management', null);
insert into course(id, course_code, course_name, description, pre_reqiusite_id) values (3, 402,'WAP', 'Web Programming', null);
insert into course(id, course_code, course_name, description, pre_reqiusite_id) values (4, 501,'WAA', 'Web Application Architecture', 3);
insert into course(id, course_code, course_name, description, pre_reqiusite_id) values (5, 502,'Big Data', 'Big Data', 2);
insert into course(id, course_code, course_name, description, pre_reqiusite_id) values (6, 503,'EA', 'Enterprise Architecture', null);
insert into course(id, course_code, course_name, description, pre_reqiusite_id) values (7, 401,'MPP', 'Modern Programming Practices', null);
insert into course(id, course_code, course_name, description, pre_reqiusite_id) values (8, 390,'FPP', 'Fundamental Programming Practices', null);


--insert into section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (1, 25, 15, 1, 3, 1);
--insert into section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (2, 25, 15, 1, 4, 2);
--insert into section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (3, 25, 15, 1, 2, 3);
--insert into section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (4, 25, 15, 1, 1, 4);

--insert into section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (5, 25, 15, 2, 3, 1);
--insert into section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (6, 25, 15, 2, 4, 2);
--insert into section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (7, 25, 15, 2, 2, 3);
--insert into section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (8, 25, 15, 2, 1, 4);

--faculty prefered block
--INSERT INTO prefered_blocks (faculty_faculty_id, prefered_blocks) VALUES (1, 1);
--INSERT INTO prefered_blocks (faculty_faculty_id, prefered_blocks) VALUES (1, 2);
--INSERT INTO prefered_blocks (faculty_faculty_id, prefered_blocks) VALUES (1, 3);
--INSERT INTO prefered_blocks (faculty_faculty_id, prefered_blocks) VALUES (1, 4);
--INSERT INTO prefered_blocks (faculty_faculty_id, prefered_blocks) VALUES (1, 5);


--faculty courses
--INSERT INTO faculty_courses (faculty_id, course_id) VALUES (1, 1);
--INSERT INTO faculty_courses (faculty_id, course_id) VALUES (1, 2);
