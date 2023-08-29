use qlsv;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from `subject`
where credit = (select max(credit) from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select `subject` .*, mark.mark
from `subject`
left join mark on `subject`.sub_id = mark.sub_id
where mark = (select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT student.*, AVG(mark.mark) AS avg_mark
FROM student
LEFT JOIN mark ON student.student_id = mark.student_id
GROUP BY student.student_id
ORDER BY avg_mark DESC;