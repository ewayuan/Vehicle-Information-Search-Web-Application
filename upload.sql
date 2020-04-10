create table VehicleInfo
(
	Year varchar(16) NOT NULL, 
	mid int NOT NULL, 
	model varchar(32) NOT NULL, 
	VehicleClass varchar(30),
	EngineSize decimal(2,1),
	Cylinders int,
    FuelType varchar(25),
    City decimal(4,2),
    Hwy decimal(4,2),
    Comb DECIMAL(4,2), 
    CO2Rating int,
    SmogRating int,
    vid int primary key auto_increment,
	foreign key (mid) REFERENCES Make(mid) 
    on delete cascade
    ON UPDATE CASCADE
);

create table Make
(
	mid int primary key auto_increment, 
	make_name varchar(16) UNIQUE NOT NULL
);