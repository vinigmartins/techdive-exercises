-- TOTAL DE ALUNOS POR CURSO
select
    cursos.nom_curso as "nome do curso",
    count(alunos.mat_alu) as "total alunos"
from
    university.cursos as cursos
inner join university.alunos as alunos on
    alunos.cod_curso = cursos.cod_curso
group by
    cursos.nom_curso
order by
	"nome do curso" desc;
	
-- TOTAL DE FALTAS POR DISCIPLINA
select
    disciplina.nom_disc as "nome da disciplina",
    sum(matricula.faltas) as "total de faltas"
from
    university.matriculas as matricula
inner join university.disciplinas as disciplina on
    matricula.cod_disc = disciplina.cod_disc
group by
    disciplina.nom_disc
order by
    disciplina.nom_disc desc;