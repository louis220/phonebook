-- Q1.
SELECT last_name, salary, department_name
FROM employees emp , departments dep
WHERE emp.department_id = dep.department_id(+)
 AND commission_pct IS NOT NULL;

-- Q2.
SELECT emp.last_name, emp.salary, emp.job_id
FROM employees emp, employees mng
WHERE emp.manager_id = mng.employee_id
AND mng.last_name = 'King';


-- Q3.
SELECT emp.last_name, emp.salary
FROM employees emp, employees mng
WHERE emp.manager_id = mng.employee_id AND emp.salary > mng.salary;


-- Q4.
SELECT MIN(salary), MAX(salary), SUM(salary), ROUND(AVG(salary))
FROM employees;


-- Q5.
SELECT emp.last_name, emp.salary
FROM employees emp, 
(SELECT department_id, avg(salary) salary
    FROM employees 
    GROUP BY department_id) sal
WHERE emp.department_id = sal.department_id
    AND emp.salary < sal.salary;

