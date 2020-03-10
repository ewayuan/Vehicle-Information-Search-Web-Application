create table Make
(
	mid int primary key auto_increment, 
	make_name varchar(16) UNIQUE NOT NULL
);

INSERT INTO  Make values (1, 'BMW');
INSERT INTO  Make values (2, 'Mercedes-Benz');
INSERT INTO  Make values (3, 'Audi');

create table VehicleInfo
(
	vid int primary key auto_increment, 
	Year varchar(16) NOT NULL, 
	mid int NOT NULL, 
	model varchar(32) NOT NULL, 
	comb_cons DECIMAL(4,2), 
	foreign key (mid) REFERENCES Make(mid) 
    on delete cascade
    ON UPDATE CASCADE
);

INSERT INTO  VehicleInfo values (1, '2019',1,'M4 Cabriolet',12.7);
INSERT INTO  VehicleInfo values (2, '2019',1,'M4 Cabriolet Competition',12.7);
INSERT INTO  VehicleInfo values (3, '2019',1,'M4 Coupe',12.6);
INSERT INTO  VehicleInfo values (4, '2019',1,'M4 CS',12.6);
INSERT INTO  VehicleInfo values (5, '2019',1,'X3 M40i',8.7);

create table User
(
	uid int primary key auto_increment, 
	username varchar(16) UNIQUE NOT NULL,
	password varchar(16) NOT NULL,
    user_type varchar(16) NOT NULL
);



INSERT INTO  User values (1, 'w22yuan','yuanwei', 'Admin');
INSERT INTO  User values (2, 'h93yang','yaohaochen', 'Admin');
INSERT INTO  User values (3, 'x6lian','lianxin', 'Admin');
INSERT INTO  User values (4, 'x558li','nancy', 'Admin');
INSERT INTO  User values (5, 'manufacturer0','cs348', 'Manufacturer');
INSERT INTO  User values (6, 'manufacturer1','cs348', 'Manufacturer');
INSERT INTO  User values (7, 'manufacturer2','cs348', 'Manufacturer');
INSERT INTO  User values (8, 'customer0','cs348', 'Buyer');
INSERT INTO  User values (9, 'customer1','cs348', 'Buyer');
INSERT INTO  User values (10, 'customer2','cs348', 'Buyer');

create table Admin
(	
	uid int UNIQUE,
    user_type varchar(16),
	foreign key (uid) REFERENCES User(uid) ON delete CASCADE
);

INSERT INTO  Admin values (1, 'Admin');
INSERT INTO  Admin values (2, 'Admin');
INSERT INTO  Admin values (3, 'Admin');
INSERT INTO  Admin values (4, 'Admin'); 

create table Manufacturer
(
	uid int UNIQUE, 
	pid int UNIQUE auto_increment,
    user_type varchar(16) not null,
	foreign key (uid) REFERENCES User(uid) ON delete CASCADE ON UPDATE CASCADE
);


INSERT INTO  Manufacturer values (5, 1, 'Manufacturer');
INSERT INTO  Manufacturer values (6, 2, 'Manufacturer');
INSERT INTO  Manufacturer values (7, 3, 'Manufacturer');

create table Buyer
(	
	uid int UNIQUE, 
	cid int UNIQUE auto_increment,
    user_type varchar(16),
	foreign key (uid) REFERENCES User(uid)  on delete cascade
);

INSERT INTO  Buyer values (8, 1, 'Buyer');
INSERT INTO  Buyer values (9, 2, 'Buyer');
INSERT INTO  Buyer values (10, 3, 'Buyer');


create table Produce
(
	pid int,
	vid int, 
	PRIMARY KEY (pid, vid),
	foreign key (vid) REFERENCES VehicleInfo(vid)  on delete cascade,
    foreign key (pid) REFERENCES Manufacturer(pid) on delete cascade
);


INSERT INTO Produce values (1, 1);
INSERT INTO Produce values (1, 2);
INSERT INTO Produce values (1, 3);
INSERT INTO Produce values (2, 4);
INSERT INTO Produce values (3, 5);


create table Cart
(
	cid int, 
	vid int, 
    PRIMARY KEY (cid, vid),
	foreign key (vid) REFERENCES VehicleInfo(vid) on delete cascade,
    foreign key (cid) REFERENCES Buyer(cid)  on delete cascade
);

INSERT INTO Cart values (1, 1);
INSERT INTO Cart values (1, 2);
INSERT INTO Cart values (1, 3);
INSERT INTO Cart values (2, 1);
INSERT INTO Cart values (2, 5);
INSERT INTO Cart values (3, 1);
INSERT INTO Cart values (3, 3);


