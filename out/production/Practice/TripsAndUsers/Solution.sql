# Write your MySQL query statement below

SELECT

FROM Trips t
INNER JOIN Users u ON t.Client_Id = u.Users_Id AND u.Role = 'client' AND u.Banned = 'No'
WHERE t.Request_at IS BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY t.Request_at
