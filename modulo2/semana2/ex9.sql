-- TOTAL COTISTAS REPROVADOS POR DISCIPLINA
select
    disciplinas.nom_disc,
    count(1)
from
    university.matriculas as matriculas
inner join university.alunos as alunos on
    alunos.mat_alu = matriculas.mat_alu
inner join university.disciplinas as disciplinas on
    matriculas.cod_disc = disciplinas.cod_disc
where
    alunos.cotista = 'S'
    and matriculas.status = 'R'
group by
    disciplinas.nom_disc;

-- TOTAL COTISTAS POR DISCIPLINA
select
    disciplinas.nom_disc,
	count(1)
from
    university.matriculas as matriculas
inner join university.alunos as alunos on
    alunos.mat_alu = matriculas.mat_alu
inner join university.disciplinas as disciplinas on
    matriculas.cod_disc = disciplinas.cod_disc
where
    alunos.cotista = 'S'
group by
    disciplinas.nom_disc;