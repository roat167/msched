
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
