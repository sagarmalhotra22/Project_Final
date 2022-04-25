Set Serveroutput on;
Begin
--Admin data
pkg_Insert_Data.Proc_Insert_Admin(1234,'Course_Admin');
--select * from admin;
-- Department Data(100 to 108)
pkg_Insert_Data.insert_dept(dept_seq.NEXTVAL, 'College of Engineering');
pkg_Insert_Data.insert_dept(dept_seq.NEXTVAL, 'College of Science');
pkg_Insert_Data.insert_dept(dept_seq.NEXTVAL, 'College of Professional Studies');
pkg_Insert_Data.insert_dept(dept_seq.NEXTVAL, 'College of Law');
pkg_Insert_Data.insert_dept(dept_seq.NEXTVAL, 'College of Arts');
pkg_Insert_Data.insert_dept(dept_seq.NEXTVAL, 'College of Computer Science');
pkg_Insert_Data.insert_dept(dept_seq.NEXTVAL, 'College of Health Sciences');
pkg_Insert_Data.insert_dept(dept_seq.NEXTVAL, 'College of Social Science and Humainties');
pkg_Insert_Data.insert_dept(dept_seq.NEXTVAL, 'College of Business');

-- Program Data (200 to 217)
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 100, 'Master of Information Systems'); 
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 100, 'Master of Civil Engineering');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 101, 'Master of Applied Mathematics'); 
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 101, 'Master of Applied Physics and Engineering'); 
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 102, 'Master of Analytics');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 102, 'Master of Applied Machine Intelligence'); 
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 103, 'Master of Legal Studies'); 
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 103, 'Master of Media Advocacy'); 
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 104, 'Master of Journalism');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 105, 'Master of Science in Computer Science');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 104, 'Master of Urban Planning and Policy');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 105, 'Master of Science in Data Sciencce');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 106, 'Master of Science in Apploied Behavior Analysis');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 106, 'Master of Science in Applied Psychology');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 107, 'Master of Economics');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 107, 'Master of English');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 108, 'Master of Science in Finance');
pkg_Insert_Data.insert_program(Prog_Seq.Nextval, 108, 'Master of Science in Accounting');


--course data(300 to 353)
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,200, 'Application Design', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,200, 'Database Design', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,200, 'Agile Development', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,201, 'Design and Development of Modern Infrastructures', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,201, 'Advance Soil Mechanics', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,201, 'Construction Equipments and Modeling', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,202, 'Supply Chain Engineering', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,202, 'Simulation Analysis', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,202, 'Human Factors Engineering', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,203, 'Chemical Engineering Kinetics', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,203, 'Electrochemical Engineering', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,203, 'Biochemical Engineering', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,204, 'Biomedical Imaging', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,204, 'Biomedical Optics', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,204, 'Design of Implants', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 205, 'Numerical Analysis', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 205, 'Optimization and Complexity', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,205, 'Graph Theory', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 206, 'Electromagnetic Theory', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 206, 'Statistical Physics', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,206, 'Computational Physics', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 207, 'Bioinformatics Programming', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 207, 'Information Design and Visual Analytics', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,207, 'Collecting,Storing and Retriving Data', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 208, 'Glycobiology', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 208, 'Glycoprotein Analysis', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,208, 'Chemical Safety', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 209, 'Molecular Biology', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 209, 'Enzymology', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,209, 'Metabolism', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 210, 'Biology of Corals', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 210, 'Biology and Ecology of Fishes', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,210, 'Ocean and Costal Processes', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 211, 'Genes and Genomes', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 211, 'Cell Biology', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,211, 'Biostatistics', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 212, 'Astrophysics and Cosmology', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 212, 'Particle Physics', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,212, 'Condensed Matter Physics', 4);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 213, 'Predictive Analysis', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 213, 'Data Mining Applications', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,213, 'Risk Management for Analytics', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 214, 'Advanced Analytical Utilization', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 214, 'Finance Information Processing', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,214, 'AI communication and Visualization', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 215, 'Animation Basics', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 215, '3D Modeling', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,215, 'Character Animation', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 216, 'Nutrition Education', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 216, 'Pediatric Nutrition', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,216, 'Sports and Fitness Nutrition', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 217, 'Asset and Liability Management', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval, 217, 'Financial Ethics', 3);
pkg_Insert_Data.Insert_Course(Course_Seq.nextval,217, 'Investment Analysis', 3);


-- Country Data(700 to 712)
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'INDIA');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'USA');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'UK');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'CHINA');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'AUSTRALIA');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'PAKISTAN');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'SOUTH AFRICA');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'UAE');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'SRI LANKA');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'SOUTH KOREA');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'SINGAPORE');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'NIGERIA');
pkg_Insert_Data.Insert_Country(Country_Seq.nextval,'JAPAN');

