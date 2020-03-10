delimiter $$

create trigger CheckUserType
before insert on User
for each row
BEGIN 
	IF (NEW.user_type not in ('Admin','Manufacturer','Buyer')) THEN SET NEW.user_type = NULL;
    END IF;
END;$$


delimiter $$

CREATE TRIGGER Insert_in_children_table After INSERT ON User
       FOR EACH ROW 
       begin
       if new.user_type = 'Buyer' then
	       INSERT INTO Buyer(uid,user_type) values (new.uid,new.user_type);
	   elseif new.user_type = 'Manufacturer' then
		   Insert into Manufacturer(uid,user_type) values (new.uid,new.user_type);
	   elseif new.user_type(uid,user_type) = 'Admin' then
		   Insert into Admin values (new.uid,new.user_type);
           
       end if;
       end$$


/*child table check type*/
CREATE TRIGGER Manufacturer_check_type BEFORE INSERT ON Manufacturer
       FOR EACH ROW 
       begin
       if new.user_type != 'Manufacturer' then
       set new.user_type = NULL;
       end if;
       end$$

       
CREATE TRIGGER Buyer_check_type BEFORE INSERT ON Buyer
       FOR EACH ROW 
       begin
       if new.user_type != 'Buyer' then
       set new.user_type = NULL;
       end if;
       end$$
       
CREATE TRIGGER Admin_check_type BEFORE INSERT ON Admin
       FOR EACH ROW 
       begin
       if new.user_type != 'Admin' then
       set new.user_type = NULL;
       end if;
       end$$

delimiter ;



