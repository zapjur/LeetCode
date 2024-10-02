# Write your MySQL query statement below
SELECT a.name AS Employee FROM employee a, employee b
WHERE a.managerId = b.id AND a.salary > b.salary
