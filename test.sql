-- Return (list) of users whose usernames are x558li
-- the list expected to have only one password
select * from carinfo.User where username = 'x558li';

-- Return (list) of users whose usernames are x558li, passwords are nancy
-- the list expected to have only one password
select * from carinfo.User where username = 'x558li' AND password = 'nancy';

-- select a specific user's car's cart
SELECT u.uid, v.vid, v.YEAR, v.mid, v.model, v.comb_cons
FROM Cart AS c, VehicleInfo AS v, User as u, Buyer AS b
WHERE u.username = 'customer0' 
AND u.password = 'çs348'
AND u.uid = b.uid
AND b.cid = c.cid
AND c.vid = v.vid;