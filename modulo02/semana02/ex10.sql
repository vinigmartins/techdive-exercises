select
    *
from
    university.matriculas as matriculas
inner join university.alunos as alunos on
    alunos.mat_alu = matriculas.mat_alu;

select
    *
from
    university.matriculas as matriculas
left join university.alunos as alunos on
    alunos.mat_alu = matriculas.mat_alu;

select
    *
from
    university.matriculas as matriculas
right join university.alunos as alunos on
    alunos.mat_alu = matriculas.mat_alu;

select
    *
from
    university.matriculas as matriculas
full outer join university.alunos as alunos on
    alunos.mat_alu = matriculas.mat_alu;