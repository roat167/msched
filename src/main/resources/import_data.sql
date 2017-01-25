--ROLE
insert into msched.role(role_id,name) values(0,'ADMIN');
insert into msched.role(role_id,name) values(1,'FACULTY');
insert into msched.role(role_id,name) values(2,'STUDENT');

insert into msched.user(user_id,username, password, role_id, enabled) values(0,'kloem', 'password', 0,1);
insert into msched.user(user_id,username, password, role_id, enabled) values(1,'dkheiv', 'password', 2,1);
insert into msched.user(user_id,username, password, role_id, enabled) values(2,'sean', 'tmptmp', 1,1);
insert into msched.user(user_id,username, password, role_id, enabled) values(3,'fitsum', 'pass222', 1,1);
insert into msched.user(user_id,username, password, role_id, enabled) values(4,'feven', 'pass111', 2,1);
insert into msched.user(user_id,username, password, role_id, enabled) values(5,'pukar', 'pass333', 2,1);
