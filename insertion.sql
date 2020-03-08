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
	comb_cons DECIMAL(4,1), 
	foreign key (mid) REFERENCES Make(mid)
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
	password varchar(16) NOT NULL
);

INSERT INTO  User values (1, 'w22yuan','yuanwei');
INSERT INTO  User values (2, 'h93yang','yaohaochen');
INSERT INTO  User values (3, 'x6lian','lianxin');
INSERT INTO  User values (4, 'x558li','nancy');
INSERT INTO  User values (5, 'manufacturer0','cs348');
INSERT INTO  User values (6, 'manufacturer1','cs348');
INSERT INTO  User values (7, 'manufacturer2','cs348');
INSERT INTO  User values (8, 'customer0','cs348');
INSERT INTO  User values (9, 'customer1','cs348');
INSERT INTO  User values (10, 'customer2','cs348');

create table Produce
(
	pid int,
	vid int, 
	PRIMARY KEY (pid, vid),
	foreign key (vid) REFERENCES VehicleInfo(vid)
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
	foreign key (vid) REFERENCES VehicleInfo(vid)
);

INSERT INTO Cart values (1, 1);
INSERT INTO Cart values (1, 2);
INSERT INTO Cart values (1, 3);
INSERT INTO Cart values (2, 1);
INSERT INTO Cart values (2, 5);
INSERT INTO Cart values (3, 1);
INSERT INTO Cart values (3, 3);


create table Admin
(	
	uid int UNIQUE, 
	foreign key (uid) REFERENCES User(uid)
);

INSERT INTO  Admin values (1);
INSERT INTO  Admin values (2);
INSERT INTO  Admin values (3);
INSERT INTO  Admin values (4); 

create table Manufacturer
(
	uid int UNIQUE, 
	pid int UNIQUE, 
	foreign key (uid) REFERENCES User(uid), 
	foreign key (pid) REFERENCES Produce(pid)
);

INSERT INTO  Manufacturer values (5, 1);
INSERT INTO  Manufacturer values (6, 2);
INSERT INTO  Manufacturer values (7, 3);

create table Buyer
(	
	uid int UNIQUE, 
	cid int UNIQUE, 
	foreign key (uid) REFERENCES User(uid),
	foreign key (cid) REFERENCES Cart(cid)
);

INSERT INTO  Buyer values (8, 1);
INSERT INTO  Buyer values (9, 2);
INSERT INTO  Buyer values (10, 3);
