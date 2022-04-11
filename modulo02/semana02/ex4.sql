select * from university.alunos
where cotista = 'N'
order by mat_alu;

select * from university.cursos
where cod_dpto = 123
order by nom_curso;

select * from university.departamentos
where cod_dpto between 100 and 300
order by cod_dpto desc;

select * from university.disciplinas
where carga_horaria < 30
order by carga_horaria;

select * from university.matriculas
where faltas > 3
order by faltas;

select * from university.matrizes_cursos
where periodo > 4
order by cod_curso;