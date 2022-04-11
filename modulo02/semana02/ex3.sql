-- DUAS ATUALIZAÇÕES EM ALUNOS
update
    university.alunos
set
    mat_alu = 109
where mat_alu = 123;

update
    university.alunos
set
    cotista = 'N'
where mat_alu = 101;

-- DUAS ATUALIZAÇÕES EM CURSOS
update
    university.cursos
set
    nom_curso = 'biomedicina'
where nom_curso = 'praialogismo';

update
    university.cursos
set
    nom_curso = 'engenharia de transporte'
where nom_curso = 'lagoalogia';

-- DUAS ATUALIZAÇÕES EM DEPARTAMENTO
update
    university.departamentos
set
    nom_dpto = 'exatas dpto'
where nom_dpto = 'exatas';

update
    university.departamentos
set
    nom_dpto = 'exatas'
where nom_dpto = 'exatas dpto';

-- DUAS ATUALIZAÇÕES EM DISCIPLINA
update
    university.disciplinas
set
    carga_horaria = 32
where cod_disc = 5124;

update
    university.disciplinas
set
	nom_disc = 'calculo 2'
where nom_disc = 'calculo';

-- DUAS ATUALIZAÇÕES EM MATRICULAS
update
    university.matriculas
set
    faltas = 1
where mat_alu = 105;

update
    university.matriculas
set
    mat_alu = 108
where mat_alu = 123;

-- DUAS ATUALIZAÇÕES EM MATRIZES_CURSOS
update
    university.matrizes_cursos
set
    periodo = 2
where cod_disc = 4657;

update
    university.matrizes_cursos
set
    periodo = 1
where cod_disc = 4321;