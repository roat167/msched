
--USER
insert into msched.user(user_id,username, password, enabled, role, email) values(1,'kloem', 'password', 1, 'ADMIN', 'kloem@mum.edu');
insert into msched.user(user_id,username, password, enabled, role, email) values(2,'dora', 'password', 1, 'ADMIN', 'dkheiv@mum.edu');
insert into msched.user(user_id,username, password, enabled, role, email) values(3,'sean', 'tmptmp', 1, 'FACULTY', 'scake@mum.edu');
insert into msched.user(user_id,username, password, enabled, role, email) values(4,'fitsum', 'pass222', 1, 'FACULTY', 'fb@mum.edu');
insert into msched.user(user_id,username, password, enabled, role, email) values(5,'feven', 'pass111', 1, 'ADMIN', 'fe@mum.edu');
insert into msched.user(user_id,username, password, enabled, role, email) values(6,'pukar', 'pass333', 1, 'STUDENT', 'mp@mum.edu');
insert into msched.user(user_id,username, password, enabled, role, email) values(7,'stu', 'password', 1, 'STUDENT', 'stu@mum.edu');
insert into msched.user(user_id,username, password, enabled, role, email) values(8,'snolle', 'password', 1, 'FACULTY', 'snolle@mum.edu');
insert into msched.user(user_id,username, password, enabled, role, email) values(9,'dkheiv', 'password', 1, 'FACULTY', 'dkhiev@mum.edu');
insert into msched.user(user_id,username, password, enabled, role, email) values(10,'dora1', 'password', 1, 'STUDENT', 'dkhiev@mum.edu');

--Admin
insert into msched.admin(admin_id, first_name, last_name, user_id) values (1, 'Khemroat', 'Loem', 1);
insert into msched.admin(admin_id, first_name, last_name, user_id) values (1, 'Feven', 'E', 5);
--Faculty
insert into msched.faculty(faculty_id, first_name, last_name, user_id) values (1, 'Dora', 'Kheiv', 9);
insert into msched.faculty(faculty_id, first_name, last_name, user_id) values (2, 'Sean', 'Cake', 3);
insert into msched.faculty(faculty_id, first_name, last_name, user_id) values (3, 'Fitsum', 'B', 4);
insert into msched.faculty(faculty_id, first_name, last_name, user_id) values (4, 'Steve', 'Nolle', 8);

--Entry
insert into msched.entry(entry_id, name, entry_date, fpp_student_num, local_student_num, mpp_student_num, percent_ofcpt, percent_ofopt) values(1, 'August 2016', '2016-08-05', 50, 20, 50, 10, 10);
insert into msched.entry(entry_id, name, entry_date, fpp_student_num, local_student_num, mpp_student_num, percent_ofcpt, percent_ofopt) values(2, 'October 2016', '2016-10-28', 50, 20, 50, 10, 10);
insert into msched.entry(entry_id, name, entry_date, fpp_student_num, local_student_num, mpp_student_num, percent_ofcpt, percent_ofopt) values(3, 'January 2017', '2017-01-30', 50, 20, 50, 10, 10);

--Student 
insert into msched.student(student_id, first_name, last_name, user_id) values (1, 'Pukar', 'M', 6);
insert into msched.student(student_id, first_name, last_name, user_id, entry_id) values (2, 'Stu', 'M', 7, 1);
insert into msched.student(student_id,first_name, last_name, gender, snn, student_type, entry_id, user_id) values (3, 'Dora', 'Khiev', 1, '1234567897', 1, 1, 10);
--Table block
insert into msched.block(id, name, start_date, end_date, entry_id) values (1, 'October', '2016-10-05', '2016-10-05' , 1 );
insert into msched.block(id, name, start_date, end_date, entry_id) values (2, 'November', '2016-11-05', '2016-11-05' , 1 );
insert into msched.block(id, name, start_date, end_date, entry_id) values (3, 'December', '2016-12-05', '2016-12-22' , 1 );
insert into msched.block(id, name, start_date, end_date, entry_id) values (4, 'January', '2017-01-16', '2017-09-05' , 1 );
insert into msched.block(id, name, start_date, end_date, entry_id) values (5, 'February', '2017-02-10', '2017-09-05' , 1 );
--Table Course
insert into msched.course(id, course_code, course_name, description, pre_reqiusite_id) values (1, 'cs425','SWE', 'Software Engineering', null);
insert into msched.course(id, course_code, course_name, description, pre_reqiusite_id) values (2, 'cs401','DBMS', 'Database Management', null);
insert into msched.course(id, course_code, course_name, description, pre_reqiusite_id) values (3, 'cs402','WAP', 'Web Programming', null);
insert into msched.course(id, course_code, course_name, description, pre_reqiusite_id) values (4, 'cs501','WAA', 'Web Application Architecture', 3);
insert into msched.course(id, course_code, course_name, description, pre_reqiusite_id) values (5, 'cs502','Big Data', 'Big Data', 2);
insert into msched.course(id, course_code, course_name, description, pre_reqiusite_id) values (6, 'cs503','EA', 'Enterprise Architecture', null);

insert into msched.section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (1, 25, 15, 1, 3, 1);
insert into msched.section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (2, 25, 15, 1, 4, 2);
insert into msched.section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (3, 25, 15, 1, 2, 3);
insert into msched.section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (4, 25, 15, 1, 1, 4);

insert into msched.section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (5, 25, 15, 2, 3, 1);
insert into msched.section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (6, 25, 15, 2, 4, 2);
insert into msched.section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (7, 25, 15, 2, 2, 3);
insert into msched.section(section_id, max_capacity, min_capacity, block_id, course_id, faculty_id) values (8, 25, 15, 2, 1, 4);
