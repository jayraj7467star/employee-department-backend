-- Insert Departments
INSERT INTO department (id, name, location) VALUES ('dept01', 'Human Resources', 'Building A');
INSERT INTO department (id, name, location) VALUES ('dept02', 'Engineering', 'Building B');

-- Insert Employees
INSERT INTO employee (id, name, email, position, salary, department_id)
VALUES ('emp001', 'Alice Smith', 'alice.smith@example.com', 'Recruiter', 60000, 'dept01');

INSERT INTO employee (id, name, email, position, salary, department_id)
VALUES ('emp003', 'Charlie Brown', 'charlie.brown@example.com', 'HR Assistant', 40000, 'dept01');

INSERT INTO employee (id, name, email, position, salary, department_id)
VALUES ('emp002', 'Bob Johnson', 'bob.johnson@example.com', 'Software Engineer', 80000, 'dept02');

INSERT INTO employee (id, name, email, position, salary, department_id)
VALUES ('emp004', 'Diana Prince', 'diana.prince@example.com', 'System Architect', 90000, 'dept02');
