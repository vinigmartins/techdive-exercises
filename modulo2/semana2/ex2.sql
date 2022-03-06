insert into university.alunos (mat_alu, nome, dat_entrada, cod_curso, cotista)
	values (123, 'vinicius', '2010-12-13', 1051, 's');
	
insert into university.cursos (cod_curso, nom_curso, cod_dpto)
	values (1051, 'ciencia da computacao', 321);
	
insert into university.departamentos (cod_dpto, nom_dpto)
	values (321, 'exatas');
	
insert into university.disciplinas (cod_disc, nom_disc, carga_horaria)
	values (4321, 'estrutura de dados', 20);
	
insert into university.matriculas (semestre, mat_alu, cod_disc, nota, faltas, status)
	values (680466, 123, 4321, 10, 3, 'A');
	
insert into university.matrizes_cursos (cod_curso, cod_disc, periodo)
	values (1057, 4657, 1);