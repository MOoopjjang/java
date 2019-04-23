create table BOOK_AUTH(
	code int(11) not null auto_increment,
	userid varchar(20) not null,
	password varchar(256) not null,
	role varchar(20) not null,
	primary key(code)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;