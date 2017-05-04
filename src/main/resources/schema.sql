create table User
(
	id int not null,
	first_name varchar(20),
	last_name varchar(20),
	dob date,
	login_id varchar(20),
	password varchar(20)
);

create table UserGlucoseHistory
(
	id int not null,
	userid int not,
	glucose_level int,
	lastmodified date
);