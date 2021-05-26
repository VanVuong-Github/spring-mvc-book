create database bookdb

use bookdb

create table Book
(
	id int primary key identity(1,1),
	name nvarchar(255) not null,
	author nvarchar(255) not null,
	publishYear int not null,
	rating float not null,
	image nvarchar(max)
)